package com.personal.member.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/* 쿼리 간결화를 위한 JDBC 템플릿을 모아두는 클래스 */
public class JDBCTemplate {

    public static Connection getConnection() {
        Connection con = null;
        Properties prop = new Properties();

        System.out.println("getConnection 시작하고 try전까지");

        try {
            prop.load(
                    new FileReader("C:/study/java/03_servlet/practice/demo/src/main/java/com/personal/member/config/connection-info.properties"));

            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");

            Class.forName(driver);  // 어떤 드라이버를 사용할 것이지 지정

            con = DriverManager.getConnection(url, prop);

            con.setAutoCommit(false);
            System.out.println("커넥션 객체 생성됨");
        } catch (ClassNotFoundException e) {
            System.out.println("e = " + e);
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("e = " + e);
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("e = " + e);
            throw new RuntimeException(e);
        }

        return con;
    }

    public static void close(Connection con) {
        try {
            if (con != null && !con.isClosed())
                con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void commit(Connection con) {
        try {
            if(con != null && !con.isClosed())
                con.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void rollback(Connection con) {
        try {
            if(con != null && !con.isClosed())
                con.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
