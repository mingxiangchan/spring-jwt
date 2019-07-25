package com.example.jwt.repositories;

import com.example.jwt.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}