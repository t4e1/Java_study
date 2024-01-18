package com.ohgiraffers.section01.extend;

public class Car {

    /* 설명. 자동차의 속성과 기능을 나열 */
    /* 설명. 필드 - 속성 나열 */
    private boolean runingStatus;

    public Car() {
        super();
        System.out.println("Car 클래스 기본 생성자");
    }

    /* 설명. 기능 나열  */
    public void run() {
        this.runingStatus = true;
        System.out.println("자동차가 달리기 시작합니다.");
    }

    public void soundHorn() {
        if(isRunning()){
            System.out.println("경적");
        } else {
            System.out.println("주행 중이 아닙니다. ");
        }
    }

    public boolean  isRunning() {
        return this.runingStatus;
    }

    public void stop() {
        this.runingStatus = false;
        System.out.println("자동차가 멈춥니다");
    }
}
