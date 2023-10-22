package com.example.demo.controllers;
import com.example.demo.models.Library;
import com.example.demo.models.User;
import com.example.demo.repositories.BookRepository;
import com.example.demo.services.BookService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final BookService bookService;


//    public Optional<User> getAuthenticatedUser(Authentication authentication){
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        return userService.getUserByEmail(userDetails.getUsername());
//    }
//
//    private void getUserAndFriendsToModel(Model model, Authentication authentication) {
////        model.addAttribute("allUsers", userService.getAllUsers());
//        model.addAttribute("authenticatedUser", getAuthenticatedUser(authentication));
//        model.addAttribute("allFriends", userService.getAllFriendsByUser(getAuthenticatedUser(authentication)));
//    }

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
        model.addAttribute("allLibrariesForAuthenticatedUser", bookService.getAllLibrariesByUser(getAuthenticatedUser(authentication)));
        return "myLibraries";
    }
    @GetMapping("/myprofile/mylibrary/{library_id}")
    public String userLibrariesId(@PathVariable(value = "library_id") Long library_id, Model model, Authentication authentication){
        Library authenticatedLibrary = bookService.getLibraryById(library_id,getAuthenticatedUser(authentication));
        if (authenticatedLibrary == null){

            return "redirect:/";
        }
        model.addAttribute("authenticatedLibrary", authenticatedLibrary);
        return "booksFromLibrary";
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
    public String  getUserPage(@PathVariable(value = "id") Long userId, Model model, Authentication authentication){
        if (getAuthenticatedUser(authentication).getId().equals(userId)){
            return "redirect:/users/myprofile";
        }
        getUserAndFriendsToModel(model,authentication);
        User userPageUser = userService.getUserById(userId);
        model.addAttribute("userPageUser", userPageUser);
        model.addAttribute("relationType", userService.checkFriendship(getAuthenticatedUser(authentication),userPageUser));
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------------------");
        return "profileOverview";
    }

}
