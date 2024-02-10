package com.personal.member.register;

import com.personal.member.common.Member;

import java.sql.Connection;

import static com.personal.member.common.JDBCTemplate.*;


/* 서비스단에서 해야할 일 */
/* 1. 커넥트 객체 생성
 * 2. 생성한 커넥트 객체랑 넘겨받은 DTO 객체 Repo 로 넘기기
 * 3. Repo 에서 받은 성공/실패 결과 가지고 commit / rollback 결정
* */
public class RegisterService {

    public static int registMember(Member memberInfo) {

        System.out.println("Connection 객체 생성전 ");
        Connection con = getConnection();
        System.out.println("Connection 객체 호출됨 ");
        int result = 0;

        result = RegisterRepository.registMember(con, memberInfo);

        if (result > 0) {
            commit(con);
            System.out.println("commit 실행");
        } else {
            rollback(con);
            System.out.println("rollback 실행");
        }

        close(con);

        System.out.println("connection 종료 ");
        return result;
    }

}
