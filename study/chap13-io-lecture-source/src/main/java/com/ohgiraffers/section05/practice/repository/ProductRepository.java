package com.ohgiraffers.section05.practice.repository;

import com.ohgiraffers.section05.practice.aggregate.Product;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ProductRepository {

    private ArrayList<Product> productList = new ArrayList();    // db에 입력될 자료들이 담길 array list 생성


    // ProductRepository 생성에 사용할 생성자
    public ProductRepository() {

        ArrayList<Product> products = new ArrayList<>();
        /* 더미 데이터 생성 */
        products.add(new Product("p01", "dummy1", "dummy1-brand", 10000, 10, 10, 10));
        products.add(new Product("p02", "dummy2", "dummy2-brand", 22000, 22, 22, 22));
        products.add(new Product("p03", "dummy3", "dummy3-brand", 30000, 30, 30, 30));

        //DB에 넣을 데이터를 저장하는 메소드 생성
        addNewProduct(products);
    }


    private void addNewProduct(ArrayList<Product> products) {

        /* DB로 내보낼 객체 스트림 생성 */
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("src/java/com/ohgiraffers/section05/practice/db/productDB.txt")));

            oos.writeObject(getInfo);

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
}
