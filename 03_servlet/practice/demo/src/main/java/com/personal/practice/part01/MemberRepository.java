package com.personal.practice.part01;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class MemberRepository {

    public static int registMember(Connection con, Member memberInfo) throws IOException, SQLException {

        Properties prop = new Properties();
        prop.loadFromXML(
                new FileInputStream("src/main/java/com/personal/practice/config/sqlquery.xml"));

        String query = prop.getProperty("insert");

        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, memberInfo.getUserId());
        ps.setString(2, memberInfo.getUserPass());
        ps.setString(3, memberInfo.getUserName());

        int result = ps.executeUpdate();;

        return result;
    }
}
