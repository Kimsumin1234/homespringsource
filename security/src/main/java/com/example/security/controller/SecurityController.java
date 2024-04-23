package com.example.security.controller;

import org.springframework.stereotype.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
@RequestMapping("/security")
public class SecurityController {

    @GetMapping("/guest")
    public void getGuest() {
        log.info("/security/guest 요청");
    }

    @GetMapping("/member")
    public void getMember() {
        log.info("/security/member 요청");
    }

    @GetMapping("/admin")
    public void getAdmin() {
        log.info("/security/admin 요청");
    }

}
