package com.ohgiraffers.userservice.security;

import com.ohgiraffers.userservice.service.UserService;
import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurity {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final Environment env;

    @Autowired
    public WebSecurity(UserService userService
            , BCryptPasswordEncoder bCryptPasswordEncoder
            , Environment env) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.env = env;
    }

    /* 설명. 인가(Authorization)용 메소드 */
    /* 식별이 되고 나서도 회원에게 어떤 권한을 줄 것인지를 정하는 메소드 */
    /* 인가가 안되면 403 에러 발생 */
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {

        /* 설명. 로그인 시 추가할 내용 */
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);

        AuthenticationManager authenticationManager = authenticationManagerBuilder.build();

        /* 설명. 세션 방식 요청을 할 때 csrf(교차 사이트 공격)에 대해 처리해주는 옵션 */
        /* 설명. 토큰 방식 로그인(JWT 로그인)에서는 처리하지 않아도 된다. */
        http.csrf((csrf) -> csrf.disable());

        /* spring boot 3.x.x 부터 변경된 부분. */
        http.authorizeHttpRequests((auth) -> auth
                .requestMatchers(new AntPathRequestMatcher("/users/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/health-check")).permitAll()
        )
                .authenticationManager(authenticationManager);

        http.addFilter(getAuthenticationFilter(authenticationManager));

        return http.build();
    }

    private Filter getAuthenticationFilter(AuthenticationManager authenticationManager) {

        return new AuthenticationFilter(authenticationManager, userService, env);
    }


    /* 설명. 인증(Authentication)용 메소드 */
    /* 사용자가 로그인을 할 때 우리 회원이 맞는지 아닌지 식별하는 메소드 */
    /* 인증이 안되면 401 에러 발생 */


}
