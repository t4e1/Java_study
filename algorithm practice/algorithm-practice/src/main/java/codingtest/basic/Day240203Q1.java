package codingtest.basic;

import java.io.*;
import java.util.*;

public class Day240203Q1 {

    /* 배열 연습 문제 (BaekJoon - 1546)
     * 세준이는 기말고사를 망쳤다. 세준이는 점수를 조작해서 집에 가져가기로 했다.
     * 일단 세준이는 자기 점수 중에 최댓값을 골랐다. 이 값을 M이라고 한다. 그리고 나서 모든 점수를 점수/M*100으로 고쳤다.
     * 예를 들어, 세준이의 최고점이 70이고, 수학점수가 50이었으면 수학점수는 50/70*100이 되어 71.43점이 된다.
     * 세준이의 성적을 위의 방법대로 새로 계산했을 때, 새로운 평균을 구하는 프로그램을 작성하시오.
    * */

    /* 첫째 줄에 시험 본 과목의 개수 N이 주어진다. 이 값은 1000보다 작거나 같다.
     * 둘째 줄에 세준이의 현재 성적이 주어진다. 이 값은 100보다 작거나 같은 음이 아닌 정수이고, 적어도 하나의 값은 0보다 크다.
    * */

    /*  첫째 줄에 새로운 평균을 출력한다. 실제 정답과 출력값의 절대오차 또는 상대오차가 10-2 이하이면 정답이다.
    * */
//    public static void main(String[] args) {
//        List<String> listTest = new ArrayList<>(Arrays.asList("40", "60", "80"));
//
//        listTest.stream().forEach(System.out::println);
//    }

    public static BufferedReader toBuffredReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static Double solution(String input) throws IOException {
        BufferedReader br = toBuffredReader(input);

        int n = Integer.valueOf(br.readLine());     // 과목 개수 n

        Double[] testArray = new Double[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            testArray[i] = Double.valueOf(st.nextToken());
        }

        double maxScore = 0.0;

        for (double i : testArray) {
            maxScore = Math.max(maxScore, i);
        }

        double sum = 0f;

        for (int i = 0; i < n; i++) {
            testArray[i] = (testArray[i] / maxScore) * 100;
            sum += testArray[i];
        }

        /* 리스트 사용해서 풀어보기 */
//        List<Double> arrayList = new ArrayList<>();

//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            if (arrayList != null) {
//                arrayList.add(Double.valueOf(st.nextToken()));
//            }
//        arrayList.stream().forEach(System.out::println);
//        }

//        double m = Collections.max(arrayList);
//        double sum = 0.0;

//        for (int i = 0; i < n; i++) {
//            arrayList.set(i, (arrayList.get(i) / m * 100));
//            sum += arrayList.get(i);
//        }

        return sum / n ;
    }

}
