package com.ohgiraffers.section02.headers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

@WebServlet("/header")
public class ResponseHeaderPrintServlet extends HttpServlet {
    public ResponseHeaderPrintServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* 설명. 서버의 현재 시간을 동적인 페이지로 만들어 내보내 보자. */
        /* 설명. response 객체르 생성할 때는 MIME 타입 및 인코딩을 고려할 것 */
        resp.setContentType("text/html");

        /* 필기. out이라는 스트림을 만들어서 response가 가지고 있는 위치로 내보낼 것이다. */
        PrintWriter out = resp.getWriter();

        long currentTime = System.currentTimeMillis();

        out.print("<h1>" + currentTime + "</h1>");
        out.print("<h1>" + new java.util.Date(currentTime) + "</h1>");
        out.flush();
        out.close();

        /* 설명. response 객체의 header값에 대한 키값과 밸류 값을 한번에 확인해 보기 */
        /* 설명. response는 Collection 타입을 반환한다. */
        Collection<String> responseHeaders = resp.getHeaderNames();
        Iterator<String> iter = responseHeaders.iterator();
        while (iter.hasNext()) {
            String headerName = iter.next();
            System.out.println(headerName + ": " + resp.getHeader(headerName));
        }
    }
}
