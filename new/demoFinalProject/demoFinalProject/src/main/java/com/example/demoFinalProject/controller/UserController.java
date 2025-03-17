package com.example.demoFinalProject.controller;

import com.example.demoFinalProject.model.Users;
import com.example.demoFinalProject.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller // Changed to @Controller to render views (HTML pages)
@RequestMapping("/user")
public class UserController {

    @Autowired
    private MyUserService userService;

    // User Home page
    @GetMapping("/home")
    public String userHomePage() {
        return "userHome";  // This should map to the userHome.html view
    }

    // Render the login page (HTML)
    @GetMapping("/login")
    public String loginPage() {
        return "login";  // This maps to login.html view
    }

    // Render the user home page after login (HTML)
    @GetMapping("/userHome")
    public String userHomePage(Authentication authentication, Users users) {
        String username = authentication.getName();  // Get logged-in username
        users.addAttribute("username", username);  // Pass it to the view
        return "userHome";  // This maps to userHome.html
    }
    // Create a new user (register)
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Users users) {
        return userService.registerUser(users.getUsername(), users.getPassword());

    }

    // Get all users
    @GetMapping("/getall")
    public ResponseEntity<List<Users>> getUser() {
        return (ResponseEntity<List<Users>>) userService.getAllUser();
    }

}

