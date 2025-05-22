package com.online.Authentication.config;

import com.online.Authentication.model.UserCredentials;
import com.online.Authentication.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserCredentialRepository userCredentialRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserCredentials> credentials = userCredentialRepository.findByUserName(username);

        return credentials.map(CustomUserDetails::new).orElseThrow(()->new UsernameNotFoundException("User not found with Name: " + username));
    }
}
