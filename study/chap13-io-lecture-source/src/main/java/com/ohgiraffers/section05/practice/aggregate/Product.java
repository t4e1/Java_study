package com.ohgiraffers.section05.practice.aggregate;

import java.io.Serializable;
import java.time.LocalDateTime;


// DB에 저장될 데이터를 담은 객체를 만든다
public class Product implements Serializable {      // 객체 입출력을 위한 구현

    private int productCode;                        // 상품코드
    private String name;                            // 상품명
    private String brand;                           // 브랜드
    private int price;                              // 가격
    private int stockedAmount;                      // 재고수량
    private int incomingAmount;                     // 입고량
    private int releaseAmount;                      // 출고량
    private java.time.LocalDateTime stockedDate ;   // 입고일
    private java.time.LocalDateTime releaseDate ;   // 출고일

    public Product() {
    }

    public Product(int productCode, String name, String brand, int price, int stockedAmount, int incomingAmount, int releaseAmount) {
        this.productCode = productCode;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.stockedAmount = stockedAmount;
        this.incomingAmount = incomingAmount;
        this.releaseAmount = releaseAmount;
    }

    public Product(String productName, String productBrand, int productPrice) {
        this.name = productName;
        this.brand = productBrand;
        this.price = productPrice;
    }

    // 엔터티 클래스(DB에 전달될 클래스) 에서는 setter를 만들지 않는다. 필요한 경우에만 만들 것

    public int getProductCode() {
        return productCode;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    public int getStockedAmount() {
        return stockedAmount;
    }

    public int getIncomingAmount() {
        return incomingAmount;
    }

    public int getReleaseAmount() {
        return releaseAmount;
    }

    public LocalDateTime getStockedDate() {
        return stockedDate;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", stockedAmount=" + stockedAmount +
                ", incomingAmount=" + incomingAmount +
                ", releaseAmount=" + releaseAmount +
                ", stockedDate=" + stockedDate +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
