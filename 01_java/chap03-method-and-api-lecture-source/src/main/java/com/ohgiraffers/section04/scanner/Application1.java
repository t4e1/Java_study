package com.ohgiraffers.section04.scanner;

import java.util.Scanner;

public class Application1 {

    public static void main(String[] args) {

        /* 수업목표. java.util.Scanner를 이용한 다양한 자료형 값 입력 받기 */
        Scanner sc = new Scanner(System.in);

        /* 목차. 1. 문자열 입력받기 */
        System.out.print("이름을 입력하세요: ");
//        String name = sc.next();                       // 공백이나 개행 전까지만 반환, 하지만 버퍼에는 반환하지 않은 값도 남아 있음
        String name = sc.nextLine();                     // 공백이나 개행까지 한 줄의 문자열을 전부 반환
        System.out.println("입력하신 이름은: " + name + " 입니다.");

        /* 목차. 2. 정수형 입력받기*/
        System.out.print("나이를 입력하세요: ");
        int age = sc.nextInt();
        System.out.println("입력하신 나이는: " + age );

        /* 목차. 3. 실수형 입력받기*/
        System.out.print("키를 입력하세요: ");
        double height = sc.nextDouble();
        System.out.println("입력하신 키는: " + height );

        /* 목차. 4. 논리형 입력받기*/
        System.out.print("참과 거짓 중에 한 가지를 true 또는 false로 입력하세요 : ");
        boolean isTrue = sc.nextBoolean();
        System.out.println("입력하신 논리 값은: " + isTrue );

        sc.nextLine();                                  // 버퍼에 쌓인 공백 및 개행 제거용 nextLine();

        /* 목차. 5. 문자형 입력받기*/
        System.out.print("아무 문자나 입력해 주세요 : ");
//        char answer = sc.next().charAt(0);
        char answer = sc.nextLine().charAt(0);          // method chaining 방식으로 사용자의 입력값에서 인덱스 번째의 문자를 char형으로 반환
        System.out.println("입력하신 문자는 : " + answer );
    }

}
