package com.ohgiraffers.section05.practice.stream;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/* ObjectOutputStream 중 새로 추가되는 데이터의 헤더부분을 지워서 이어쓰기가 가능하게 해주는 클래스 생성 */
/* ObjectOutputStream 의 기능을 그대로*/
public class MyOutputStream extends ObjectOutputStream {

    public MyOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    protected void writeStreamHeader() throws IOException {

    }
}
