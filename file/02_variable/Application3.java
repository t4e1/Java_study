package com.ohgiraffers.section02.variable;

public class Application3 {
    int age = 30;
    public static void main(String[] args) {

        /* 수업목표. 변수의 명명 규칙에 대해 이해할 수 있다. */
        /* 필기.
         *  변수의 명명 규칙
         *    변수의 이름을 지을 때 아무렇게나 짓는 것이 아닌 정해진 규칙이 있음
         *    실무적으로 굉장히 중요하기 때문에 반드시 숙지
         *    또한, 규칙에 맞는 올바른 변수명을 짓는 것이 좋은 프로그래밍을 하는 첫 단계임을 알아야 함
        * */

        /* 목차. 1. 컴파일 에러를 발생시키는 규칙 */
        /* 목차. 1-1. 동일한 범위(중괄호로 묶인 부분) 내에서 동일한 변수명을 가질 수 없다. */
        int age = 20;
//        int age = 30;

        /* 목차. 1-2. 예약어는 변수로 사용이 불가능 */
//        int true = 1;
//        int for = 2;
        int True = 1;           // 대소문자를 구분하면 예약어도 변수로 사용할 순 있지만, 지양되어야 하는 변수명
        int tRue = 2;

        /* 목차. 1-3. 변수명은 대소문자를 구분 */
        int aGe = 20;           // 1-1 에서 만든 age와 다른 변수로 구분되기 떄문에 생성이 가능하다.

        /* 목차. 1-4. 변수명은 숫자로 시작할 수 없다 */
//        int 1age = 20;
        int age1 = 20;

        /* 목차. 1-5. 특수기호는 '_'와 '$' 만 사용 가능 */
        int _age = 30;
        int $harp = 25;
//        int #arp = 11;
//        int !age = 25;

        /* 목차. 2. 컴파일 에러를 발생시키지는 않지만 개발자들간의 암묵적인 규칙(관례상 규칙) */
        /* 목차. 2-1. 변수명의 길이 제한은 없다. 하지만 적당히 할 것 */
        int asdfajdflkjaldfjafdjafljaldfjkafja;

        /* 목차. 2-2. 변수명이 합성어로 이루어진 경우 첫 단어는 소문자, 두 번째 시작 단어는 대문자로 시작한다. */
        int maxAge = 50;
        int minAge = 10;
//        int max_age = 50; 가능하긴 하지만 될 수 있으면 Cammel Case 를 사용해서 변수명을 짓는게 좋음

        /* 목차. 2-3. 한글로 변수명을 짓는 것은 가능하지만, 지양해야 한다 */
        int 나이 = 19;

        /* 목차. 2-4. 변수 안에 저장될 값을 고려하여 변수명은 의미있고 명확하게 지어야 한다 */
//        String s;  의미없는 단어를 사용하여 변수를 짓지 않기
        String name;

        /* 목차. 2-5. 변수명은 명사형으로 작성하도록 한다 */
//        String goHome;
        String home;

        /* 목차. 2-6. boolean 자료형은 긍정 의문문 형태로 작성한다 */
        boolean isAlive = true;
        boolean isDead = false;
//        boolean isnotAlive = true;

    }

}
