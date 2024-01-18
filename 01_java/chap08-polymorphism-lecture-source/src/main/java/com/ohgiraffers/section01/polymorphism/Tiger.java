package com.ohgiraffers.section01.polymorphism;

public class Tiger extends Animal{

    @Override
    public void eat(){
        System.out.println("호랑이가 고기를 뜯어 먹습니다");
    }
    @Override
    public void run(){
        System.out.println("호랑이는 왠만해서 달리지 않습니다.");
    }
    @Override
    public void howling(){
        System.out.println("호랑이가 어흥하고 울부짖습니다.");
    }
    public void bite(){
        System.out.println("호랑이가 물어 뜯습니다.");
    }
}
