package com.example.demo.controllers;
import com.example.demo.models.User;
import com.example.demo.models.dtos.UserDTO;
import com.example.demo.services.BookService;
import com.example.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
//@CrossOrigin(origins = "http://localhost:8080")
public class UserController {

    private final UserService userService;
    private final BookService bookService;

    //@PreAuthorize("permitAll()")
    @GetMapping("/profile")
    public ResponseEntity<Object> getUserDetails(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) { // if user is authenticated
            try
            { // try to serialize it
                User user = userService.getUserByEmail(((UserDetails) authentication.getPrincipal()).getUsername());

                if (user == null){

                    return ResponseEntity.status(HttpStatus.CONFLICT).body("Error serializing User to JSON");
                }
                UserDTO userDTO = UserDTO.builder().id(user.getId())
                        .email(user.getEmail())
                        .f_genre(user.getF_genre())
                        .first_name(user.getFirst_name())
                        .last_name(user.getLast_name())
                        .phone_number(user.getPhone_number())
                        .profile_pic_url(user.getProfile_pic_url())
                        .role(user.getRole())
                        .f_author_id(user.getF_author().getId())
                        .f_book_id(user.getF_book().getId())
                        .build();
                return ResponseEntity.ok(userDTO);
            }
            catch (Exception e)
            {
                // Handle JSON serialization error
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Error serializing User to JSON");
            }
//            return ResponseEntity.ok("Could not serialise");
        }
        else {
            // Handle unauthenticated request
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not authenticated");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object>  getUserPage(@PathVariable(value = "id") Long userId, Authentication authentication){
        if (authentication != null && authentication.isAuthenticated()) {
            for (User user:userService.getAllUsers()
                 ) {
                if (user.getId().equals(userId)){
                    UserDTO userDTO = UserDTO.builder()
                            .first_name(user.getFirst_name())
                            .last_name(user.getLast_name())
                            .profile_pic_url(user.getProfile_pic_url())
                            .f_book_id(user.getF_book().getId())
                            .f_author_id(user.getF_author().getId())
                            .f_genre(user.getF_genre())
                            .build();
                    return ResponseEntity.ok(userDTO.toString());
                }

            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");

        }
        else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not authenticated");
        }
    }

    @GetMapping("/profile/mylibrary")
    public ResponseEntity<Object> userLibraries(Authentication authentication){
        if (authentication != null && authentication.isAuthenticated()) {

//            getUserAndFriendsToModel(model,authentication);
//            model.addAttribute("allLibrariesForAuthenticatedUser", bookService.getAllLibrariesByUser(getAuthenticatedUser(authentication)));
            return "myLibraries";
        }
        else {

        }

    }
    @GetMapping("/profile/mylibrary/{library_id}")
    public String userLibrariesId(@PathVariable(value = "library_id") Long library_id, Model model, Authentication authentication){
        Library authenticatedLibrary = bookService.getLibraryById(library_id,getAuthenticatedUser(authentication));
        if (authenticatedLibrary == null){

            return "redirect:/";
        }
        model.addAttribute("authenticatedLibrary", authenticatedLibrary);
        return "booksFromLibrary";
    }
//
////    @GetMapping("/allusers") // MyProfile/allUsers
////    public String getAllUsers(){
////        return "index";
////    }
//    @PostMapping
//    public void addUser(){
//        //....
//    }


}
