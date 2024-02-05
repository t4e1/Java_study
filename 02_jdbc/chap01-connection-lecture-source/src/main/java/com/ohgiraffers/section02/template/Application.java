package com.ohgiraffers.section02.template;

import java.sql.Connection;

/* 설명. import 뒤에 static을 붙이고 메소드명까지 쓰게되면 다른 클래스의 static 메소드를 마치 내 class에 있는 것처럼 사용할 수 있다. */
import static com.ohgiraffers.section02.template.JDBCTemplate.close;
import static com.ohgiraffers.section02.template.JDBCTemplate.getConnection;

public class Application {

    public static void main(String[] args) {
        /* 필기. 만들어놓은 메소드를 통해 Connection 객체 생성 */
        Connection con = getConnection();

        /* 설명. 비즈니스 로직(Transaction 처리 - 실패하면 전부 실패, 성공하면 전부 성공 ) 실행 */
        System.out.println("con = " + con);

        /* 필기. 트랜잭션 처리가 끝난 다음에 통로 닫기 */
        close(con);     // Connection 객체를 던지면 그 객체를 닫아주는 메소드
    }


}
