package com.ohgiraffers.section05.compositekey.subsection02.idclass;

import java.io.Serializable;
import java.util.Objects;

/* 설명. Serializable 은 마커 인터페이스로, 자바 내부적으로 Serializable 타입을 어떻게 다루겠다 라는 것을 처리하기 위한 인터페이스이다. */
/* 설명. IdClass 타입으로 쓰인 클래스도 1차 캐시에서 식별자로 쓰이는 객체이므로, equals + hashCode 를 오버라이딩 해야 한다. */
public class MemberPK implements Serializable {
    private int memberNo;
    private String memberId;

    public MemberPK() {
    }

    public MemberPK(int memberNo, String memberId) {
        this.memberNo = memberNo;
        this.memberId = memberId;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public String getMemberId() {
        return memberId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        MemberPK memberPK = (MemberPK) object;
        return memberNo == memberPK.memberNo && Objects.equals(memberId, memberPK.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberNo, memberId);
    }

    @Override
    public String toString() {
        return "MemberPK{" +
                "memberNo=" + memberNo +
                ", memberId='" + memberId + '\'' +
                '}';
    }
}
