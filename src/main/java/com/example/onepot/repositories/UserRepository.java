package com.example.onepot.repositories;

import com.example.onepot.entities.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long > {
    Optional<User> findByEmail(String email);


}
