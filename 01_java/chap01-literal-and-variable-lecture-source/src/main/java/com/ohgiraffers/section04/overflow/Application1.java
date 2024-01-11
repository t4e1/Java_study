package com.ohgiraffers.section04;

public class Application1 {

    public static void main(String[] args) {

        /* 수업목표. 오버플로우에 대해 이해할 수 있다. */
        /* 필기.
         *   자료형 별 값의 최대 범위를 벗어나는 경우
         *   발생한 carry를 버림처리 하고 sign bit를 반전시켜 최소값으로 순환시킴
         * */

        /* 목차. 1. 오버플로우 */
        byte num1 = 126;                        // byte 자료형의 양의 최대 저장 범위 값

        num1++;                                 // num1 = num1 + 1 과 의미상 같음 ( 속도는 ++가 더 빠르다 )
        System.out.println("num1 = " + num1 );

        num1++;
        System.out.println("num1 = " + num1 );  // 최대 저장 범위값을 넘어가면서 부호비트를 변경함

        num1++;
        System.out.println("num1 = " + num1 );  // -128 에서 1을 더하니 -127 이 됨

        /* 목차. 2. 언더플로우 */
        byte num2 = -127;

        num2--;
        System.out.println("num2 = " + num2);

        num2--;
        System.out.println("num2 = " + num2);

        num2--;
        System.out.println("num2 = " + num2);

        /* 설명.
         *   일반적으로 많이 사용하는 int형의 최대값은 대략 21억 정도
         *   이 범위를 벗어난 계산은 오버플로우를 발생시켜 원하지 않는 결과값이 나오게 될 수 있다.
         * */
        int firstNum = 1000000;                 // 100만
        int secondNum = 700000;                 // 70만

        int multi = firstNum * secondNum;       // 예상값 = 7천억
//        int multi2 = 1000000 * 700000;          // 변수가 아니라 특정 값을 입력하면 int값을 벗어나는 범위를 컴파일이 인지함
        System.out.println("firstNum * secondNum = " + multi);

    }

}
