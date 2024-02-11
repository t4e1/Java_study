package com.personal.member.register;

import com.personal.member.common.Member;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

/* Repository 단에서 할 일 */
/* 1. Service로부터 받아온 객체(Connection, Member)를 사용하여 DB 쿼리 작성.
 * 2. 작성한 쿼리를 DB로 전달, 결과를 service로 반환
* */
public class RegisterRepository {

    public static int registMember(Connection con, Member memberInfo) {

        int result = 0;
        Properties prop = new Properties();     // 별도의 쿼리 파일을 가져오기 위해 Properties 객체 생성

        try {
            prop.loadFromXML(               //xml파일로부터 쿼리 읽어오기
                    new FileInputStream("C:/study/java/03_servlet/practice/demo/src/main/java/com/personal/member/config/sqlquery.xml"));
            String query = prop.getProperty("insert");  // String 객체에 읽어온 Properties 중 insert 키를가진 밸류 초기화

            PreparedStatement ps = con.prepareStatement(query); // DB에 적재할 쿼리 생성
//            System.out.println("스테이트먼트 생성됨");
            ps.setString(1, memberInfo.getUserId());    // plcaeholder로 받은 부분 채워 주기 (순서 잘 보고)
            ps.setString(2, memberInfo.getUserPass());
            ps.setString(3, memberInfo.getUserName());

//            System.out.println("ps = " + ps);

            result = ps.executeUpdate();        // 쿼리 실행. 조회를 제외한 CRUD는 전부 executeUpdate()로 실행 할 것
//            System.out.println("DB입력 완료됨, 값 반환");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        System.out.println("result : " + result);
        return result;          // 쿼리의 결과값 반환
    }
}
