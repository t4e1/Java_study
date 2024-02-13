package com.ohgiraffers.common;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.Map;

/* 설명.
 *  DAO 클래스는 Data Access Object를 줄인 말로 Repository 계층과 마찬가지로 java application과
 *  Database를 연동시켜 주기 위한 계층의 클래스로 활용된다. (Repository라 생각해도 된다.)
 *  조회 기능에는 DAO를 사용, 조회 이외의 CRUD에 대해서는 Repository 라는 개념을 사용할 예정 (CQRS패턴)
* */

/* 설명. DB와 연동하기 위해 사용되는 클래스에 추가하는 어노테이션으로 bean으로 관리될 수 있게 어노테이션을 추가한다. */
@Repository         //DB랑 연동하기 위한 클래스를 bean으로 관리해 달라라는 의미. DB에 문제가 발생하면 java exception 으로 던져준다.
//@Controller         // 들어가 보면 전부 @Conmponent 를 가지고 있다. Componenet가 있어서 bean으로 관리가 되는 것
//@Service

/* 설명. 클래스에 계층의 의미가 없이(추가적인 기능 없이) 단순히 bean으로 관리될 클래스는 @Component를 붙일 수 있다. */
//@Component          //계층에 관계 없이 그냥 bean으로만 관리해달라 ( Repository = Component + @ )
public class MemberDAO {

    private final Map<Integer, MemberDTO> memberMap;

    public MemberDAO() {
        memberMap = new HashMap<>();

        memberMap.put(1, new MemberDTO(1, "user01", "pass01", "홍길동"));
        memberMap.put(2, new MemberDTO(2, "user02", "pass02", "유관순"));
    }

    /* 설명. 회원 조회용 메소드 */
    public MemberDTO selectMemeber(int sequence) {
        return memberMap.get(sequence);
    }

    /* 설명. 회원 가입용 메소드 */
    public int insertMember(MemberDTO newMember) {
        int before = memberMap.size();

        memberMap.put(newMember.getSequence(), newMember);

        int after = memberMap.size();

        return after - before;
    }

}
