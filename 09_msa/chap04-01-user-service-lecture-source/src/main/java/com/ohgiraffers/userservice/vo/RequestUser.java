package com.ohgiraffers.userservice.vo;

import lombok.*;

/* 설명. 회원가입을 위해 넘어온 사용자 정보를 받아 줄 Command 객체용 VO 생성*/
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class RequestUser {

    private String name;        // 사용자 이름
    private String email;       // 사용자 이메일
    private String pwd;         // 사용자 비밀번호

}
