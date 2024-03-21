package com.example.demo.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
    public String my_text = "Hello, You!";

    @GetMapping("/")
    @Secured("ROLE_USER")
    public String home(Model model) {
        model.addAttribute("message", my_text);
        return "home";
    }
}