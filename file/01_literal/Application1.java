package com.ohgiraffers.section01.literal;

public class Application1 {
    public static void main(String[] args) {

        // 한 줄 주석  주석 달때는 위에 한 줄을 띄우고 주석 적용하기 (코딩 컨벤션)
        /* 범위 주석 */
        /*
        여러줄
        주석
         */
        /* ctrl + shift + / 를 누르면 범위주석 자동 생성 */

        /*
        정적타입 : 자바, C++, ...
        동적타입 : 자바스크립트, 파이썬,...
        동적 타입은 나중에 타입을 변경할 수 있지만, 정적타입의 경우 타입을 처음부터 확실하게 가져가야 한다.
        */

        /*
        컴파일 에러 vs 런타임 에러
        컴파일 에러 : 실행 시키기 전 문법적으로 오류가 날 경우 (빨간 줄이 생김)
        런타임 에러 : 문법적으로는 문제가 되지 않지만 실행시키면 에러가 나는 경우
        */


        /* 수업목표. 여러가지 값의 형태를 출력할 수 있다. */

        /* 목차. 기본 자료형 */
        /* 목차. 1. 숫자 형태의 값 */
        /* 목차. 1-1. 정수 형태의 값 출력 */
        /* sout -> enter 하면 systemt.out 이 바로 만들어짐
         println -> 한줄 개행 , print -> 개행 없이 이어서 씀 */
        System.out.println(123);

        /* 목차. 1-2. 실수 형태의 값 출력 */
        System.out.println(1.234);

        /* 목차. 2. 문자 형태의 값 출력 */
        System.out.println('a');                // 문자를 입력할 때는 '' 를 사용
        System.out.println('1');                // 숫자도 ' ' 사이에 들어가면 문자로 취급된다.
//        System.out.println('ab');             // 문자에 두 글자 이상이 들어갈 경우 컴파일 에러가 발생
        System.out.println('\u0000');           // 문자에 아무것도 입력을 안할 시 에러 발생 -> \u0000 를 입력해줘야 한다.

        /* 목차. 3. 문자열 형태의 값 출력 */
        System.out.println("안녕하세요");         // 문자열 형태를 입력할 때는 '' 이 아니라 "" 로 사용*
        System.out.println("a");                // 한 글자라도 문자열로 취급이 가능하다
        System.out.println("");                 // 문자열은 아무것도 입력하지 않아도 받아들인다.

        /* 목차. 4. 논리 형태의 값 출력 */
        System.out.println(true);
        System.out.println("true");             // " " 안에 들어가면 ture/false가 아니라 문자열이 된다.
        System.out.println(false);              // 논리자료형은 true/false 두 값만 존재한다.

    }
}
