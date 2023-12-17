package com.jaminel.minilibrary.repository;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  UserRepository extends JpaRepository<User,Long> {
    User getUserByFullName(String fullName);
    List<User> getAllUsers();

    User findByEmail(String email);
    void findUserByEmail(String email);
}
