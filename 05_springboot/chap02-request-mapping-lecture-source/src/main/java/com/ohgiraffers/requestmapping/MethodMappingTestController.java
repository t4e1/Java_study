package com.ohgiraffers.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MethodMappingTestController {  // DDD 개발 기준 도메인(컨텍스트) 별로 하나씩 만들어진다.

    /* 설명. Handler Method라 부른다. */
    /* 설명. 어노테이션을 활용해서 요청 방식 및 경로에 따라 각각 메소드가 작성 된다.*/
    @RequestMapping(value = "/menu/regist") // 메소드를 명시 하지 않으면 GET이외의 다른 요청도 전부 처리된다.
//    @RequestMapping(value = "/menu/regist", method = RequestMethod.GET)
    public String registMenu(Model model) {     // Model은 응답할 페이지의 재료를 담는 객체이다. Model = Request라고 생각해도 무방하다.
        System.out.println("/menu/regist 경로의 GET 요청 받아보기");

        model.addAttribute("message", "신규 메뉴 등록용 핸들러 메소드 호출함...");

        /* 설명. 핸들러 메소드에서 반환하는 String 값은 templates에 있는 view(html파일)의 이름이다.*/
        return "mappingResult";
    }

    @RequestMapping(value = "/menu/modify", method = RequestMethod.POST)
    public String modifyMenu(Model model) {
        model.addAttribute("message", "POST방식의 메뉴 수정용 핸들러 메소드 호출함...");
        return "mappingResult";
    }

    @GetMapping("/menu/delete")
    public String getDeleteMenu(Model model) {
        model.addAttribute("message", "GET방식의 메뉴 삭제용 핸들러 메소드 호출함...");
        return "mappingResult";
    }

    @PostMapping("/menu/delete")
    public String postDelete(Model model) {
        model.addAttribute("message", "POST방식의 메뉴 삭제용 핸들러 메소드 호출함...");
        return "mappingResult";
    }
}
