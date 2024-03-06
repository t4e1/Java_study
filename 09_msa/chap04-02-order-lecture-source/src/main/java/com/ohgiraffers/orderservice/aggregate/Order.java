package com.ohgiraffers.orderservice.aggregate;

import lombok.Data;

import java.util.List;

/* 설명. OrderMenu와 Collection 관계(1대 N관계 조인용으로 작성) */
@Data
public class Order {

    private int orderCode;
    private int userId;
    private String orderDate;
    private String orderTime;
    private int totalOrderPrice;

    private List<OrderMenu> orderMenus;

}
