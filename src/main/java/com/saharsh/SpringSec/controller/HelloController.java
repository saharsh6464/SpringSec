package com.saharsh.SpringSec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/admin/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("telusko")
    public String about(){
        return "saharsh";
    }

}
