package com.adobe.orderapp.security.dao;


import com.adobe.orderapp.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserDao extends JpaRepository<User, Integer> {
    // Since email is unique, we'll find users by email
    Optional<User> findByEmail(String email);

}

