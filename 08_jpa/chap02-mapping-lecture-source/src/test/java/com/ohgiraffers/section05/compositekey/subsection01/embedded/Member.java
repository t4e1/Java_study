package com.ohgiraffers.section05.compositekey.subsection01.embedded;

import jakarta.persistence.*;

@Entity(name="member_section05_subsection01")
@Table(name="tbl_member_section05+subsection01")
public class Member {
    @EmbeddedId
    private MemberPK memberPk;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;

    public Member() {
    }

    public Member(MemberPK memberPk, String phone, String address) {
        this.memberPk = memberPk;
        this.phone = phone;
        this.address = address;
    }

    public MemberPK getMemberPk() {
        return memberPk;
    }

    public void setMemberPk(MemberPK memberPk) {
        this.memberPk = memberPk;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberPk=" + memberPk +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
