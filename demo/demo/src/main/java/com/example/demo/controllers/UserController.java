package com.example.demo.controllers;
import com.example.demo.models.User;
import com.example.demo.models.dtos.UserDTO;
import com.example.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
//@CrossOrigin(origins = "http://localhost:8080")
public class UserController {

    private final UserService userService;

    //@PreAuthorize("permitAll()")
    @GetMapping()
    public ResponseEntity<Object>  getUserPage(@RequestParam(value = "id") Long userId, Authentication authentication){
        User user = userService.getUserById(userId);
        if (user!= null){
            UserDTO userDTO = UserDTO.builder()
                    .first_name(user.getFirst_name())
                    .last_name(user.getLast_name())
                    .profile_pic_url(user.getProfile_pic_url())
                    .f_book_id(user.getF_book().getId())
                    .f_author_id(user.getF_author().getId())
                    .f_author_pseudonym(user.getF_author().getPseudonym())
                    .f_genre(user.getF_genre())
                    .email(user.getEmail())
                    .total_friends(userService.getAllFriendsByUser(user).size())
                    .build();
            return ResponseEntity.ok(userDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
    }
    @GetMapping("/profile")
    public ResponseEntity<Object> getUserDetails(Authentication authentication) {
        User user = userService.getUserByEmail(((UserDetails) authentication.getPrincipal()).getUsername());
        try
        {
            if (user != null){
                UserDTO userDTO = UserDTO.builder().id(user.getId())
                        .email(user.getEmail())
                        .f_genre(user.getF_genre())
                        .first_name(user.getFirst_name())
                        .last_name(user.getLast_name())
                        .phone_number(user.getPhone_number())
                        .profile_pic_url(user.getProfile_pic_url())
                        .f_author_id(user.getF_author().getId())
                        .f_author_pseudonym(user.getF_author().getPseudonym())
                        .f_book_id(user.getF_book().getId())
                        .total_friends(userService.getAllFriendsByUser(user).size())
                        .build();
                return ResponseEntity.ok(userDTO);

            }
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No User found");
        }
        catch (Exception e)
        {
            // Handle JSON serialization error
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error serializing User to JSON");
        }

    }



////    @GetMapping("/allusers") // MyProfile/allUsers
////    public String getAllUsers(){
////        return "index";
////    }
//    @PostMapping
//    public void addUser(){
//        //....
//    }


}
