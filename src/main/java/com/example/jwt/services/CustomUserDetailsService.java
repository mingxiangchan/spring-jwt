package com.example.jwt.services;

import com.example.jwt.entities.User;
import com.example.jwt.repositories.UserRepository;
import com.example.jwt.security.CustomUserPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * UserDetailsService
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    // have to use the name loadUserByUsername due to old naming conventions
    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = repository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserPrincipal(user);
    }
}
