package com.ohgiraffers.restapi.section01.response;

public class Message {

    private int httpStatusCode;
    private String Message;

    public Message() {
    }

    public Message(int httpStatusCode, String message) {
        this.httpStatusCode = httpStatusCode;
        Message = message;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "httpStatusCode=" + httpStatusCode +
                ", Message='" + Message + '\'' +
                '}';
    }
}
