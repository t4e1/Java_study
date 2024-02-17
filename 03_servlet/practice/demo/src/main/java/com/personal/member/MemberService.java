package com.personal.member;

import com.personal.member.common.Member;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.personal.member.common.JDBCTemplate.*;


/* 서비스단에서 해야할 일 */
/* 1. 커넥트 객체 생성
 * 2. 생성한 커넥트 객체랑 넘겨받은 DTO 객체 Repo 로 넘기기
 * 3. Repo 에서 받은 성공/실패 결과 가지고 commit / rollback 결정
 * */
public class MemberService {

    public static int registMember(Member memberInfo) {

//        System.out.println("Connection 객체 생성전 ");
        Connection con = getConnection();               // Conntect 객체 생성 함출 호출
//        System.out.println("Connection 객체 호출됨 ");
        int result = 0;                                 // 결과를 받을 변수 result 선언

        result = MemberRepository.registMember(con, memberInfo);      //Repo로 부터 받은 결과값으로 초기화

        if (result > 0) {
            commit(con);            // 결과가 성공이면 commit, 실패하면 rollback을 처리하는 트랜잭션 처리부분
//            System.out.println("commit 실행");
        } else {
            rollback(con);
//            System.out.println("rollback 실행");
        }

        close(con);                 // connection 닫는 메소드 호출

//        System.out.println("connection 종료 ");
        return result;              // 결과값 Controller로 반환해서 출력 서블릿에 넘길 수 있도록
    }

    public static String viewMember(Member viewInfo) {

        Connection con = getConnection();

        String result = " ";
        StringBuilder sb = new StringBuilder();
        result = MemberRepository.selectMember(viewInfo, con);
//        System.out.println("결과 반환 여기까지 되나? ");

        close(con);

        return result;
    }
}
