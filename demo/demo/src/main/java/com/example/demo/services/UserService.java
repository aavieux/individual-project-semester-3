package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    public boolean addUser(User user){
        return userRepository.addUser(user.getFirst_name(), user.getLast_name(), user.getEmail(), user.getPassword(), user.getPhone_number(), user.getF_genre().toString(), user.getF_author().getId(), user.getF_book().getId());
    }
    public boolean deleteUser(User user){
        return userRepository.deleteUser(user.getId());
    }
}
