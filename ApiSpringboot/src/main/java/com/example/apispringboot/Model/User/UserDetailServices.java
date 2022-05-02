package com.example.apispringboot.Model.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServices implements UserDetailsService {
    private final UserService serveiUsuarisUserDetails;


    public UserDetailServices(UserService serveiUsuarisUserDetails) {
        this.serveiUsuarisUserDetails = serveiUsuarisUserDetails;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return serveiUsuarisUserDetails.consultarPerUsername(username);
    }}

