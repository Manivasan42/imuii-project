package com.example.demoFinalProject.repo;

import com.example.demoFinalProject.model.EmailDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmailRepository extends JpaRepository<EmailDetails,Integer> {
}
