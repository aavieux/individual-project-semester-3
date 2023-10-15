package com.example.demo.services;

import com.example.demo.models.FriendRequest;
import com.example.demo.models.User;
import com.example.demo.repositories.RelationshipRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RelationshipRepository relationshipRepository;
    @Autowired
    public UserService(UserRepository userRepository, RelationshipRepository relationshipRepository) {
        this.userRepository = userRepository;
        this.relationshipRepository = relationshipRepository;
    }

//-----------------------------------------USERS-----------------------------------
    @Cacheable("allUsers")
    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    @CacheEvict(value = "allUsers", allEntries = true)
    public boolean addUser(User user){
        return userRepository.addUser(user.getRole().toString(),user.getFirst_name(), user.getLast_name(), user.getEmail(), user.getPassword(), user.getPhone_number(), user.getF_genre().toString(), user.getF_author().getId(), user.getF_book().getId());
    }
    @CacheEvict(value = "allUsers", allEntries = true)
    public boolean deleteUser(User user){
        return userRepository.deleteUser(user.getId());
    }

    public User getUserByEmail(String user_email){
        return userRepository.getUserByEmail(user_email);
    }

    public User getUserById(Integer userId){
        return userRepository.getUserById(userId);
    }


//    --------------------------FRIENDSHIPS------------------------

//    @Cacheable("allFriendShips")
//    public List<Friendship> getAllFriendships(){
//        return relationshipRepository.getAllFriendships();
//    }
    @Cacheable(value = "userFriends", key = "#user.id")
    public List<User> getAllFriendsByUser(User user){

        List<Integer> friendListIds = new java.util.ArrayList<>(List.of());
        List<User> friends = new java.util.ArrayList<>(List.of());

        friendListIds.addAll(relationshipRepository.friendshipRow1(user.getId()));
        friendListIds.addAll(relationshipRepository.friendshipRow2(user.getId()));

        for (Integer userId : friendListIds){
            friends.add(userRepository.getUserById(userId));
        }
        return friends;
    }
    @CacheEvict(value = "allFriendShips", allEntries = true)
    public boolean addFriendship(User user1, User user2){
        return relationshipRepository.addFriendship(user1.getId(), user2.getId());
    }

    public boolean chceckFriendship(User authenticatedUser,User withUser){
        if (getAllFriendsByUser(authenticatedUser).contains(withUser)) {
            return true;
        }
        else if ()

    }
    //    --------------------------FRIEND REQUESTS------------------------

    @Cacheable(value = "userIncommingFriendRequests", key = "#user.id")
    public List<FriendRequest> getIncommingFriendRequestsByUser(User user){
        return relationshipRepository.getIncommingFriendRequestsByUser(user.getId());
    }
    @Cacheable(value = "userOutcommingFriendRequests", key = "#user.id")
    public List<FriendRequest> getOutcommingFriendRequestsByUser(User user){
        return relationshipRepository.getOutcommingFriendRequestsByUsers(user.getId());
    }



}
