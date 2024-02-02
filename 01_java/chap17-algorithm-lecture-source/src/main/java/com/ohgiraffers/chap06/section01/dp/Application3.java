package com.ohgiraffers.chap06.section01.dp;

import java.io.*;

public class Application3 {

    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    /* 설명. 최대 100까지 입력 가능하므로 101크기 dp배열(dp테이블) 준비 */
    public static Integer[] dp = new Integer[101];

    public static int solution(int n) throws IOException {
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        return padovan(n);              // 꼭 메소드로 뺄 필요는 없지만 기능별로 메소드를 사용하면 메인 코드가 깔끔해지는 효과가 있음

    }

    private static int padovan(int n) {

        System.out.println("n = " + n);   // 에러가 날 경우 어느 위치에서 어느걸 찍어볼 건지가 가장 중요하다
        /* 설명. if문은 기존 dp에 값이 있을 때 점화식을 다시 사용하지 않도록하는 조건식(효율을 위함) */
        if (dp[n] == null)
            dp[n] = padovan(n - 2) + padovan(n - 3);        // 현재 위치의 값(n)은 3번째 전(n-3)과 2번째 전(n-2) 값의 합이다.

//        for (int i = 4; i < n + 1; i++) {      // 재귀가 아니라 반복문을 사용할 수도 있다. 여러 방향으로 생각해보기. 단, 재귀를 피하지 말자
//            dp[i] = dp[i - 2] + dp[i - 3];
//        }
        return dp[n];
    }
}
