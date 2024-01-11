package com.ohgiraffers.section01.method;

public class Application3 {

//    int global = 10;                                     // 전역변수
    static int global = 10;                                // static 에서 static 안붙은 변수를 호출하려면 static 붙여줘야함

    public static void main(String[] args) {

        int global = 20;                                 // 지역변수가 전역변수 보다는 우선순위가 높다
        System.out.println("global 출력 : " + global);
        System.out.println("global 출력 : " + Application3.global);       // 클래스명.변수명을 하면 클래스 변수를 호출할 수 있다.
        /* 수업목표. 메소드 전달 인자와 매개변수에 대해 이해하고 메소드 호출 시 활용할 수 있다. */
        /* 필기.
         *   전달인자(argument)와 매개변수(parameter)를 이용한 메소드 호출
         *   지금까지 배워 왔던 변수는 지역변수에 해당된다
        * */

        /* 필기.
         *  변수의 종류(자료형과는 다른 구분 방식)
         *   1. 지역변수 : 메소드 내에서만 적용되는 변수
         *   2. 매개변수 : 전달인자를 받는 지역 변수
         *   3. 전역변수(필드) : 클래스 전체에서 사용 가능한 변수
         *   4. 클래스(static) 변수 : 전역 변수 중 static 이 붙어서 클래스명.변수명 으로 가져와서 사용할 수 있는 변수
        * */
        Application3 app3 = new Application3();
        app3.testMethod(10);                                // 10은 전달인자 (argument)
        app3.testMethod(19);
//        app3.testMethod(15, 16);                                  // parameter 정의와 맞지 않은 값 입력시 에러
        app3.testMethod('a');
        app3.testMethod((int)12.34);
        app3.testMethod(3 * 2);
    }

    /* 설명. 정수를 주면 나이를 출력해주는 기능을 가진 메소드(non-static)*/
    public void testMethod(int age){                            // int age 는 전달인자를 받는 지역변수인 매개변수 이다
        System.out.println("당신의 나이는 " + age + "세 입니다.");
    }
}
