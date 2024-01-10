package com.ohgiraffers.section01.literal;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. 값을 직접 연산하여 출력할 수 있다. */

        /* 목차. 1. 숫자와 숫자의 연산 */
        System.out.println("============ 정수와 정수의 연산 ============");
        System.out.println(123 + 456);
        System.out.println(123 - 23);
        System.out.println(123 * 10);
        System.out.println(123 / 10);
        System.out.println(123 % 10);           // % modulus 연산자(mod 연산자) : 제수로 나눈 나머지를 반환

        /* 목차. 1-2. 실수의 연산 */               // alt+shift+화살표 로 코드를 이동시킬 수 있다.
        System.out.println("============ 실수와 실수의 연산 ============");
        System.out.println(1.23 + 1.23);
        System.out.println(1.23 - 0.23);
        System.out.println(1.23 * 10.0);
        System.out.println(1.23 / 10.0);
        System.out.println(1.23 % 1.0);         // 실수를 가지고 연산을 하면 근사치를 내는 경우가 많음. -> 정확한 값이 아닐 수 있음을 인지할 것

        /* 목차. 1-3. 정수와 실수의 연산 */
        /* 필기. 정수와 실수를 연산하면 실수가 반환된다.(정수가 실수로 바뀐 다음에 연산됨)
         *      모든 연산은 같은 자료형 사이에서만 가능.  */
        System.out.println("============ 정수와 실수의 연산 ============");
        System.out.println(123 + 0.5);
        System.out.println(123 - 0.5);
        System.out.println(123 * 0.5);
        System.out.println(123 / 0.5);
        System.out.println(123 % 0.5);

        /* 목차. 2. 문자의 연산 */
        /* 필기. 문자를 숫자로 변환해서 연산.
         *      문자를 아스키 코드나 유니코드 기반의 숫자로 자동 변환하여 계산된다.   */
        System.out.println("============ 문자와 정수의 연산 ============");
        System.out.println('a' + 1);            // 98
        System.out.println('a' - 1);            // 96
        System.out.println('a' * 2);
        System.out.println('a' / 2);
        System.out.println('a' % 2);

        /* 필기. 문자와 실수의 연산은 정수와 실수의 연산과 같다. */

        /* 목차. 3. 문자열의 연산 */
        System.out.println("============ 문자열과 문자열의 연산 ============");
        System.out.println("hello" + "World!"); // 문자열간의 연산은 덧셈만 가능. 나머지는 컴파일 에러 발생
//        System.out.println("hello" - "World!");
//        System.out.println("hello" * "World!");
//        System.out.println("hello" / "World!");
//        System.out.println("hello" % "World!");

        /* 목차. 3-1. 문자열과 다른 형태의 연산 */
        /* 필기. 문자열과 다른 형태의 값은 전부 문자열과 문자열의 연산과 같이 연산된다. (뭐가 오든지 전부 문자열로 변환해서 연산) */
        System.out.println("============ 문자열과 다른 형태의 연산 ============");

        /* 설명. 문자열과 정수의 연산 */
        System.out.println("hello, World!" + 123);              // hello, World!123

        /* 설명. 문자열과 실수의 연산 */
        System.out.println("hello, World!" + 1.23);             // hello, World!1.23

        /* 설명. 문자열과 문자의 연산 */
        System.out.println("hello, World!" + 'a');              // hello, World!a

        /* 설명. 문자열과 논리값의 연산 */
        System.out.println(123 + 3 + "hello, World!" + true);   // 126hello, World!true

        /* 설명. 이항연산자들의 묶음에서 좌측에서부터 이항씩 연산하면 아래 코드의 결과를 이해 가능 */
        System.out.println(123 + 3 + "hello, World!" + 123 + 3);// 126hello, World!1233

        /* 설명. 문자열 뒤에 숫자를 활용한 연산을 쓰게 되면 소괄호 () 를 사용하여 우선순위를 높이고 연산해야 한다 */
        System.out.println("합계 : " + (123 + 345));            // 합계 : 468

        /* 목차. 4. 논리값의 연산 */
        /* 설명. 대부분의 산술 연산이 적용되지 않고 논리와 문자열의 연산만 가능하다. */
        System.out.println("============ 논리값과 다른 형태의 연산 ============");
//        System.out.println(true + 1);
//        System.out.println(true - 1);
//        System.out.println(true * 1);
//        System.out.println(true / 1);
//        System.out.println(true % 1);
        System.out.println(true+"문자열");
    }
}
