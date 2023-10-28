package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.models.dtos.UserDTO;
import com.example.demo.security.jwt.JwtService_TokenService;
import com.example.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/relationships")
@AllArgsConstructor
public class RelationshipController {

    private final UserService userService;
    private final JwtService_TokenService jwtServiceTokenService;

    @GetMapping("/allfriends")
    public ResponseEntity<Object> getAllFriendsForUser(@RequestParam("userId") Long userId, @RequestHeader("Authorization") String authorizationHeader, Authentication authentication){

        if (authentication != null && authentication.isAuthenticated()) { // if user is authenticated
            List<User> friendsOfUser = userService.getAllFriendsByUser(userService.getUserByEmail(jwtServiceTokenService.extractUsername(jwtServiceTokenService.extractToken(authorizationHeader))));
            if (!friendsOfUser.isEmpty())
            {
                List<UserDTO> friendsListDTO = new java.util.ArrayList<>(List.of());
                try {
                    for (User friend : friendsOfUser
                    ) {
                        UserDTO friendDTO = UserDTO.builder().id(friend.getId())
                                .email(friend.getEmail())
                                .f_genre(friend.getF_genre())
                                .first_name(friend.getFirst_name())
                                .last_name(friend.getLast_name())
                                .phone_number(friend.getPhone_number())
                                .profile_pic_url(friend.getProfile_pic_url())
                                .role(friend.getRole())
                                .f_author_id(friend.getF_author().getId())
                                .f_book_id(friend.getF_book().getId())
                                .build();
                        friendsListDTO.add(friendDTO);
                    }
                    return ResponseEntity.ok(friendsListDTO);
                }
                catch (Exception e){
                    return ResponseEntity.status(HttpStatus.CONFLICT).body("Error serializing User to JSON");
                }


            }
            return ResponseEntity.ok("User has no friends");


        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User Not Authenticated");
    }

}
