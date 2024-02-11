package com.personal.member.register;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/member/print")
public class PrintScreenServlet extends HttpServlet {

    /* doPost 서블릿에서 포워딩한 서블릿에는 doPost를 사용한다. */
    /* redirect의 경우에는 doPost로 시작해도 doGet으로 처리할 것 */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("여기까지 나오나???-----1");
        StringBuilder sb = new StringBuilder();
        int result = (Integer)req.getAttribute("result");

        resp.setContentType("text/html");
        System.out.println("여기까지 나오나???-----2");

        if (result > 0) {
            sb.append("<h3 align=\"center\">")
                    .append(req.getParameter("name"))
                    .append(" 회원님이 성공적으로 가입되었습니다. </h3>");

            writer(resp, sb);

        } else {
            sb.append("<h3 align=\"center\"> 회원 가입에 실패하였습니다. 다시 입력해주세요 </h3>");

            writer(resp, sb);

        }
    }

    private void writer(HttpServletResponse resp, StringBuilder sb) {

        PrintWriter outWriter = null;

        try {
            outWriter = resp.getWriter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        outWriter.print(sb);
        outWriter.flush();
        outWriter.close();

    }
}
