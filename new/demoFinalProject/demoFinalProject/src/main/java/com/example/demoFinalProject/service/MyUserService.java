package com.example.demoFinalProject.service;

import com.example.demoFinalProject.model.UserPrincipal;
import com.example.demoFinalProject.model.Users;
import com.example.demoFinalProject.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    // Register a new user
    public ResponseEntity<String> registerUser(String username, String password) {
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));  // Encrypt the password before saving
        userRepository.save(user);
        return ResponseEntity.ok( "User Registered Successfully!");
    }

    // Get all users
    public ResponseEntity<List<Users>> getAllUser() {
        List<Users>users=userRepository.findAll();
        return ResponseEntity.ok(users);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);
        if (user == null) {
            System.out.println("user not found ");
            throw new UsernameNotFoundException("User Not Found");
        }
        return new UserPrincipal(user);
    }
}

//    public List<Users> getAllUser(){
//        return userRepository.findAll();
//    }
//}