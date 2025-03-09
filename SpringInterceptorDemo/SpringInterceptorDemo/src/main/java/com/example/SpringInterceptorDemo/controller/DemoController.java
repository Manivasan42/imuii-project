package com.example.SpringInterceptorDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/test")
    public String getNum(@RequestParam String value) {
        return value; // Return the value if present
    }

}