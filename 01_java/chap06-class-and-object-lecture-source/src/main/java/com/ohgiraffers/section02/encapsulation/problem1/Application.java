package com.ohgiraffers.section02.encapsulation.problem1;

public class Application {

    public static void main(String[] args) {

        /* 수업목표. 필드에 직접 접근하는 경우 발생할 수 있는 문제점을 이해할 수 있다. */
        Monster monster1 = new Monster();

        /* 설명. 1번 몬스터 생성 */
        monster1.name = "몬스터1";         //참조연산자(.)를 통해 값 대입
        monster1.hp = 200;

        /* 설명. 몬스터 정보를 출력 */
        System.out.println("monster1의 이름 : " + monster1.name);
        System.out.println("monster1의 hp : " + monster1.hp);

        /* 설명. 2번 몬스터 생성 (문제점 확인) */
        Monster monster2 = new Monster();
        monster2.name = "몬스터2";
        monster2.hp = -200;                 // 문제점 : 음수가 들어가면 안되는 값에 음수가 들어간다

        System.out.println("monster2의 이름 : " + monster2.name);
        System.out.println("monster2의 hp : " + monster2.hp);

        /* 설명. 3번 몬스터 생성 (setter를 통한 접근) */
        Monster monster3 = new Monster();
        monster3.name = "몬스터3";
        monster3.setHp(100);                    // monster3의 hp 공간에 100이 할당 된다.

        System.out.println("monster3 = " + monster3.name);
        System.out.println("monster3 = " + monster3.hp);

        /* 설명. 4번 몬스터 생성 (setter를 통한 접근 - hp가 음수일 때) */
        Monster monster4 = new Monster();
        monster4.name = "몬스터4";
        monster4.setHp(-100);

        System.out.println("monster4 = " + monster4.name);
        System.out.println("monster4 = " + monster4.hp);
    }
}
