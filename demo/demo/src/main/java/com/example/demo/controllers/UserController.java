package com.example.demo.controllers;
import com.example.demo.models.User;
import com.example.demo.services.BookService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final BookService bookService;


    public User getAuthenticatedUser(Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userService.getUserByEmail(userDetails.getUsername());
    }
    private void getUserAndFriendsToModel(Model model, Authentication authentication) {
//        model.addAttribute("allUsers", userService.getAllUsers());
        model.addAttribute("authenticatedUser", getAuthenticatedUser(authentication));
        model.addAttribute("allFriends", userService.getAllFriends(getAuthenticatedUser(authentication)));
    }

    @Autowired
    public UserController(UserService userService, BookService bookService){
        this.userService = userService;
        this.bookService = bookService;
    }

    //@PreAuthorize("permitAll()")
    @GetMapping("/myprofile")
    public String userProfile(Model model, Authentication authentication){

        getUserAndFriendsToModel(model, authentication);

        return "myProfile";
    }
    @GetMapping("/myprofile/mylibrary")
    public String userLibraries(Model model, Authentication authentication){
        getUserAndFriendsToModel(model,authentication);
        model.addAttribute("allTransactionsForUser", bookService.getAllTransactionsByUser(getAuthenticatedUser(authentication)));
        return "myLibraries";
    }

//    @GetMapping("/allusers") // MyProfile/allUsers
//    public String getAllUsers(){
//        return "index";
//    }
    @PostMapping
    public void addUser(){
        //....
    }
    @GetMapping("/{id}")
    public String  getUserPage(@PathVariable(value = "id") Integer userId, Model model, Authentication authentication){
        getUserAndFriendsToModel(model,authentication);
        User userPageUser = userService.getUserById(userId);
        model.addAttribute("userPageUser", userPageUser);
        return "profileOverview";
    }

}
