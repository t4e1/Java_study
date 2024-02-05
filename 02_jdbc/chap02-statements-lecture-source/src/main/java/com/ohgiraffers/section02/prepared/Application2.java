package com.ohgiraffers.section02.prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

/* 설명.
 *  PreparedStatement는 Statement와 달리 Placeholder(?)를 사용한 쿼리를 파싱하고 캐싱하여 다시 재해석 하는 과정을 생략한다.
 *  이런 이유로 불완전하게 작성된 쿼리 실행의 경우 Statement보다 빠르다.
* */
public class Application2 {

    /* 설명. 하자가 있는 쿼리(사용자의 입력을 받는 쿼리)를 받는 경우 */
    public static void main(String[] args) {
        Connection con = getConnection();
        ResultSet rset = null;
        PreparedStatement pstmt = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 사번을 입력해 주세요 : ");
        String empId = sc.nextLine();

        String entYn = "n";
        /* 설명. PreparedStatement는 Statement 때와 달리 placeholder(?) 를 활용한 하나의 문자열 형태로 쿼리 작성 가능 */
        /* 설명. 하자가 있는 쿼리 ( ? 자리에 뭐가 들어오는지에 따라 결과가 전혀 달라지는 쿼리 ) */
        String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = ? AND ENT_YN = ?";    // (?): placeholder 형태를 써서 하나의

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, empId);  // int값이면 setInt, double 값이면 setDouble 등 자료형에 따라 setter를 달리 쓴다
            pstmt.setString(2, entYn);
            rset = pstmt.executeQuery();

            if (rset.next()) {
                System.out.println(rset.getString("Emp_id")
                        + ", " + rset.getString("Emp_name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }
    }
}
