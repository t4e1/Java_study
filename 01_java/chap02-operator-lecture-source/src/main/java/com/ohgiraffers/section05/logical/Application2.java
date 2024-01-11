package com.ohgiraffers.section05.logical;

public class Application2 {

    public static void main(String[] args) {

        /* 목차. 1. 1부터 100 사이 값 확인 */
        int num1 = 55;
        int num2 = 101;
        System.out.println(num1 >= 1 && num1 <= 100);
        System.out.println(num2 >= 1 && num2 <= 100);

        /* 목차. 2. 영어 대문자인지 확인 */
        char ch1 = 'G';
        char ch2 = 'g';
        System.out.println(ch1 >= 'A' && ch1 <= 'Z');
        System.out.println(ch2 >= 'A' && ch2 <= 'Z');

        /* 목차. 3. 대소문자 상관 없이 영문자 'y'인지 확인 */
        char ch3 = 'y';
        char ch4 = 'Y';
        char ch5 = 'n';
        System.out.println(ch3 == 'y' || ch3 == 'Y');
        System.out.println(ch4 == 'y' || ch4 == 'Y');
        System.out.println(ch5 == 'y' || ch5 == 'Y');

        /* 목차. 4. 영문자인지 확인하는 조건식 */
        char ch6 = '`';                                 // 싱글 쿼테이션 하나를 문자로 나타내고 싶을때는
        char ch7 = 'o';                                 //  이스케이프 문자인 \를 사용한다 (\')
        System.out.println(ch6 >= 'a' && ch6 <= 'z' || ch6 >= 'A' && ch6 <= 'Z');
        System.out.println(ch6 >= 'A' && ch6 <= 'z');   // A ~ z 사이에 다른 특수기호가 들어가기 때문에 포함됨
        System.out.println(ch7 >= 'a' && ch7 <= 'z' || ch7 >= 'A' && ch7 <= 'Z');
    }
}
