package com.ohgiraffers.section01.polymorphism;

public class Rabbit extends Animal {

    @Override
    public void eat(){
        System.out.println("토끼가 당근을 먹습니다");
    }
    @Override
    public void run(){
        System.out.println("토끼는 깡총깡총 달립니다. ");
    }
    @Override
    public void howling(){
        System.out.println("토끼가 작게 웁니다. ");
    }
    public void jump(){
        System.out.println("토끼가 점프합니다. ");
    }
}
