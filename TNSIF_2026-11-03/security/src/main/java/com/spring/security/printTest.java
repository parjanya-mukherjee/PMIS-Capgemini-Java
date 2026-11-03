package com.spring.security;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class printTest {

    @GetMapping("/")
    public String hi() {
        return "Hi Parjanya";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello Parjanya";
    }

    @GetMapping("/hallo")
    public String hallo() {
        return "Hallo, darling whassup?";
    }
}
