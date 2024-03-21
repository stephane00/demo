package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.controller.HelloRestController;

@SpringBootTest
public class HelloRestControllerTests {
    @Autowired
    private HelloRestController helloRestController;

    @Test
    public void testHello() {
        String response = helloRestController.hello();
        assertThat(response.equals("Hello World!"));
    }
}