package com.ohgiraffers.section02.package_and_import;

import com.ohgiraffers.section01.method.Calculator;

public class Application1 {

    public static void main(String[] args) {

        /* 수업목표. 패키지에 대해서 이해할 수 있다. */
        com.ohgiraffers.section01.method.Calculator cal
                = new com.ohgiraffers.section01.method.Calculator();

        /*목차. 1. non-static method 호출 */
        int plusResult = cal.plusTwoNumbers(100, 20);
        System.out.println("plusResult = " + plusResult);

        /*목차. 2. static method 호출 */
        int maxResult
                = com.ohgiraffers.section01.method.Calculator.maxNumberOf(100, 20);
        System.out.println("maxResult = " + maxResult);

    }
}
