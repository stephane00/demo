package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.controller.HomeController;

@SpringBootTest
class HelloControllerTest {
    @Autowired
    private HomeController homeController;

	@Test
	void contextLoads() throws Exception {
		assertThat(homeController).isNotNull();
	}

	@Test
	void displayText() throws Exception {
		assertThat(homeController.my_text.equals("Greetings from Spring Boot!"));
	}

}
