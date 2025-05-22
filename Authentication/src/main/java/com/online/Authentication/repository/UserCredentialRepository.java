package com.online.Authentication.repository;

import com.online.Authentication.model.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCredentialRepository extends JpaRepository<UserCredentials, Long> {
    Optional<UserCredentials> findByUserName(String username);
}
