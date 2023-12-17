package com.jaminel.minilibrary.service;

import com.jaminel.minilibrary.repository.UserRepository;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.CacheEvict;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    @CachePut(value = "users", key = "#user.id")
    public User addUser(User user) {
        return userRepository.save(user);
    }


    @CacheEvict(value = "users", key = "#id")
    public Object deleteUser(long id) {
        userRepository.deleteById(id);
        return null;
    }


    @CachePut(value = "users", key = "#id")
    public String updateUser(long id, User user) {
        User toUpdate = findUserById(id);
        toUpdate.setAge(user.getAge());
        toUpdate.setEmail(user.getEmail());
        toUpdate.setAddress(user.getAddress());
        toUpdate.setFullName(user.getFullName());
        userRepository.save(toUpdate);
        return "User updated sucessfully";
    }


    @CachePut(value = "users", key = "#userId")
    public User findUserById(long userId) {
        return userRepository.findById(userId).orElse(null);
    }


    @CachePut(value = "users", key = "#email")
    public String findUserByEmail(String email) {
        userRepository.findUserByEmail(email);
        return "User Id found";
    }


    @CachePut(value = "users", key = "#fullName")
    public User getUsersBYFullName(String fullName) {
        return userRepository.getUserByFullName(fullName);
    }


    @CachePut(value = "users", key = "all")
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }
}
