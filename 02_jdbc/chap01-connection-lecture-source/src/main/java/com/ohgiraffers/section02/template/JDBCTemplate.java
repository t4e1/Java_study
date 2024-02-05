package com.ohgiraffers.section02.template;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/* 설명. JDBC를 위한 메소드만 따로 모듈화(Connection 객체 생성, close 메소드 처리(Connection, Statement, PreparedStatement)) */
// JDBC를 위한 메소드를 따로 빼서 만들고 나중에 Application 에서 호출하게 된다
public class JDBCTemplate {
    public static Connection getConnection() {
        Connection con = null;
        Properties prop = new Properties();

        try {
            prop.load(
                    new FileReader
                            ("src/main/java/com/ohgiraffers/section01/connection/jdbc-config.properties"));
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");

            Class.forName(driver);      // 어떤 DBMS타입과 연동할 것인지 선언 (드라이버 인식)

            /* 설명. 이번에는 user라는 키와 password라는 키 값을 지닌 properties 객체를 넘겨주고 Connection객체 생성 */
            // 설정 파일에 user나 password라는 키 값이 오타 없도록 & 다른 이름 사용하지 않도록 하는 이유
            con = DriverManager.getConnection(url, prop); // DBMS별 드라이버에서 제공하는 메소드를 사용하여 DB와 연결할 도로(Connection)를 뚫음


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        /* 설명. 이번에는 close 메소드를 여기서 호출하지 않는다.(해당 DBMS와 연결할 수 있는 Connection 반환만 해당되게 작성) */
        // 연결하는 역할만 따로 메소드화해서 뺴놓은 것 ( 연결하자마자 바로 닫으면 의미 없으니까 close는 여기서 선언 x )
        // 여기서는 계속 뚫려있는 커넥션 하나만 만든다 -> 나중에 닫는 메소드도 만들어서 호출할 것
        return con;
    }

    /* 설명. 열어놨던 Connection 을 닫는 메소드 */
    public static void close(Connection con) {
        try {
            if(con != null && !con.isClosed()) con.close();     // nullpoint 에러 방지한 뒤 닫혔는지 파악
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
