package com.ohgiraffers.chap04.section01.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class Application2 {

    public static BufferedReader toBufferedReader(String string) {
        InputStream is = new ByteArrayInputStream(string.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static int solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.valueOf(st.nextToken());        // 동전의 종류 개수
        int K = Integer.valueOf(st.nextToken());        // 계산할 금액 (가치의 합)

        int[] coin = new int[N];                        // 동전의 종류들을 담을 배열

        for (int i = 0; i < N; i++) {
            coin[i] = Integer.valueOf(br.readLine());
        }

        int count = 0;                      // 지불할 동전의 개수

        for (int i = N - 1; i >= 0; i--) {            // 큰 금액의 동전부터 처리될 수 있게 반복문 작성
//            System.out.println(coin[i] + "로 지불하기 전 금액 : " + K);
            if (coin[i] <= K) {
                count += (K / coin[i]);     // K / coin[i] 의 몫

                /* 설명. K에서 coin[i]를 처리(개수 계산)하고 남은 나머지 금액 */
                K = K % coin[i];            // K / coin[i] 의 나머지 -> 가장 큰 수로 나눈 뒤 남은 금액
            }
//            else if (K == 0){     // 개선 코드. 기존 코드면 무조건 i를 반복하는데, 잔여 금액을 계산해서 0이면 바로 리턴하도록
//                return count;
//            }
//            System.out.println(coin[i] + "로 지불한 뒤 잔여 금액 : " + K);
//            System.out.println("현재 동전의 수 : " + count);
        }

        return count;
    }

}
