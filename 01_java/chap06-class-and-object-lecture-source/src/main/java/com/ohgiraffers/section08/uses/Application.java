package com.ohgiraffers.section08.uses;

/* 설명. 이 예제는 나중에 클래스들을 나누게 될 때 굉장히 세분화하여 나누게 될 것을 미리 보기 위한 것이다.
 *   	이해 안되더라도 그냥 '클래스마다 역할을 부여 받는다' 라는 것만 잘 알아두자.
* */

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		
		MemberService memberManager = new MemberService();
		
		while(true) {
			System.out.println("======== 회원 관리 프로그램 ========");
			System.out.println("1. 회원 등록");
			System.out.println("2. 회원 전체 조회");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 선택 : ");
			int no = sc.nextInt();
			
			switch(no) {
				case 1 : memberManager.signUpMembers(); break;
				case 2 : memberManager.showAllMembers(); break;
				case 9 : System.out.println("프로그램을 종료합니다."); return;
				default : System.out.println("잘못된 번호를 입력하셨습니다."); break;
			}
		}
	}
}
