package com.ohgiraffers.section04.enumtype;

import jakarta.persistence.*;
import org.junit.jupiter.api.*;

public class EnumTypeMappingTests {
    private static EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

    @BeforeAll
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    public void initManager() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterAll
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    @AfterEach
    public void closeManager() {
        entityManager.close();
    }

    @Test
    public void 이넘_타입_매핑_테스트() {
        // given
        Member member = new Member();
        member.setMemberNo(1);
        member.setMemberId("user01");
        member.setMemberPwd("pass01");
        member.setNickname("홍길동");
        member.setPhone("010-1234-56789");
        member.setEmail("hong@gmail.com");
        member.setAddress("서울시 서초구");
        member.setEnrollDate(new java.util.Date());
        member.setMemberRole(RollType.ADMIN);
        member.setStatus("Y");

        // when
        /* 설명.
         *  테이블에 insert 할 때,
         *   1. @Enumerate(EnumType.ORDINAL) : 숫자로 값이 들어감. (ex: 0 또는 1)
         *   2. @Enumerate(EnumType.STRING) : 문자열로 값이 들어감. (ex: ADMIN 또는 MEMBER)
         *  (자바 객체 상에서는 "ADMIN" 또는 "MEMBER"라고만 나온다.
        * */
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(member);
        entityTransaction.commit();

        // then
        Member foundMember = entityManager.find(Member.class, member.getMemberNo());
        Assertions.assertEquals(member.getMemberNo(), foundMember.getMemberNo());
        System.out.println("foundMember = " + foundMember);
    }
}
