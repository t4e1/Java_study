package com.ohgiraffers.section01.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context
                = new AnnotationConfigApplicationContext("com.ohgiraffers.section01.aop");

        MemberService memberService = context.getBean("memberService", MemberService.class);
        System.out.println("============ select all members =============");

        /* 설명. findAllMembers 호출 이후 AfterReturning Advice 가 회원 한명을 추가하니 아래 예외 테스트 시에는 주석할 것  */
        List<MemberDTO> members = memberService.findAllMembers();
        members.forEach(System.out::println);

        System.out.println("============ select 1 member =============");
        System.out.println(memberService.findMember(1));

        /* 설명. 2번 인덱스에 해당하는 회원 조회(AfterThrowing Dvice 확인용)(2번 인덱스 회원은 없음(회원이 2명이므로))*/
//        System.out.println(memberService.findMember(2));


    }
}
