package com.testcomapany.section02.interfacepractice;

public class MemberService implements Board, Member, Product {

    /* 억지로 interface 사용해서 클래스 만들어 보기 */

    public void usingBoard() {
        System.out.println(Member.name + "이 " + Board.board_name + " 게시판을 이용합니다.");
    };
    public void memberInfo() {
        System.out.println(Member.name + "의 비밀번호는 " + password + " 입니다.");
    };
    public void sellingProduct() {
        System.out.println(Member.name + "에게 " + Product.name + "을 판매하였습니다.");
    };
}
