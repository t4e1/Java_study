package com.ohgiraffers.section01.array;

import java.util.Random;
public class Application5 {

    public static void main(String[] args) {

        /* 수업목표. 배열을 사용하는 예시를 통해 카드 게임을 작성해 보자. */
        String[] shape = {"SPADE ", "CLOVER ", "HEART ", "DIAMOND "};
        String[] cardNumbers = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING", "ACE"};

        int randomShapeIndex;           // 0 ~ 3
        int randomCardNumberIndex;      // 0 ~ 11

        Random ran = new Random();
        randomShapeIndex = (int)(Math.random() * 4);
        randomCardNumberIndex = ran.nextInt(12);

        System.out.println("당신이 뽑은 카드는 \"" + shape[randomShapeIndex]
                + cardNumbers[randomCardNumberIndex] + "\" 카드 입니다. ");
    }
}
