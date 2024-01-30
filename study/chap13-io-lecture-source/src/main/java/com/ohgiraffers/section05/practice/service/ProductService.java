package com.ohgiraffers.section05.practice.service;

import com.ohgiraffers.section05.practice.aggregate.Product;
import com.ohgiraffers.section05.practice.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private final ProductRepository pr = new ProductRepository();

    /* 새 상품 등록
     * 1. 기존 상품 조회해서 마지막 상품코드(PK)반환
     * 2. 반환한 PK 받아와서 +1
     * 3. +1 시킨 값 repo로 전달
     * 4. repo에서 db로 전달
    * */
    public void addProduct(Product getInfo) {

        /* 상품 코드 읽어와서 +1 시키는 (PK값 만드는) 기능 추가 필요 - 파싱은 컨트롤러 영역? 나중에 만들때는 분리하기 */
        ArrayList<Product> productList = pr.selectAllProducts();            // 모든 상품 리스트 반환

        Product lastestProduct = productList.get((productList.size()-1));   // 상품 리스트에서 마지막 상품 담을 객체 생성

        getInfo.setProductCode(lastestProduct.getProductCode() + 1);        // 마지막 상품의 상품 코드 + 1을 getInfo의 상품 코드에 초기화

        if (pr.saveProduct(getInfo) == 1){                                  // 함수 실행 & 리턴 값이 1인 경우 성공 메시지 반환
            System.out.println(getInfo.getName() + "상품이 정상적으로 등록되었습니다.");
        }
    }

    public void selectProduct(int productCode) {

        List<Product> selectList = pr.selectAllProducts();
        for(int i = 0; )

        System.out.println("서비스단까지 테스트");
        System.out.println("선택하신 상품 정보: " +  pr.selectAllProducts().get(productCode));
    }

    public void selectAllProducts() {

        ArrayList<Product> selectAllProduct = pr.selectAllProducts();
        selectAllProduct.stream().forEach(x -> System.out.println(x));

    }
}
