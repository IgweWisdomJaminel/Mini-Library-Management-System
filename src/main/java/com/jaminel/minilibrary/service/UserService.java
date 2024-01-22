package com.jaminel.minilibrary.service;

import com.jaminel.minilibrary.dto.UserDto;
import com.jaminel.minilibrary.repository.UserRepository;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    @CachePut(value = "User", key = "#user.id")
    public User addUser(UserDto userDto)
    {User user = UserDto.build(userDto.getFullName(), userDto.getAge(),userDto.getAddress(),userDto.getEmail());
        return userRepository.save(user);
    }


    @CacheEvict(value = "User", key = "#id")
    public Map<String,String> deleteUser(long id) {
        userRepository.deleteById(id);
        return Map.of("message","User Deleted");
    }


    @CachePut(value = "User", key = "#id")
    public User updateUser(long id, UserDto userDto) {
        User toUpdate = userRepository.findUserByUserId(id);
     toUpdate =UserDto.build(userDto.getFullName(), userDto.getAge(),userDto.getAddress(),userDto.getEmail());
        return userRepository.save(toUpdate);
    }


    @CachePut(value = "User", key = "#userId")
    public User findUserById(long userId) {
        return userRepository.findById(userId).orElse(null);
    }


    @CachePut(value = "User", key = "#email")
    public String findUserByEmail(String email) {
        userRepository.findUserByEmail(email);
        return "User Id found";
    }


    @CachePut(value = "User", key = "#fullName")
    public User getUsersBYFullName(String fullName) {
        return userRepository.getUserByFullName(fullName);
    }


    @Cacheable("User")
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }
}
