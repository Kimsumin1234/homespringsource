package com.example.web1.controller;

import org.springframework.stereotype.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String requestMethodName() {
        log.info("home 요청");
        return "index";
    }

}
