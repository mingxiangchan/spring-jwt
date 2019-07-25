package com.example.jwt.security;

import com.example.jwt.entities.User;
import com.example.jwt.repositories.UserRepository;
import com.example.jwt.security.CustomUserPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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

    public User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = null;

        if (principal instanceof String) {
            String userId = (String) principal;
            currentUser = repository.findById(Long.parseLong(userId)).orElse(null);
        } else if (principal instanceof CustomUserPrincipal) {
            CustomUserPrincipal customPrincipal = (CustomUserPrincipal) principal;
            currentUser = customPrincipal.getUser();
        }
        
       return currentUser;
    }
}
