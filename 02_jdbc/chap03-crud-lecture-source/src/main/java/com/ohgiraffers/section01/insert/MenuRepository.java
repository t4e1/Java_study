package com.ohgiraffers.section01.insert;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/* 설명. Service 로부터 넘겨받은 Connection 객체를 통해 DB에 쿼리를 날리고 결과를 반환한다. */
public class MenuRepository {
    public int registMenu(Connection con, Menu registMenu) {
        PreparedStatement pstmt = null;
        int result = 0;

        Properties prop = new Properties();

        /* 설명. 쿼리는 XML 파일로부터 읽어와서 활용할 것 */
        try {
            prop.loadFromXML(
                    new FileInputStream(
                            "src/main/java/com/ohgiraffers/section01/insert/mapper/menu-mapper.xml"));
            String query = prop.getProperty("insertMenu");

            /* 설명. 설정파일과 마찬가지로 쿼리의 수정이 이루어질 경우 리빌드할 필요 없이 파일수정으로 이루어질 수 있게 외부로 뺀다 */
//            System.out.println("query = " + query);

            pstmt = con.prepareStatement(query);
            pstmt.setString(1,registMenu.getMenuName());
            pstmt.setInt(2, registMenu.getMenuPrice());
            pstmt.setInt(3, registMenu.getCategoryCode());
            pstmt.setString(4, registMenu.getOrderableStatus());

            result = pstmt.executeUpdate();     // crud 는 전부 excuteUpdate()를 사용한다.
            System.out.println("result = " + result);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
