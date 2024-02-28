package com.ohgiraffers.springdatajpa.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
/* 설명. 페이징 처리용 버튼을 위한 정보가 정의된 클래스 */
public class PagingButtonInfo {

    private int currentPage;
    private int startPage;
    private int endPage;
}
