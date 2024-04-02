package com.example.web1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.web1.dto.AddDto;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/calc")
@Log4j2
@Controller
public class AddController {
    // 링크 요청
    @GetMapping("/add")
    public void addGet() {
        log.info("/calc/add 요청");

    }

    @PostMapping("/add")
    public void addPost(@RequestParam(value = "op1", defaultValue = "0") int num1,
            @RequestParam(value = "op2", defaultValue = "0") int num2) {
        log.info("/calc/add post 요청");
        log.info("num1 {}", num1);
        log.info("num2 {}", num2);
    }

    // 3. Dto 를 사용한다
    // - 장점 : post 컨트롤러 응답 후 보여지는 화면단에서 dto 에 들어있는 값을 사용할수있다
    // @PostMapping("/add")
    // public void addPost(AddDto addDto) {
    // log.info("/calc/add post 요청");
    // log.info("num1 {}", addDto.getNum1());
    // log.info("num2 {}", addDto.getNum2());
    // }

    // 2. 파라메터를 사용한다
    // @PostMapping("/add")
    // public void addPost(int num1, int num2) {
    // log.info("/calc/add post 요청");
    // log.info("num1 {}", num1);
    // log.info("num2 {}", num2);
    // }

    // 1. HttpServletRequest req 를 사용한다
    // @PostMapping("/add")
    // public void addPost(HttpServletRequest req) {
    // log.info("/calc/add post 요청");
    // log.info("num1 {}", req.getParameter("num1"));
    // log.info("num2 {}", req.getParameter("num2"));
    // }

}
