package com.ohgiraffers.section05.compositekey.subsection01.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

/* 설명.
 *  Embeddable 타입은 하나의 값의 묶음이자 불변 객체로 다루는 타입이다.
 *  (불변객체 : setter가 없고 필드값에 변화를 주고 싶으면 새로운 필드를 가지는 새로운 객체가 생성 되어야 한다.)
 *  그리고 equals, hashCode를 반드시 오버라이딩 해야 한다. (객체가 달라도 가지고 있는 값이 같으면 같은 객체로 취급한다.)
 *  VO와 유사하며, @EmbeddedId로 복합키를 표현하고자 할 때 쓰이기도 한다.
* */
@Embeddable
public class MemberPK  implements Serializable{
    @Column(name = "member_no")
    private int memberNo;
    @Column(name = "member_id")
    private String memberId;

    public MemberPK() {
    }

    public MemberPK(int memberNo, String memberId) {
        this.memberNo = memberNo;
        this.memberId = memberId;
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
}
