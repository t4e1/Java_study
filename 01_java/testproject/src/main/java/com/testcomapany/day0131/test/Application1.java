package com.testcomapany.day0131.test;

public class Application1 {


    /* 재귀 함수에서 자기 자신을 호출할 때 어떻게 처리 되는지? */
    public static void main(String[] args) {
        recursiveFunctionA(5);
    }

    static void recursiveFunctionA(int n) {
        if (n <= 0) {
            return;
        }

        // 상위 재귀 함수 호출
        recursiveFunctionA(n - 1);
        System.out.println("A 종료");

        // 아래쪽에 있는 다른 재귀 함수 호출
        recursiveFunctionA(n);
        System.out.println("B 종료");
    }
}
