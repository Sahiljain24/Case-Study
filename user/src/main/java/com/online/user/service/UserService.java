package com.online.user.service;

import com.online.user.DTO.UserDTO;
import com.online.user.models.Users;
import com.online.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public Users registerUser(UserDTO dto) {
        Users user = new Users();
        user.setUsername(dto.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());
        return userRepo.save(user);
    }

    public Users getUser(String username) {
        return userRepo.findByUsername(username);
    }
}
