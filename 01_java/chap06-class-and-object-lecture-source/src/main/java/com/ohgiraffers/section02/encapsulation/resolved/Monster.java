package com.ohgiraffers.section02.encapsulation.resolved;

public class Monster {      // 클래스의 접근 제어자는 public 이나 ' '(공백, default) 두 가지 밖에 없다.

    /* 필기. 접근제어자 private를 활용하여 캡슐화를 적용한다.(같은 클래스를 제외한 곳에서는 접근 불가) */
    private String name;
    private int hp;

    public void setInfo1(String info1){
        this.name = info1;
    }

    public void setInfo2(int info2){
        this.hp = info2;
    }
}
