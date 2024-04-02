package com.example.web1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.web1.dto.LoginDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@Log4j2
@RequestMapping("/member")
public class MemberController {
    @GetMapping("/login")
    public void getLogin() {
        log.info("/member/login 로그인 페이지 요청");
    }

    @PostMapping("/login")
    public String postLogin(LoginDto loginDto) {
        log.info("/member/login post 로그인 정보 가져오기");
        log.info("email {}", loginDto.getEmail());
        log.info("name {}", loginDto.getName());

        return "/member/info";
    }

}
