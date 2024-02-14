package com.ohgiraffers.common;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<Product> items;      // = new ArrayList<>() 를 안하면 에러가 발생하기 때문에 에러 방지용으로 final 사용

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    /* 설명. 카트에 물품을 담는 기능 */
    public void addItem(Product item) {
        items.add(item);
    }

    /* 설명. 카트의 물품 꺼내는 기능 */
    public List<Product> getItems() {
        return items;
    }
}
