package com.personal.practice.part01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/memberRegister")
public class MemberController extends HttpServlet {

    Member memberInfo = new Member();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        memberInfo.setUserId(req.getParameter("userId"));
        memberInfo.setUserPass(req.getParameter("password"));
        memberInfo.setUserId(req.getParameter("name"));

        MemberService.registMember(memberInfo);
    }

}
