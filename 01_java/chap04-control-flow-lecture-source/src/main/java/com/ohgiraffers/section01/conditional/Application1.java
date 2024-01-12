package com.ohgiraffers.section01.conditional;

/* 설명. 이제부터는 실행용 클래스를 구분해서 사용한다.(main 메소드는 Application 에만 존재) */
public class Application1 {

    public static void main(String[] args) {

        A_if aClass = new A_if();

        /* 필기. 단독 if문 흐름 확인용 메소드 호출 */
//        aClass.testSimpleIfStatement();

        /* 필기. 중첩 if문 흐름 확인용 메소드 호출 */
//        aClass.testNestedIfStatement();

        /* 필기. 단독 if-else문 흐름 확인용 메소드 호출 */
//        B_ifElse bClass = new B_ifElse();
//        bClass.testSimpleIfElseStatement();

        /* 필기. 중첩 if-else문 흐름 확인용 메소드 호출 */
//        bClass.testNestedIfElseStatement();

        /* 필기. 단독 if-else-if 문 흐름 확인용 메소드 호출 */
//        C_ifElse cClass = new C_ifElse();
//        cClass.testSimpleIfElseIfStatement();

        /* 필기. 중첩 if-else-if문 흐름 확인용 메소드 호출*/
//        cClass.testNestedIfElseIfStatement();

        /* 필기. 단독 switch문 흐름 확인용 메소드 호출 */
        D_switch dClass = new D_switch();
        dClass.testSimpleSwitchStatement();

    }
}
