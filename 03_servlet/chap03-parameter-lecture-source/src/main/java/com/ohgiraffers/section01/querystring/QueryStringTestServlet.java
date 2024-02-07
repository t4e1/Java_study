package com.ohgiraffers.section01.querystring;

/* 필기. jakarta에서 가져오는 패키지는 tomcat이 제공해준다. 문제 발생시 톰캣 쪽 해결할 것 */
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet("/querystring")
public class QueryStringTestServlet extends HttpServlet {
    public QueryStringTestServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* 필기. GET 으로 넘어온 자료형은 전부 String 이다. */
        String name = req.getParameter("name");
        System.out.println("name = " + name);

        /* 필기. 스트링으로 넘어온 값을 integer로 랩핑해서 int에 저장 (파싱작업) */
        int age = Integer.valueOf(req.getParameter("age"));
        System.out.println("age = " + age);

        /* 필기. 스트링으로 넘어온 값을 sql에서 사용하는 Date로 랩핑해서 저장 (파싱작업) */
        java.sql.Date birthday = java.sql.Date.valueOf(req.getParameter("birthday"));
        System.out.println("birthday = " + birthday);

        String gender = req.getParameter("gender");
        System.out.println("gender = " + gender);

        String national = req.getParameter("national");
        System.out.println("national = " + national);

        /* 필기. 다중 선택이 가능한 값들은 배열로 넘어온다. getParameterValues() 로 받아올 것 */
        String[] hobbies = req.getParameterValues("hobbies");
        System.out.println("Arrays.toString(hobbies)  = " + Arrays.toString(hobbies));


    }
}
