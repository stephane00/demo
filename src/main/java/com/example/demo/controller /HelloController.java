package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {
    public String my_text = "Greetings from Spring Boot!";

	@GetMapping("/")
	public String index(Model model) {
        model.addAttribute("helloWorld", my_text);
		return "home";
	}

}