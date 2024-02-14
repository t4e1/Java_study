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
        List<MemberDTO> members = memberService.findAllMembers();

        members.forEach(System.out::println);

        System.out.println("============ select 1 member =============");
        System.out.println(memberService.findMember(1L));


    }
}
