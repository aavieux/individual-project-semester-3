package com.example.individualproject.controllers;

import com.example.individualproject.models.User;
import com.example.individualproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping
    public void addUser(){
        //....
    }
    @DeleteMapping("/{userId}")
    public String deleteUserById(@PathVariable int userId){
        if (userService.deleteUserById(userId)){
            return "Book with ID " + userId + " has been deleted successfully.";
        }
        else{
            return "Book with ID " + userId + " not found.";
        }
    }

}
