package com.ohgiraffers.section04.assignment.aggregate;

import java.io.Serializable;
import java.util.Arrays;

/* 설명. 객체 입출력의 대상이 되는 클래스이자 엔터티 개념의 클래스 (DB에 저장된 데이터를 담거나 넣을 데이터를 담을 객체) */
public class Member implements Serializable {       // 객체 입출력을 위해 Serializable 인터페이스 구현

    private int memNo;                  // 회원번호
    private String id;                  // 회원 id
    private String pwd;                 // 회원 패스워드
    private int age;                    // 회원 나이
    private String[] hobbies;           // 회원 취미
    private BloodType bloodtype;        // 회원 혈액형 (혈액형은 4개가 고정이기 때문에 enum 타입 사용)

    /* 설명. 엔터티 클래스는 setter를 꼭 필요한 것만 만든다. (불필요한 setter 생성 지양) */
    public Member() {
    }

    public Member(int memNo, String id, String pwd, int age, String[] hobbies, BloodType bloodtype) {
        this.memNo = memNo;
        this.id = id;
        this.pwd = pwd;
        this.age = age;
        this.hobbies = hobbies;
        this.bloodtype = bloodtype;
    }

    public Member(String id, String pwd, int age, String[] hobbies) {
        this.id = id;
        this.pwd = pwd;
        this.age = age;
        this.hobbies = hobbies;
    }

    public void setBloodtype(BloodType bloodtype) {
        this.bloodtype = bloodtype;
    }

    public void setMemNo(int memNo) {
        this.memNo = memNo;
    }

    public int getMemNo() {
        return memNo;
    }

    public String getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

    public int getAge() {
        return age;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public BloodType getBloodtype() {
        return bloodtype;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memNo=" + memNo +
                ", id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", age=" + age +
                ", hobbies=" + Arrays.toString(hobbies) +
                ", bloodtype=" + bloodtype +
                '}';
    }
}
