package com.personal.practice.part01;

import com.personal.practice.part01.common.JDBCTemplate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import static com.personal.practice.part01.common.JDBCTemplate.*;

/* 서비스단에서 해야할 일 */
/* 1. 커넥트 객체 생성
 * 2. 생성한 커넥트 객체랑 넘겨받은 DTO 객체 Repo 로 넘기기
 * 3. Repo 에서 받은 성공/실패 결과 가지고 commit / rollback 결정
* */
public class MemberService {

    public static void registMember(Member memberInfo) throws IOException {

        Connection con = getConnection();
        int result = 0;

        try {
            result = MemberRepository.registMember(con, memberInfo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);

    }

}
