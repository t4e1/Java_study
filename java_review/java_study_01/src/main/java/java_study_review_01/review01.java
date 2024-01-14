package java_study_review_01;

import java.util.Scanner;

public class review01 {
    public static void main(String[] args) {

        /* 정수 num1과 num2가 주어질 때, num1과 num2의 합을 return 하도록 함수를 완성해주세요. */
        /* static / non-static 관련 복습 + 메소드 호출 방법 복습 + 함수를 더 세련되게 짜는 방법 복습
        *  + import 로 alias 만들어서 scanner 클래스 호출
       * */

        review01 rv01 = new review01();                     // solution 4용 인스턴스 클래스 생성

        System.out.println(solution(0, 0));
        System.out.println(solution2(0, 0));
        System.out.println(solution3(0, 0));
        System.out.println(rv01.solution4(0, 0));           // static 메소드에서 non-static 메소드를 불러오려면 인스턴스 클래스 생성 필요

    }

    /* 1. num1 + num2 를 받는 변수 answer 를 선언해서 answer return  */
    private static int solution(int num1, int num2) {
        int answer = num1 + num2;
        return answer;
    }

    /* 2. return 값이 간단하게 나올 경우 변수를 사용할 필요 없으니 return을 바로 num1 + num2 로 받기 */
    public static int solution2(int num1, int num2){
        return num1 + num2 ;
    }

    /* 3. Scanner 를 사용해 int 값 받아보기 */
    public static int solution3(int num1, int num2){
        Scanner sc = new Scanner(System.in);            // Scanner 인스턴스 클래스 생성

        num1 = sc.nextInt();
        num2 = sc.nextInt();

        return num1 + num2;
    }

    public int solution4(int num1, int num2){
        Scanner sc = new Scanner(System.in);

        num1 = sc.nextInt();
        num2 = sc.nextInt();

        return num1 + num2;
    }

    /* public static -> 같은 패키지 내의 다른 클래스에서 클래스명.메소드명 의 형식으로 불러서 사용 가능,
     *                  다른 패키지에서는 호출할 수 없다. (Cannot resolve symbol 'review01')
     *                  같은 클래스라면 메소드명으로 바로 호출이 가능하다 ( review (); )
     * public -> 같은 클래스 내에서도 non-static인 메소드는 바로 호출할 수 없다. 호출하려면 인스턴스 클래스를 만든 뒤
     *           클래스명.메소드명 으로 사용해야함.
     * private static -> 같은 클래스 내에서만 사용 가능하다. 다른 클래스에서는 호출 불가능
     * private -> 같은 클래스 내에서만 사용 가능하고 마찬가지로 인스턴스 클래스 생성 뒤 클래스명.메소드명 으로 사용
    * */

}
