package com.ohgiraffers.section03.delete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class Application1 {

    public static void main(String[] args) {
        Connection con = getConnection();

        PreparedStatement pstmt = null;
        Properties prop = new Properties();

        /* 설명. soft delete */
//        String query1 = "UPDATE TBL_MENU SET ORDERABLE_STATUS = 'N' WHERE MENU_CODE = ?";

        /* 설명. hard delete */
        String query2 = "DELETE FROM TBL_MENU WHERE MENU_CODE = ?";

        int result = 0;
        try {
            pstmt = con.prepareStatement(query2);

            pstmt.setInt(1, 109 );
            result = pstmt.executeUpdate();

            if (result > 0) {
                commit(con);
            } else {
                rollback(con);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(con);
        }

        System.out.println("result = " + result);

    }
}
