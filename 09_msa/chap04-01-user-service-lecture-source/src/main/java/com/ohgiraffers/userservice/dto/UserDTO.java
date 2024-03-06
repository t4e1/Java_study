package com.ohgiraffers.userservice.dto;

import com.ohgiraffers.userservice.vo.ResponseOrder;
import lombok.*;

import java.util.List;

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

    private List<ResponseOrder> orders;
}
