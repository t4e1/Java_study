package com.ohgiraffers.userservice.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    private String email;
    private String name;
    private String pwd;
    private String userId;
    private java.util.Date enrollDate;
}
