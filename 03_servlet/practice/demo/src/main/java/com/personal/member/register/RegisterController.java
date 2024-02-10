package com.personal.member.register;

import com.personal.member.common.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/member/register")
public class RegisterController extends HttpServlet {

    Member memberInfo = new Member();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        memberInfo.setUserId(req.getParameter("userId"));
        memberInfo.setUserPass(req.getParameter("password"));
        memberInfo.setUserName(req.getParameter("name"));

        System.out.println("member정보 객체 생성됨");

        int result = RegisterService.registMember(memberInfo);

        /* 결과 받아서 출력해줄 서블릿으로 포워딩 추가 */
    }

}
