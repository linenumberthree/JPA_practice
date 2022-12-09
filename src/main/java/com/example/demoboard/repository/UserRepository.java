package com.example.demoboard.repository;

import com.example.demoboard.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUserId(String id);
}
