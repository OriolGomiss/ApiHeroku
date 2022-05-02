package com.example.apispringboot.Model.Repository;

import com.example.apispringboot.Model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}