package com.personal.member.register;

import com.personal.member.common.Member;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class RegisterRepository {

    public static int registMember(Connection con, Member memberInfo) {

        int result = 0;
        Properties prop = new Properties();

        try {
            prop.loadFromXML(
                    new FileInputStream("C:/study/java/03_servlet/practice/demo/src/main/java/com/personal/member/config/sqlquery.xml"));
            String query = prop.getProperty("insert");

            PreparedStatement ps = con.prepareStatement(query);
            System.out.println("스테이트먼트 생성됨");
            ps.setString(1, memberInfo.getUserId());
            ps.setString(2, memberInfo.getUserPass());
            ps.setString(3, memberInfo.getUserName());

            System.out.println("ps = " + ps);

            result = ps.executeUpdate();
            System.out.println("DB입력 완료됨, 값 반환");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
