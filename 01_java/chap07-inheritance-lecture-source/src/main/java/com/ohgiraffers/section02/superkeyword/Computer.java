package com.ohgiraffers.section02.superkeyword;

import java.util.Date;

public class Computer extends Product {
    private String cpu;                 // 연산장치
    private int hdd;                    // 하드
    private int ram;                    // 램
    private String operationSystem;     // 운영체제

    public Computer() {
        super();
        System.out.println("Computer 클래스의 기본 생성자 호출 ");
    }

    public Computer(String cpu, int hdd, int ram, String operationSystem) {
        super();
        this.cpu = cpu;
        this.hdd = hdd;
        this.ram = ram;
        this.operationSystem = operationSystem;
        System.out.println("Computer 클래스의 모든 필드를 초기화하는 생성자 호출 ");
    }

    public Computer(String code, String brand, String name, int price, Date manufaturingDate, String cpu, int hdd, int ram, String operationSystem) {
        super(code, brand, name, price, manufaturingDate);
        this.cpu = cpu;
        this.hdd = hdd;
        this.ram = ram;
        this.operationSystem = operationSystem;
        System.out.println("Computer 클래스의 부모 필드까지 모두 초기화하는 생성자 호출 ");
    }

    @Override
    public String toString() {
//        return "Computer{" +
//                "cpu='" + cpu + '\'' +
//                ", hdd=" + hdd +
//                ", ram=" + ram +
//                ", operationSystem='" + operationSystem + '\'' +
//                "} " + super.toString();
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", hdd=" + hdd +
                ", ram=" + ram +
                ", operationSystem='" + operationSystem + '\'' +
                "} " +
                "Product{" +
                "code='" + super.getCode() + '\'' +
                ", brand='" + this.getBrand() + '\'' +              // 자식 클래스도 getter setter를 물려받기 때문에 this로 사용해도 된다.
                ", name='" + super.getName() + '\'' +
                ", price=" + this.getPrice() +
                ", manufaturingDate=" + super.getManufaturingDate() +
                '}';
    }
}
