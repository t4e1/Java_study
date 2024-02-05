package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {

    public static void main(String[] args) {

        /* Connection 객체 생성 -> 비즈니스 로직 처리 -> close 하는 흐름을 이해하기 */
        /* 설명. 트랜잭션 처리를 위한 DBMS 연동용 Connection 객체 생성 */
        Connection con = getConnection();

        /* 설명. 해당 Connection을 통해 트랜잭션 처리(비즈니스 로직 실행, CRUD) */
        System.out.println("con = " + con);

        Statement stmt = null;      // 쿼리를 운반하고 결과를 반환하는 객체 생성 (트럭과 같은 역할)
        ResultSet rset = null;      // 조회의 결과 반환되는 객체, 조회 이외의 CRUD를 실행하면 ResultSet이 아니라 int형에 담는다.

        try {
            stmt = con.createStatement();                                    // Connection 길 위를 달릴 트럭 하나가 생성되서 반환

            /* 설명. 쿼리의 결과인 다중행/단일행을 받은 ResultSet (현재는 모든 메뉴를 호출했으므로 다중행) */
            rset = stmt.executeQuery("select * from employee");         // 다녀온 결과를 resultset으로 반환

            /* 설명. rset.next() : 한 행씩 확인 */
            while (rset.next()) {                                           // next(): 다음값(다음 행)이 있으면 true, 없으면 false 반환

                /* 설명. 반복문 안에서의 rset은 단일행으로 해석할 것 */
                System.out.println(rset.getString("emp_name")    // next()를 하고 난 다음에는 한 행으로 생각하기
                           + ", " + rset.getInt("salary"));      // DB컬럼의 데이터형에 따라서 varchar면 getString, int면 getInt 등으로 받는다.
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rset);
            close(stmt);
            close(con);
        }

    }
}
