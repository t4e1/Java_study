package com.ohgiraffers.section01.array;

import java.util.Arrays;
import java.util.Scanner;

public class Application4 {

    public static void main(String[] args) {

        /* 수업목표. 배열을 사용하는 예시를 이해하고 적용할 수 있다. */
        /* 필기. 5명의 자바 점수를 정수로 입력 받아서 합계와 평균을 실수(double)로 구하는 프로그램을 만들어보자. */

        Scanner sc = new Scanner(System.in);
        int[] score = new int[5];

        for (int i = 0; i < score.length; i++) {
            System.out.print((i + 1) + "번 학생의 점수를 입력해 주세요 : ");
            score[i] = sc.nextInt();
        }

        /* 필기. 합계(sum) 구하기 */
        double sum = 0.0;
        for(double perScore : score) {
            sum += perScore;
        }
        System.out.println("합계 : " + sum);

        /* 필기. 평균(avg) 구하기 */
        double avg = 0.0;
        avg = sum / (double)score.length;
        System.out.println("평균 : " + avg);

    }
}
