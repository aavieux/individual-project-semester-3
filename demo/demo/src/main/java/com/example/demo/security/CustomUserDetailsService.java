package com.example.demo.security;

import com.example.demo.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String user_email) throws UsernameNotFoundException { // load user by email
        return userService.getAllUsers()
                .stream().
                filter(user -> user.getUsername().equals(user_email))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + user_email));
    }
}
