package com.personal.member.register;

import com.personal.member.common.Member;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/* 회원 등록 시 사용하는 서블릿. CRUD 작업인 만큼 doPost로 받아서 처리한다. */
/* 컨트롤러단에서는 입력받은 데이터와 DTO 클래스를 사용해 서비스단으로 넘겨줄 객체를 생성 */
@WebServlet("/member/register")
public class RegisterController extends HttpServlet {

    Member memberInfo = new Member();           // 입력받은 파라미터를 담을 객체 생성

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        memberInfo.setUserId(req.getParameter("userId"));           // 생성한 객체에 req헤더로 넘어온 파라미터 담기
        memberInfo.setUserPass(req.getParameter("password"));
        memberInfo.setUserName(req.getParameter("name"));

//        System.out.println("member정보 객체 생성됨");

        int result = RegisterService.registMember(memberInfo);          // 결과 변수 생성 & 서비스단 호출로 멤버객체 넘김

        /* Controller -> Service -> Repository -> DB -> Repository -> Service -> Controller 로 넘어온 결과값 */
        /* attribute에 넣어서 화면 출력 서블릿으로 넘길 수 있게함  */
        req.setAttribute("result", result);
//        System.out.println("결과 반환 되나??");

        /* 결과 받아서 출력해줄 서블릿으로 포워딩 추가 */
        RequestDispatcher printRd = req.getRequestDispatcher("print");
//        System.out.println("포워드까지 되나? ");
        printRd.forward(req, resp);
//        System.out.println("되면 출력");
    }

}
