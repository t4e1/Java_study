package com.ohgiraffers.section02.encapsulation.problem1;

public class Monster {
    String name;
    int hp;

    public void setHp(int hp) {
        if(hp > 0) this.hp = hp;    // this는 메소드 호출 당시의 Monster 객체를 뜻하고,
                                    // this.hp 는 heap에 올라와있는 해당 객체의 hp공간을 뜻한다.
                                    // 절대 class 의 필드에 있는 int hp; 에 hp 가 입력되는것이 아니다. ( 클래스는 실체가 없음 )
        else if(hp <= 0) this.hp = 0;
    }
}
