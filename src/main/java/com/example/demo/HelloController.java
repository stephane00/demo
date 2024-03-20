package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    public String my_text = "Greetings from Spring Boot!";

	@GetMapping("/")
	public String index() {
		return my_text;
	}

}