package com.ohgiraffers.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* 수업목표. 해당 DBMS와 계정에 맞는 Connection 객체를 생성할 수 있다. (feat. DBMS Driver 추가) */
public class Application1 {

    public static void main(String[] args) {
        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");      // 드라이버 인식

            /* 드라이버를 인식시키면 geConnection 이라는 메소드 사용 가능 */
            /* getConnection 을 통해 연동하는 통로(객체) (Stream 같은 개념) 를 만든다 */
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "swcamp", "swcamp");
            // 드라이버나 user name, password 등의 설정 파일을 따로 빼서 사용한다.

            System.out.println("con = " + con);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(con != null && !con.isClosed()) con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
