package com.ohgiraffers.section05.practice.run;

import com.ohgiraffers.section05.practice.aggregate.Product;
import com.ohgiraffers.section05.practice.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static final ProductService ps = new ProductService();      // 뷰와 연결된 서비스 레이어 객체 생성

    public static void main(String[] args) {

        // 재고 관리 기능 구현해보기
        // 메뉴 출력을 위한 do-while 문 사용
        do {
            Scanner sc = new Scanner(System.in);

            System.out.println(" ======== 재고 관리 프로그램 ======== ");
            System.out.println("1.상품 추가");
            System.out.println("2.상품 제거");
            System.out.println("3.상품 목록 조회");
            System.out.println("4.상품 목록 전체 조회");
            System.out.println("5.입고");
            System.out.println("6.출고");
            System.out.println("7.조정");
            System.out.println("8.입출고 이력");
            System.out.println("9.프로그램 종료");
            System.out.println(" ================================= ");
            System.out.print("원하시는 번호를 입력해 주세요: ");
            int input = sc.nextInt();

            switch(input) {
                case 1 : ps.addProduct(getInfo()); break;
                case 2 :
                case 3 : ps.selectProduct(getProductNumber()); break;
                case 4 : ps.selectAllProducts(); break;
                case 5 :
                case 6 :
                case 7 :
                case 8 :
                case 9 : return;             // 프로그램 종료(9)를 받으면 바로 return 시켜서 main 메소드 종료
            }

        } while (true);

    }

    /* 상품 조회에 사용할 상품 코드 입력용 메소드 */
    private static int getProductNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.print("조회하실 상품 번호를 입력해 주세요: ");
        return sc.nextInt();
    }

    /* 상품 등록시 사용할 상품 정보 입력 메소드 */
    private static Product getInfo() {
        Product newInfo = null;
        Scanner sc = new Scanner(System.in);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
        System.out.print("상품명을 입력해 주세요: ");
        String productName = sc.nextLine();
        System.out.print("상품의 브랜드를 입력해 주세요: ");
        String productBrand = sc.nextLine();
        System.out.print("상품 가격을 입력해 주세요: ");
        int productPrice = sc.nextInt();
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<");

        newInfo = new Product(productName, productBrand, productPrice);

        return newInfo;
    }

}
