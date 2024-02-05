package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

/* 설명. 사번을 입력받아 한명의 사원을 조회하는 기능 작성 */
public class Application2 {

    public static void main(String[] args) {

        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        try {
            stmt = con.createStatement();

            /* 설명. 사용자로부터 조회하고자 하는 사원의 사번을 입력받음 */
            Scanner sc = new Scanner(System.in);
            System.out.print("사번을 입력하세요 : ");
            int empId = sc.nextInt();

            String entYn = "N";
            /* 설명. 입력받은 사번을 활용한 쿼리 작성 */
            /* empId는 varchar 형이라 문자형이 되도록 싱글 쿼테이션 (') 을 붙여줘야 한다. */
            /* 이 부분을 개선함으로써 SQL injection 공격을 막는다. */
            String query = "select emp_id, emp_name from employee where emp_id = '"
                    + empId + "' AND ENT_YN = '" + entYn + "'";
//            System.out.println("query = " + query);

            rset = stmt.executeQuery(query);

            if (rset.next()) {
                System.out.println(rset.getString("emp_id")
                        + ", " + rset.getString("emp_name"));

                // rset의 반환값은 null 이 안오기 때문에 if 조건문에서 not null 이 아니라 else로 번호가 없을 경우의 문구 출력
            } else {
                System.out.println("해당 사원의 조회 결과가 없습니다.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
            close(con);
        }
    }
}
