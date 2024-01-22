package com.jaminel.minilibrary.repository;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface  UserRepository extends JpaRepository<User,Long> {
    User getUserByFullName(String fullName);
    List<User> getAllUsers();
User findUserByUserId(long id);
    User findByEmail(String email);
    void findUserByEmail(String email);
}
