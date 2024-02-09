package com.personal.practice.part01;

/* 입력받은 정보를 전달할 DTO 클래스 */
/* DTO 클래스 -> 생성자, getter/setter, toString 전부 생성할 것 */
public class Member {

    private int code;
    private String userId;
    private String userPass;
    private String userName;

    public Member() {
    }

    public Member(int code, String userId, String userPass, String userName) {
        this.code = code;
        this.userId = userId;
        this.userPass = userPass;
        this.userName = userName;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Member{" +
                "code=" + code +
                ", userId='" + userId + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
