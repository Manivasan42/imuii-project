package com.example.demoFinalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class ServiceController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/call-service-b")
    public String callServiceB() {
        String serviceBUrl = "http://localhost:8081/api/message";
        return restTemplate.getForObject(serviceBUrl, String.class);
    }
}
