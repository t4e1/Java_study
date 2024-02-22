package com.ohgiraffers.transactional.section01.annotation;

public class OrderMenu {
    private int menuCOde;
    private int orderCode;
    private int orderAmount;

    public OrderMenu() {
    }

    public OrderMenu(int menuCOde, int orderCode, int orderAmount) {
        this.menuCOde = menuCOde;
        this.orderCode = orderCode;
        this.orderAmount = orderAmount;
    }

    public int getMenuCOde() {
        return menuCOde;
    }

    public int getOrderCode() {
        return orderCode;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    @Override
    public String toString() {
        return "OrderMenu{" +
                "menuCOde=" + menuCOde +
                ", orderCode=" + orderCode +
                ", orderAmount=" + orderAmount +
                '}';
    }
}
