package com.ohgiraffers.section05.practice.repository;

import com.ohgiraffers.section05.practice.aggregate.Product;
import com.ohgiraffers.section05.practice.stream.MyOutputStream;

import java.io.*;
import java.util.ArrayList;

public class ProductRepository implements Serializable {

    private ArrayList<Product> productList = new ArrayList();    // db에 입력될 자료들이 담길 array list 생성

    File saveDataPath = new File("src/main/java/com/ohgiraffers/section05/practice/db/productDB.txt");

    // ProductRepository 생성에 사용할 생성자
    public ProductRepository() {

        ArrayList<Product> products = new ArrayList<>();
        /* 더미 데이터 생성 */
        products.add(new Product(1, "dummy1", "dummy1-brand", 10000, 10, 10, 10));
        products.add(new Product(2, "dummy2", "dummy2-brand", 22000, 22, 22, 22));
        products.add(new Product(3, "dummy3", "dummy3-brand", 30000, 30, 30, 30));

        if(productList.isEmpty()) firstSaveProduct(products);
        loadProduct();


    }

    /* 최초 실행 시 더미 값 입력받아서 DB에 저장 */
    public void firstSaveProduct(ArrayList<Product> products){
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(saveDataPath)));

            /* Product 타입으로 생성자의 products 리스트를 하나씩 받아와서 파일에 전부 출력 */
            for(Product product : products){
                oos.writeObject(product);
            }

            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* 입력받은 값 DB에 입력(이어쓰기) */
    public int saveProduct(Product getInfo) {
        MyOutputStream mos = null;

        try {
            mos = new MyOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(saveDataPath, true)));

            productList.add(getInfo);
            mos.writeObject(getInfo);

            mos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(mos != null) mos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return 1;
    }

    /* DB에서 상품 데이터 읽어와서 서버 productList 에 초기화하는 메소드 */
    public void loadProduct() {
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(saveDataPath)));

            while (true) {
                productList.add((Product) (ois.readObject()));
            }

        /* 예외처리 EOFException 이랑 ClassNotFoundException 왜 사용하는지 알아보기 */
        } catch (EOFException e){
            return;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<Product> selectAllProducts() {
        return productList;
    }
}

