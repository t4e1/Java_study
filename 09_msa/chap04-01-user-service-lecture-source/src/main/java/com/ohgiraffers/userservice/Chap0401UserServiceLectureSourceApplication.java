package com.ohgiraffers.userservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class Chap0401UserServiceLectureSourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chap0401UserServiceLectureSourceApplication.class, args);
	}

	/* 설명. ModelMapper 빈으로 등록(필요하면 의존성 주입 받을 예정) */
	/* 설명. Spring 이 알아서 객체 관리해달라 -> 필요할 때마다 new ModelMapper 하지 않고 사용하기 위해서 */
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
