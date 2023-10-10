package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;


@Controller
@RequestMapping("/myprofile")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping()
    public String userProfile(Model model){
        model.addAttribute("allUsers", userService.getAllUsers());
        return "accountOverview";
    }

    @GetMapping("/allusers") // MyProfile/allUsers
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping
    public void addUser(){
        //....
    }
//    @DeleteMapping("/{userId}")
//    public String deleteUserById(@PathVariable int userId){
//        if (userService.deleteUserById(userId)){
//            return "Book with ID " + userId + " has been deleted successfully.";
//        }
//        else{
//            return "Book with ID " + userId + " not found.";
//        }
//    }
}
