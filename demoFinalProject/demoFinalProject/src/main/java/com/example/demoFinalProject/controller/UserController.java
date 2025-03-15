package com.example.demoFinalProject.controller;

import com.example.demoFinalProject.model.Users;
import com.example.demoFinalProject.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    // Login page
    @GetMapping("/login")
    public String loginPage() {
        return "login";  // This should map to the login.html view
    }

    // Create a new user (register)
    @PostMapping("/register")
    public String registerUser(@RequestBody Users users) {
        return userService.registerUser(users.getUsername(), users.getPassword());
    }

    // Get all users
    @GetMapping("/getall")
    public List<Users> getUser() {
        return userService.getAllUser();
    }

    // User Home page after login
    @GetMapping("/userHome")
    public String userHomePage(Authentication authentication, Model model) {
        // Get the logged-in user's username
        String username = authentication.getName();  // Retrieves the current logged-in user's username
        model.addAttribute("username", username);  // Pass the username to the view
        return "userHome";  // This maps to userHome.html
    }
}
