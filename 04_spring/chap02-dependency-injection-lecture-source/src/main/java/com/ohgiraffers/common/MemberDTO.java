package com.ohgiraffers.common;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberDTO {

    private int sequence;               // 회원번호
    private String name;                // 회원이름
    private String phone;               // 휴대폰 번호
    private String email;               // 이메일 주소
    private Account personalAccount;    // 개인 계좌
//    private Account personalAccount = new Account();  //new 로 객체를 생성하지 않고 DI에서 자동으로 해줌


}
