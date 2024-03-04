package com.ohgiraffers.userservice.controller;

import com.ohgiraffers.userservice.dto.UserDTO;
import com.ohgiraffers.userservice.vo.HelloVO;
import com.ohgiraffers.userservice.vo.RequestUser;
import com.ohgiraffers.userservice.vo.ResponseUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/")
public class UserController {

    private Environment env;
    private HelloVO helloVo;
    private ModelMapper modelMapper;

    @Autowired
    public UserController(Environment env, HelloVO helloVO, ModelMapper modelMapper) {
        this.env = env;
        this.helloVo = helloVO;
        this.modelMapper = modelMapper;
    }

    /* 설명.
     *  application.yml 파일로부터 설정 값을 불러오기 위해서는 두 가지 방법이 제공된다.
     *  1. Environment를 의존성 주입 받아 getProperty로 설정 키 값을 작성해 불러오는 방법.
     *  2. @Value를 활용해 필드로 주입 받고 활용하는 방법
    * */

    /* 설명. 1. Environment를 활용해 설정값 불러오기(get Property) */
    @GetMapping("/health-check")
    public String status() {
        return "Server at " + env.getProperty("local.server.port")
                + " swcamp.message: " + env.getProperty("swcamp.message");

    }

    /* 설명. 2. @Value 활용해 설정값 불러오기(getter) */
    @GetMapping("/do-msa")
    public String doMsa() {
        return helloVo.getMesssage();
    }

    /* 설명. 회원가입(POST - /users) */
    @PostMapping("/users")
    public ResponseEntity<ResponseUser> registUser(@RequestBody RequestUser user) {

        UserDTO newUser = modelMapper.map(user, UserDTO.class);
        System.out.println("newUser = " + newUser);

        ResponseUser responseUser = new ResponseUser();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseUser);
    }

}
