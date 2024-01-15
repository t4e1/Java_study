package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class group_study {

    /* 설명. 마름모 꼴로 별을 호출해 보자. */
    /*     *
     *    * *
     *   * * *
     *  * * * *
     *   * * *
     *    * *
     *     *
     * */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("홀수를 입력해 주세요 : ");
        int input = sc.nextInt();
        if (input % 2 == 0) {
            System.out.println("짝수입니다. 홀수를 입력해 주세요.");          // 짝수일 시 에러 반환
        } else                                                             // 홀수일 시 정상 동작 진행
            for (int i = 1; i <= input; i++) {                          // 바깥 for ( 행 변경 )
                for (int j = 1; j <= (input - (input / 2) + 1); j++) {                // 왼쪽 공백
                    System.out.print(" ");
                }
                if (i <= (input / 2) + 1) {
                    for (int j = 1; j <= i; j++) {                      // 별   왼쪽
                        System.out.print("*");
                    }
                } else if (i == (input / 2) + 1) {
                    for (int j = 1; j <= (input / 2) + 1; j++) {        // 별 중간값
                        System.out.print("*");
                    }
                } else {
                    for (int j = 1; j <= i; j++) {                      // 별   오른쪽
                        System.out.print("*");
                    }
                }

                for (int j = 0; j <= (input - (input / 2) + 1); j++) {                    // 오른쪽 공백
                    System.out.print(" ");
                }
                System.out.println(" ");
            }

    }


}

