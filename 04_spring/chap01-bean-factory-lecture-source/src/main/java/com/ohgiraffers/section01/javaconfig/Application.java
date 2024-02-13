package com.ohgiraffers.section01.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context =       // bean이라는 객체를 관리하는 spring container 생성
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println("beanName: " + beanName);
        }

        /* 설명. 1. bean의 id(bean의 이름)를 이용해서 bean을 가져오는 방법 */
//        MemberDTO member = (MemberDTO) context.getBean("member");

        /* 설명. 2. bean의 클래스 메타 정보(bean의 타입)를 전달하여 가져오는 방법 */
        /* .class는 이 타입과 일치하는 클래스를 꺼내준다 */
//        MemberDTO member = context.getBean(MemberDTO.class);

        /* 설명. 3. bean의 id와 클래스 메타 정보를 전달하여 가져오는 방법 */
        /* MemberDTO 중에서 "member"와 일치하는 것만 꺼내준다. */
        MemberDTO member = context.getBean("member", MemberDTO.class);


//        System.out.println("member = " + member);
    }
}
