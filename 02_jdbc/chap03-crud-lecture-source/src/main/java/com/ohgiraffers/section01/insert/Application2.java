package com.ohgiraffers.section01.insert;

import java.util.Scanner;

/* 설명.
 *  Service 계층과 Repository 계층을 구분하고 XML 파일에서부터 쿼리를 불러와서
 *  insert 해보기
* */
public class Application2 {

    /* 설명. view이자 controller(하나의 Menu 객체로 만들기) 개념인 main 에서부터 시작 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /* 설명. 웹페이지 부분 ( 사용자가 정보 입력 ) */
        System.out.print("메뉴의 이름을 입력하세요 : ");
        String menuName = sc.nextLine();
        System.out.print("메뉴의 가격을 입력하세요 : ");
        int menuPrice = sc.nextInt();
        System.out.print("카테고리 코드를 입력하세요 : ");
        int categoryCode = sc.nextInt();
        System.out.print("판매 상태를 입력하세요 : ");
        sc.nextLine();
        String orderableStatus = sc.nextLine();

        /* 설명. 컨트롤러 부분. 입력받은 4개로 각각의 값이 들어간 하나의 메뉴 객체를 생성 */
        /* 사용자가 입력한 값을 각각의 자료형에 맞게 묶어서 하나의 객체를 생성, service에 던지는거 까지가 controller의 역할 */
        Menu registMenu = new Menu(menuName, menuPrice, categoryCode, orderableStatus);

        MenuService service = new MenuService();
        service.registMenu(registMenu);


    }
}
