package com.personal.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/member/print2")
public class PrintScreen2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("여기까지 오나? ");
        StringBuilder result = new StringBuilder();

        result.append(req.getAttribute("result"));

        System.out.println(result);

        resp.setContentType("text/html");

        writer(resp, result);

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
