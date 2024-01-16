package com.ohgiraffers.section02.demensinal;

import java.util.Arrays;

public class Application1 {

    public static void main(String[] args) {

        /* 수업목표. 다차원 배열의 구조를 이해하고 사용할 수 있다. */
        /* 필기.
         *  다차원 배열
         *   다차원 배열은 2차원 이상의 배열을 의미(일반적으로 사람의 인지 범위에 맞게 최대 3차원 정도를 고려한다)
        * */

        int[][] iArr1;
        int[] iArr2[];                      // 선언은 가능하지만 바람직하지 않은 모양
        int iArr3[][];

        iArr1 = new int[3][2];              // 두 칸짜리 1차원 배열을 3개 관리하겠다. 관리하는 1차원 배열이 모두 같은 크기일 시
        iArr2 = new int[3][];               // 3개의 일차원 배열을 관리할 건데, 아직 각각의 크기를 지정하지 않았다.
                                            // ex) 2칸 짜리 / 3칸 짜리 / 5칸 짜리 1차원 배열을 각각 사용하겠다
//        iArr3 = new int[][];                // 둘다 지정 안하는 것은 안됨 (컴파일 에러)

        /* 설명. 정변 배열은 이미 1차원 배열들이 생성되어 지정되어 있다 */
        int num = 0;
        for (int i = 0; i < iArr1.length; i++) {            // 1차원 배열을 고르는 for문
            for (int j = 0; j < iArr1[i].length; j++) {     // 선택된 1차원 배열의 길이만큼 반복하는 for문
                iArr1[i][j] = num++;
            }
            System.out.println(Arrays.toString(iArr1[i]));
        }

        /* 설명. 가변 배열은 아직 1차원 배열이 생성성돼어 있지 않다.(NullPointerException도 발생 가능) */
        int num2 = 0;
        int length = 1;
        for (int i = 0; i < iArr2.length; i++) {
            iArr2[i] = new int[++length];//
            for (int j = 0; j < iArr2[i].length; j++) {     // 선택된 1차원 배열의 길이만큼 반복하는 for문
                iArr2[i][j] = num2++;
            }
            System.out.println(Arrays.toString(iArr2[i]));
        }

    }

}
