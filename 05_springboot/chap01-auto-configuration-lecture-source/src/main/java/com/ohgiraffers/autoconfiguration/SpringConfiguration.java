package com.ohgiraffers.autoconfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class SpringConfiguration {

    @Value("${test.value}")         // 설정 파일로부터 불러올 수 있음
    public String value;

    @Value("${test.age}")           // 서버의 환경 변수도 불러올 수 있다
    public String age;

    @Value("${test.array}")
//    public List<String> list;
    public String[] arr;

    @Bean
    public Object propertyReadTest() {
        System.out.println("value = " + value);
        System.out.println("age = " + age);

        System.out.println("===== 설정에서 읽어들인 여러 값 처리 =====");
//        list.forEach(System.out::println);
        Arrays.stream(arr).forEach(System.out::println);

        return new Object();
    }
}
