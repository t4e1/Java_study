package com.ohgiraffers.section02.encapsulation.problem2;

public class Application {

    public static void main(String[] args) {

        /* 수업목표. 필드값 수정 시 발생할 수 있는 문제점을 이해할 수 있다. */
        /* 설명. 필드값 수정 = 가져온 Class의 필드값이 변경되는 경우를 뜻한다 (이름 or 데이터타입 등..) */
//        Monster monster1 = new Monster();
//        monster1.name = "드라큘라";
//        monster1.hp = 200;
//
//        System.out.println("monster1's name = " + monster1.name);
//        System.out.println("monster1's hp = " + monster1.hp);

        Monster monster2 = new Monster();
        monster2.setInfo1("프랑켄슈타인");
        monster2.setInfo2(200);
    }
}
