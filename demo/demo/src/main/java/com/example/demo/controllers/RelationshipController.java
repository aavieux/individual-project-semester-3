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
import java.util.Objects;

@RestController
@RequestMapping("/api/relationships")
@AllArgsConstructor
public class RelationshipController {

    private final UserService userService;
    private final JwtService_TokenService jwtServiceTokenService;

    @GetMapping("/allfriends")
    public ResponseEntity<Object> getAllFriendsForUser(@RequestParam("userId") Long userId, @RequestHeader("Authorization") String authorizationHeader, Authentication authentication){

        if (authentication != null && authentication.isAuthenticated()) { // if user is authenticated
            List<UserDTO> friendsList = new java.util.ArrayList<>(List.of());
            for (User user : userService.getAllUsers()
                 ) {
                if (user.getId().equals(userId)){
                    for (User friend :userService.getAllFriendsByUser(user)
                         ) {
                        UserDTO friendDTO = UserDTO.builder()
                                .id(friend.getId())
                                .first_name(friend.getFirst_name())
                                .last_name(friend.getLast_name())
                                .f_genre(friend.getF_genre())
                                .f_author_id(friend.getF_author().getId())
                                .f_book_id(friend.getF_book().getId())
                                .profile_pic_url(friend.getProfile_pic_url())
                                .build();
                        friendsList.add(friendDTO);
                    }
                    return ResponseEntity.ok(friendsList);
                }

            }

        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User Not Authenticated");
    }

}
