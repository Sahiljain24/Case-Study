package com.online.user.controller;

import com.online.user.DTO.UserDTO;
import com.online.user.models.Users;
import com.online.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Users> register(@RequestBody UserDTO dto) {
        return new ResponseEntity<>(userService.registerUser(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{username}")
    public ResponseEntity<Users> getUser(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUser(username));
    }
}
