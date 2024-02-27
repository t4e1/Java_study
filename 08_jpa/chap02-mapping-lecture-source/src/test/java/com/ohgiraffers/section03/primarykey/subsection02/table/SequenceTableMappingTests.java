package com.ohgiraffers.section03.primarykey.subsection02.table;

import com.ohgiraffers.section03.primarykey.subsection02.table.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.List;

public class SequenceTableMappingTests {

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

    /* 설명.
     *  strategy : 자동 생성 전략을 지정
     *   - GenerationType.IDENTITY : 기본 키 생성을 데이터베이스에 위임(MySQL, MariaDB의 auto_increment)
     *   - GenerationType.SEQUENCE : 데이터베이스 시퀀스 객체 사용(ORACLE의 SEQUENCE)
     *   - GenerationType.TABLE : 키 생성 테이블 사용
     *   - GenerationType.AUTO : 자동 선택(MySQL의 IDENTITY 또는 ORACLE이면 SEQUENCE)
     * */

    @Test
    public void 식별자_매핑_테스트() {
        // given
        Member member = new Member();
//        member.setMemberNo(1);
        member.setMemberId("user01");
        member.setMemberPwd("pass01");
        member.setNickname("홍길동");
        member.setPhone("010-1234-56789");
        member.setEmail("hong@gmail.com");
        member.setAddress("서울시 서초구");
        member.setEnrollDate(new java.util.Date());
        member.setMemberRole("ROLE_MEMBER");
        member.setStatus("Y");

        Member member2 = new Member();
//        member2.setMemberNo(1);
        member2.setMemberId("user02");
        member2.setMemberPwd("pass02");
        member2.setNickname("유관순");
        member2.setPhone("010-1111-5555");
        member2.setEmail("you@gmail.com");
        member2.setAddress("서울시 강남구");
        member2.setEnrollDate(new java.util.Date());
        member2.setMemberRole("ROLE_MEMBER");
        member2.setStatus("Y");

        // when
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(member);
        entityManager.persist(member2);

        entityTransaction.commit();

        // then
        Member selectedMember1 = entityManager.find(Member.class, 1);
       Member selectedMember2 = entityManager.find(Member.class, 2);
        System.out.println("selectedMember1 = " + selectedMember1);
        System.out.println("selectedMember2 = " + selectedMember2);

        String jpql = "SELECT A.memberNo FROM member_section03_subsection02 A";
        List<Integer> memberNoList = entityManager.createQuery(jpql, Integer.class).getResultList();

        memberNoList.forEach(System.out::println);


    }
}
