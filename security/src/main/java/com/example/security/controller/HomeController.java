package com.example.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Log4j2
@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome() {
        log.info("/home 요청");
        return "home";
    }

    // Authentication : org.springframework.security.core.
    // 로그인 성공시 Authentication 타입의 객체를 리턴해 준다
    // Authentication 객체 에는 회원에 담기는 Security 정보들이 담겨져있다
    @ResponseBody
    @GetMapping("/auth")
    public Authentication getAuthenticationInfo() {

        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();

        return authentication;
    }

}
