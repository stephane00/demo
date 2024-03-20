package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
class HelloControllerTest {
 	@Autowired
	private HelloController helloController;

	@Test
	void displayText() {
		assertThat(helloController.my_text.equals("Greetings from Spring Boot!"));
	}

}
