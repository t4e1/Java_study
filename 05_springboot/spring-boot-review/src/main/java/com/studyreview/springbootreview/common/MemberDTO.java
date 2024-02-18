package com.studyreview.springbootreview.common;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemberDTO {

    private String userId;
    private String userPwd1;
    private String userPwd2;
    private String userName;
    private int userAge;
    private List<String> LiquorInterest;

    public MemberDTO() {
    }

    public MemberDTO(String userId, String userPwd1, String userPwd2, String userName, int userAge, List<String> liquorInterest) {
        this.userId = userId;
        this.userPwd1 = userPwd1;
        this.userPwd2 = userPwd2;
        this.userName = userName;
        this.userAge = userAge;
        LiquorInterest = liquorInterest;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd1() {
        return userPwd1;
    }

    public void setUserPwd1(String userPwd1) {
        this.userPwd1 = userPwd1;
    }

    public String getUserPwd2() {
        return userPwd2;
    }

    public void setUserPwd2(String userPwd2) {
        this.userPwd2 = userPwd2;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public List<String> getLiquorInterest() {
        return LiquorInterest;
    }

    public void setLiquorInterest(List<String> liquorInterest) {
        LiquorInterest = liquorInterest;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "userId='" + userId + '\'' +
                ", userPwd1='" + userPwd1 + '\'' +
                ", userPwd2='" + userPwd2 + '\'' +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", LiquorInterest=" + LiquorInterest +
                '}';
    }
}

