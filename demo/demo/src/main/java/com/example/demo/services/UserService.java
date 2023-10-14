package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.repositories.RelationshipRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RelationshipRepository relationshipRepository;
    @Autowired
    public UserService(UserRepository userRepository, RelationshipRepository relationshipRepository) {
        this.userRepository = userRepository;
        this.relationshipRepository = relationshipRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    public boolean addUser(User user){
        return userRepository.addUser(user.getRole().toString(),user.getFirst_name(), user.getLast_name(), user.getEmail(), user.getPassword(), user.getPhone_number(), user.getF_genre().toString(), user.getF_author().getId(), user.getF_book().getId());
    }
    public boolean deleteUser(User user){
        return userRepository.deleteUser(user.getId());
    }

    public User getUserByEmail(String user_email){
        return userRepository.getUserByEmail(user_email);
    }

    public List<User> getAllFriends(User user){

        List<Integer> friendListIds = new java.util.ArrayList<>(List.of());
        List<User> friends = new java.util.ArrayList<>(List.of());

        friendListIds.addAll(relationshipRepository.friendshipRow1(user.getId()));
        friendListIds.addAll(relationshipRepository.friendshipRow2(user.getId()));

        for (Integer userId : friendListIds){
            friends.add(userRepository.getUserById(userId));
        }
        return friends;
    }
}
