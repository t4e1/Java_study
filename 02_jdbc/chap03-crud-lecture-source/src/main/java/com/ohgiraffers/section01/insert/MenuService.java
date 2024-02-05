package com.ohgiraffers.section01.insert;

import java.sql.Connection;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.*;

/* 설명. Service 계층은 Connection 객체 생성 및 소멸(close), 비즈니스 로직, 트랜잭션(commit, rollback) 처리 */
public class MenuService {

    public void registMenu(Menu registMenu) {

        /* 설명. 커넥션 객체 생성 */
        Connection con = getConnection();

        /* 설명. 비즈니스 로직 실행 */
        MenuRepository repository = new MenuRepository();
        int result = repository.registMenu(con, registMenu);    // repository 에 만들었던 Connection 객체를 넘긴다.

        /* 필기. repository에서 받아온 성공/실패를 확인한 뒤 트랜잭션을 처리 (commit / rollback)한다. */
        if (result > 0) {                           //
//            try {
//                con.commit();     // 여기서 바로 commit을 하게 되면 try/catch 로 지저분해지니 JDBCTemplate에 static 메소드를 만들어서 쓰자.
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
            commit(con);
        } else {
            rollback(con);
        }

        /* 설명. 커넥션 객체 소멸 */
        close(con);
    }
}
