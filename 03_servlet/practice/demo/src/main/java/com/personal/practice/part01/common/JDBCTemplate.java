package com.personal.practice.part01.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCTemplate {

    public static Connection getConnection() {
        Connection con = null;
        Properties prop = new Properties();

        System.out.println(" 여기 까지 가능? ");
        System.out.println(" 여기 까지 가능?2 ");

        try {
            prop.load(
                    new FileReader("src/main/java/com/personal/practice/config/connectInfo.properties"));

            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");

            Class.forName(driver);  // 어떤 드라이버를 사용할 것이지 지정

            con = DriverManager.getConnection(url, prop);

            con.getAutoCommit();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
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
