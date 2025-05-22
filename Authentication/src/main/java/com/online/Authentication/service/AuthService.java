package com.online.Authentication.service;

import com.online.Authentication.model.UserCredentials;
import com.online.Authentication.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    UserCredentialRepository userCredentialRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtService jwtService;

    public String saveUser(UserCredentials userCredentials){
        userCredentials.setPassword(passwordEncoder.encode(userCredentials.getPassword()));
        userCredentialRepository.save(userCredentials);
        return "User added to the database";
    }
    public String generateToken(String username) {

        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }


}
