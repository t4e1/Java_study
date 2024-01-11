package com.ohgiraffers.section02.variable;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. 변수를 선언하고 값을 할당하여 사용할 수 있다.(feat. 자료형(type)) */
        /* 필기.
         *  변수를 사용하는 방법.
         *    1. 변수 선언
         *    2. 변수에 값을 대입 (값 대입 및 초기화)
         *    3. 변수 사용
        * */
        /* 목차. 1. 변수 선언 (declare) */
        /* 설명. 자료형이란?
         *  다양한 값의 형태별로 어느 정도의 크기를 하나의 값으로 취급할 것인지 미리 Compiler와 약속한 키워드
         *  이러한 자료형은 기본 자료형(Primary Type)과 참조 자료형(Reference Type)으로 나뉜다.
         *  먼저, 기본 자료형 8가지를 알아본다.
        * */

        /*설명. 정수를 취급하는 자료형 */
        byte bnum;                  // 1 byte -127 ~ 127
        short snum;                 // 2 byte
        int inum;                   // 4 byte 대략 21억 까지의 숫자를 표현 가능
        long lnum;                  // 8 byte int 이상의 값을 표현할 때

        /*설명. 실수를 취급하는 자료형 */
        float fnum;                 // 4 byte 소수점 8자리 까지 표현 가능
        double dnum;                // 8 byte 소수점 14자리 까지 표현 가능

        /*설명. 문자를 취급하는 자료형 */
        char ch;                    // 2 byte 한글 기준 44000자 정도 표현 가능

        /*설명. 논리값을 취급하는 자료형 */
        boolean isTrue;             // 1 byte

        /* 설명. 문자열은 참조 자료형이다.(feat. 대문자로 시작) */
        String str;                 // 4 byte 모든 참조 자료형은 4 byte

        /* 목차. 2. 변수에 값을 대입 (초기화 or initialization)*/
        /* 설명.
         *   java는 정수형을 받아 들일 때 처음에는 무조건 int 로 받아들인다.
         *   마찬가지로 실수형을 받아 들일 때는 무조건 double 로 생각해 받아들인다.
         *   byte 를 포함하고 싶을때 정석적으로는 bnum = (byte) 1; 와 같이 담아야함
         *   선언한 변수의 자료형에 따라 자동형변환이 일어나기 때문에 (byte)등을 기입할 필요는 없다.
         * */
        bnum = 1;
        snum = 2;
        inum = 4;
        lnum = 2200000000L;                  // int의 한계값을 넘는 값을 넣으려면 (21억xxx 이상) L을 붙여야 에러가지 발생하지 않음

        fnum = 4.0f;                // 더 큰 double을 float에 넣으려고 하니 f를 붙이지 않으면 에러가 발생한다. (30평 집의 가구를 전부 고시원에 넣으려면 문제가 발생하는 것과 같다)
        dnum = 8.0;

        ch = 'a';                   // char 자료형은 양수만 받아들일 수 있다.(유니코드로 받기 때문)
        ch = 97;
//        ch = -97;                 // 문자 자료형에 음수 사용 시 컴파일 에러 발생
        isTrue = true;


        /* 목차. 3. 변수 사용 */
        System.out.println("bnum = " + bnum);
        System.out.println("lnum = " + lnum);
        System.out.println("isTrue = " + isTrue);
        System.out.println("lnum과 int의 합 = " + (lnum + inum));      // 더 큰 데이터 타입으로 형변환되서 연산된다.

        /* 설명. 변수의 선언과 초기화는 한번에 가능 */
        int kor = 90;
        int math = 80;
        int eng = 75;

        int sum = kor + math + eng;
        double avg = sum/3;         // 'sum/3' = int/int 기 때문에 int 형으로 계산됨 -> 소수점이하를 버림 -> 이후 double 의 변수에 넣을 때 실수형으로 변환되어 .0을 붙여줌
        double avg2 = sum/3.0;      // /sum/3.0' = int/double 이기 때문에 더 큰 자료형이 double 형으로 결과를 내줌 (81.6666..)
                                    // 나눗셈을 할 때는 소수점을 고려해야 한다. (하나라도 float or double 형이어야 한다.)

        System.out.println("종합 : " + sum);
        System.out.println("평균 : " + avg);
        System.out.println("평균 : " + avg2);
    }
}
