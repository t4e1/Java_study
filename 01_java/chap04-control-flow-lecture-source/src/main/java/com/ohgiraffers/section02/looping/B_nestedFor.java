package com.ohgiraffers.section02.looping;

import javax.xml.stream.events.StartDocument;
import java.util.Scanner;

public class B_nestedFor {
    public void testNestedForStatement() {
        /* 수업목표. 중첩된 for문의 흐름을 이해하고 적용할 수 있다. */

        /* 설명.
         *   2단
         *   2 * 1 = 2
         *   2 * 2 = 4
         *   2 * 3 = 6
         *   ...
         *   9 * 7 = 63
         *   9 * 8 = 72
         *   9 * 9 = 81
         * */

        for (int i = 2; i < 10; i++) {

            System.out.println(i + "단수의 곱");
            for (int j = 1; j < 10; j++) {
                System.out.println((i + " * " + j + " = " + (i * j)));
            }
            System.out.println(" ");
        }
    }


    public void printUpgradeGugudanFromTwoToNine() {

        /* 수업목표. inner for 문을 메소드로 따로 모듈화 해보자 ( 하나의 기능 단위로 보고 ) */
        for (int dan = 2; dan < 10; ++dan) {
            System.out.println(dan + "수 출력");
            printGugudanOf(dan);
            System.out.println();
        }
    }

    private void printGugudanOf(int dan) {
        for (int su = 1; su < 10; su++) {
            System.out.println((dan + " * " + su + " = " + (dan * su)));
        }
    }

    public void printStars() {

        /* 설명. 아래와 같은 별모양이 나오도록 작성해 보자.
         *    정수를 입력하시오 : 5
         *      *
         *     **
         *    ***
         *   ****
         *  *****
        * */

        /* 1. 그림은 행 단위로 그린다
         * 2. 중첩 for문에서 출력은 안쪽 for문에서 뿌리는 것
         * 3. 출력을 2종류 해야한다면 안쪽 for 문은 2종류를 만든다.
        * */
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하시오 : ");
        int input = sc.nextInt();

        for (int i = 1; i <= input; i++){

            /* 설명. 공백 출력용 안쪽 for문(input - i) */
//            for (int j = 1; j <= input - i; j++){
//                System.out.print(" ");
//            }
            printSpace(input, i);
            /* 설명. 별 출력용 안쪽 for문(i)*/
//            for(int j = 1; j <= i; j++){
//                System.out.print("*");
//            }
//            System.out.println();
            printStar(i);
        }


//        int i;
//        int j;
//        String stars = "";
//        String space = "";
//
//        for(i = 1; i <= 5 ; i++){
//            stars += "*";
//            for(j = 4; j >= 0; j-- ){
//                space += " ";
//                System.out.print(space);
//            }
//            System.out.println(stars);
//            System.out.println(" ");
//        }

    }

    private void printStar(int i) {
        for(int j = 1; j <= i; j++){
            System.out.print("*");
          }
          System.out.println();
    }

    private void printSpace(int input, int i) {
        for (int j = 1; j <= input - i; j++){
            System.out.print(" ");
        }
    }
}