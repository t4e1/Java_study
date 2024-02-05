package com.ohgiraffers.section02.prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {

    /* 설명. PreparedStatement 에 대해 이해하고 활용할 수 있다. */
    /* 필기. 사용 목적
     *  하자가 있는 쿼리 ( 사용자의 입력을 받아야 하는 쿼리 )를 사용할 때는 PreparedStatement 가 효율이 좋다
     *  SQL Injection 공격을 막을 수 있다.
    * */
    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {

            /* 설명. statement와 달리 PreparedStatement 는 생성 당시에 쿼리가 있어야 한다. */
            pstmt = con.prepareStatement("select emp_id, emp_name from employee ");
            rset = pstmt.executeQuery();

            while (rset.next()) {
                System.out.println(rset.getString("Emp_id")
                        + ", " + rset.getString("emp_name"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);   // PreparedStatement 는 Statement 를 상속 받았으므로, Statement용 close메소드를 그대로 사용 가능
            close(con);
        }

    }
}
