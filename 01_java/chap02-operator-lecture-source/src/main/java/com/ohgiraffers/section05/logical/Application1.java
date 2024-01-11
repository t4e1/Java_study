package com.ohgiraffers.section05.logical;

public class Application1 {

    public static void main(String[] args) {

        /* 수업목표. 논리연산자에 대해 이해하고 활용할 수 있다. */
        /* 필기.
         *   논리 연산자
         *   논리값(true or false)를 취급하는 연산자
         *  -------------------------------------------
         *   논리 연산자의 종류
         *   1. 논리 연결 연산자 : 두 개의 피연산자를 가지는 이항 연산자이며, 연산자의 결합 방향은 왼쪽에서 오른쪽
         *                      두 개의 논리식을 판단하여 참과 거짓을 판단
         *      1-1. && (논리 AND) : 두 개의 논리식 모두 참일 경우 참을 반환, 둘 중 하나라도 거짓인 경우 거짓을 반환
         *      1-2. || (논리 OR) : 두 개의 논리식 중 하나라도 참일 경우 참을 반환, 둘 모두 거짓인 경우 거짓을 반환
         *   2. 논리 부정 연산자 : 피연산자가 하나인 단항연산자로, 피연산자의 결합 방향은 왼쪽에서 오른쪽
         *      2-1. !(논리 NOT) : 논리식의 결과가 참이면 거짓을, 거짓이면 참을 반환
         * */

        /* 목차. 1. 논리 연산자 결과값 확인 */
        System.out.println(true && true);
        System.out.println(true && false);
        System.out.println(false && true);
        System.out.println(false && false);

        System.out.println(true || true);
        System.out.println(true || false);
        System.out.println(false || true);
        System.out.println(false || false);

        System.out.println(!true);
        System.out.println(!false);

        /* 목차. 2. 논리식에 논리 연산자 활용 */
        int num1 = 10;
        int num2 = 20;
        int num3 = 30;
        int num4 = 40;

        System.out.println(num1 < num2 && num3 < num4);         // 우선순위
        System.out.println(num1 < num2 && num3 > num4);         // 단산시 교비논 삼대
        System.out.println(num1 > num2 && num3 < num4);         // && > ||
        System.out.println(num1 > num2 && num3 > num4);

        System.out.println(num1 < num2 || num3 < num4);
        System.out.println(num1 < num2 || num3 > num4);
        System.out.println(num1 > num2 || num3 < num4);
        System.out.println(num1 > num2 || num3 > num4);

    }
}
