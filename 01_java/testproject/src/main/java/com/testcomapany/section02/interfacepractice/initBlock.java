package com.testcomapany.section02.interfacepractice;

public class initBlock {
    String fieldName = "필드 초기화";
    int fieldNum = 1;

    {
        System.out.println("========== 초기화 블록 시작 ===========");
        System.out.println("필드 Name 입력값 : " + fieldName);
        System.out.println("필드 Num 입력값 : " + fieldNum);
        fieldName = "초기화 블록 초기화";
        fieldNum = 2;
    }

    public initBlock() {
        System.out.println("========== 생성자 시작 ===========");
        System.out.println("초기화 블록 Name 입력값 : " + fieldName);
        System.out.println("초기화 블록 Num 입력값 : " + fieldNum);
        System.out.println("========== 생성자 변수 초기화 ===========");
        this.fieldName = "생성자 초기화";
        this.fieldNum = 3;
        System.out.println("생성자 Name 입력값 : " + fieldName);
        System.out.println("생성자 Num 입력값 : " + fieldNum);
    }
}
