package com.example.demo.controllers;
import com.example.demo.models.User;
import com.example.demo.models.dtos.UserDTO;
import com.example.demo.security.jwt.JwtService_TokenService;
import com.example.demo.services.BookService;
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
    private final JwtService_TokenService jwtServiceTokenService;

    //@PreAuthorize("permitAll()")
    @GetMapping()
    public ResponseEntity<Object>  getUserPage(@RequestParam(value = "id") Long userId, @RequestHeader("Authorization") String authorizationHeader, Authentication authentication){
        if (authentication != null && authentication.isAuthenticated()) {
            User user = userService.getUserById(userId);
            if (user!= null){
                UserDTO userDTO = UserDTO.builder()
                        .first_name(user.getFirst_name())
                        .last_name(user.getLast_name())
                        .profile_pic_url(user.getProfile_pic_url())
                        .f_book_id(user.getF_book().getId())
                        .f_author_id(user.getF_author().getId())
                        .f_genre(user.getF_genre())
                        .build();
                return ResponseEntity.ok(userDTO);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not authenticated");
        }
    }
    @GetMapping("/profile")
    public ResponseEntity<Object> getUserDetails(@RequestHeader("Authorization") String authorizationHeader, Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) { // if user is authenticated
            try
            {
                User user = userService.getUserByEmail(jwtServiceTokenService.extractUsername(jwtServiceTokenService.extractToken(authorizationHeader)));

                if (user != null){
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
                return ResponseEntity.status(HttpStatus.CONFLICT).body("No User found");
            }
            catch (Exception e)
            {
                // Handle JSON serialization error
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Error serializing User to JSON");
            }
        }
        else {
            // Handle unauthenticated request
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not authenticated");
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
