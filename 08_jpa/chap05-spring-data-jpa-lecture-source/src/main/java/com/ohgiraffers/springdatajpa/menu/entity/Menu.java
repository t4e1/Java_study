package com.ohgiraffers.springdatajpa.menu.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity     // 이름을 지정하지 않으면 클래스의 이름이 그대로 Entity명이 된다 ( Menu )
@Table(name = "tbl_menu")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
//@Data // Data를 사용하면 생성자 ~ toString 까지 모든것을 만들어 주지만, 내부 클래스로 만들어지기 때문에 비효율적인 코드가 된다. -> 지양할 것
public class Menu {

    @Id
    @Column(name = "menu_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuCode;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_price")
    private int menuPrice;

    @Column(name = "category_code")
    private int categoryCode;

    @Column(name = "orderable_status")
    private String orderableStatus;

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}
