package com.ohgiraffers.handlermethod;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
/* 설명. 현재의 Controller 클래스에 작성할 핸들러 메소드들이 모두 /first/xxx의 요청을 받게 될 때 클래스에 어노테이션을 추가할 수 있다. */
@RequestMapping("/first")       // 공통적인 경로를 빼낼 수 있음.
public class FirstController {

    /* 설명. 반환형이 void인 핸들러 메소드는 요청 경로 자체가 view의 경로 및 이름을 반환한 것으로 해석이 된다. */
    @GetMapping("/regist")       // '/regist' 또는 'regist' 둘 다 허용
//    public String regist(Model model) {
//        return "/first/regist";
//    }
    public void regist() {
    }  //

    /* 설명. request를 쓰게 된다면 request 개념은 사용자의 입력값(파라미터)이 존재하고, model은 동적 페이지의 재료(어트리뷰트)를 담는 용도로 쓰자. */
    @PostMapping("regist")
//    public String registMenu(HttpServletRequest req) {
    /* 서블릿과 스프링의 차이점 */
    /* 서블릿은 doGet / doPost 를 오버라이딩 했을 때 바로 req, resp가 파라미터로 들어오지만,
     * 스프링에서는 사용할 파라미터를 직접 입력해서 받아야 한다.
     * 리퀘스트도 HttpServletRequest 로 받지 말고 WebRequest로 받는 것이 좋다.
    * */
      public String registMenu(WebRequest req, Model model) {
        String name = req.getParameter("name");
        System.out.println("name = " + name);

        int price = Integer.valueOf(req.getParameter("price"));
        int categoryCode = Integer.valueOf(req.getParameter("categoryCode"));
        String message
                = name + " 을(를) 신규 메뉴 목록의 " + categoryCode + " 번 카테고리에 "
                + price + "원으로 등록하였습니다 !!";
        model.addAttribute("message", message);

        return "first/messagePrinter";
    }
}
