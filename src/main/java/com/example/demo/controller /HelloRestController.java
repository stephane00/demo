package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloRestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}