package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.models.dtos.UserDTO;
import com.example.demo.services.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/relationships")
@AllArgsConstructor
public class RelationshipController {

    private final UserService userService;

    @GetMapping("/allfriends")
    public ResponseEntity<Object> getAllFriendsForUser(Long userId, Authentication authentication){

        if (authentication != null && authentication.isAuthenticated()) { // if user is authenticated

            for (User user : userService.getAllUsers()
                 ) {
                if (user.getId().equals(userId)){
                    List<UserDTO> friendsList = List.of();
                    for (Optional<User> friend :userService.getAllFriendsByUser(user)
                         ) {
                        UserDTO friendDTO = UserDTO.builder()
                                .first_name(((User) friend).getFirst_name())
                                .build();
                    }
                    return ResponseEntity.ok();
                }

            }

        }
    }

}
