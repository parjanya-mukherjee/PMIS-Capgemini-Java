package com.parjanya30.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class printHello {

    @GetMapping("/")
    public String print() {
        return "Parjanya";
    }
}