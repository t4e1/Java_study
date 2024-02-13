package com.ohgiraffers.section01.autowired.subsection02.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context
                = new AnnotationConfigApplicationContext("com.ohgiraffers.section01");  // 컨테이너가 만들어 질때 해당 패스 아래에 어노테이션이 달린 객체를 찾는다.

        /* 설명. subsection01에 있는 BookService 타입의 bean과 혼선을 방지하고자 bean 이름(id) 수정 */
        BookService bookService = context.getBean("bookServiceConstructor", BookService.class);

        bookService.findAllBook().forEach(System.out::println);

        System.out.println(bookService.searchBookBySequence(1));
        System.out.println(bookService.searchBookBySequence(2));
    }
}
