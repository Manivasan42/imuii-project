package com.example.demoFinalProject.repo;

import com.example.demoFinalProject.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    com.example.demoFinalProject.model.Users findByUsername(String username);
}