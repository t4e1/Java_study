package com.ohgiraffers.section01.xmlmapper;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ElementService elementService = new ElementService();
        do {
            System.out.println("====== mapper elements test menu ======");
            System.out.println("1. <resultMap> 테스트");
            System.out.print("메뉴 번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 :
                    resultMapSubMenu();
                    break;
                case 9 :
                    return;
            }

        } while (true);


    }

    private static void resultMapSubMenu() {
        Scanner sc = new Scanner(System.in);
        ElementService elementService = new ElementService();

        do {
            System.out.println("====== 1. <resultMap> test menu ======");
            System.out.println("1. <resultMap> 테스트");
            System.out.println("2. <association> 테스트");
            System.out.println("3. <collection> 테스트");
            System.out.print("메뉴 번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 :
                    elementService.selectResultMapTest();
                    break;
                case 2 :
                    elementService.selectResultMapAssociationTest();
                    break;
                case 3 :
                    elementService.selectResultMapCollectionTest();
                    break;
                case 9 :
                    return;
            }

        } while (true);
    }
}
