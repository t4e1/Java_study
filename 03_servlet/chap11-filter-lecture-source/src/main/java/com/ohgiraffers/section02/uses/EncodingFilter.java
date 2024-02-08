package com.ohgiraffers.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/member/*")
public class EncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        /* 설명. Tomcat 10 이상을 사용하면 적용 필요 없는 필터 (10버전은 기본 인코딩 설정이 UTF-8이기 때문) */
        /* 설명. 요청이 많은 POST 요청일 때는 UTF-8로 인코딩 설정을 사전 처리 후 제거 해 주고 이후 필터나 서블렛으로 넘길 수 있다. */
        if("POST".equals(httpRequest.getMethod())) {
            httpRequest.setCharacterEncoding("UTF-8");
        }

        filterChain.doFilter(httpRequest,servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
