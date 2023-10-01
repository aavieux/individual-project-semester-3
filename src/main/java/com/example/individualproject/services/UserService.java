package com.example.individualproject.services;

import com.example.individualproject.models.User;
import com.example.individualproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired // automatic dependency injection
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public boolean deleteUserById(int userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()){
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }
    public void createUser(){
        //...
    }
}
