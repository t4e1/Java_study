package com.personal.member;

import com.personal.member.common.Member;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;

@WebServlet("/member/viewer")
public class ViewerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Member viewInfo = new Member();

        viewInfo.setUserId(req.getParameter("userId"));
        viewInfo.setUserPass(req.getParameter("password"));

        String result = MemberService.viewMember(viewInfo);

        req.setAttribute("result", result);
        RequestDispatcher printRd = req.getRequestDispatcher("print2");
        printRd.forward(req, resp);
    }
}
