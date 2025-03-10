package com.example.DemoProject.repository;

import com.example.DemoProject.entity.UserEntity; // Ensure this is the correct import
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    public Optional<UserEntity> findByUsername(String username);

}