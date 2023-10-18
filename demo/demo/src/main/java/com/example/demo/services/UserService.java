package com.example.demo.services;

import com.example.demo.models.FriendRequest;
import com.example.demo.models.User;
import com.example.demo.models.enums.FriendRequestStatusNoDb;
import com.example.demo.repositories.FriendRequestRepository;
import com.example.demo.repositories.FriendshipRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final FriendshipRepository friendShipRepository;
    private final FriendRequestRepository friendRequestRepository;
    @Autowired
    public UserService(UserRepository userRepository, FriendshipRepository friendShipRepository, FriendRequestRepository friendRequestRepository) {
        this.userRepository = userRepository;
        this.friendShipRepository = friendShipRepository;
        this.friendRequestRepository = friendRequestRepository;
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

    public User getUserById(Long userId){
        return userRepository.getUserById(userId);
    }


//    --------------------------FRIENDSHIPS------------------------

//    @Cacheable("allFriendShips")
//    public List<Friendship> getAllFriendships(){
//        return relationshipRepository.getAllFriendships();
//    }
    @Cacheable(value = "userFriends", key = "#user.id")
    public List<User> getAllFriendsByUser(User user){

        List<Long> friendListIds = new java.util.ArrayList<>(List.of());
        List<User> friends = new java.util.ArrayList<>(List.of());

        friendListIds.addAll(friendShipRepository.friendshipRow1(user.getId()));
        friendListIds.addAll(friendShipRepository.friendshipRow2(user.getId()));

        for (Long userId : friendListIds){
            friends.add(userRepository.getUserById(userId));
        }
        return friends;
    }
    @CacheEvict(value = {"userFriends"}, allEntries = true)
    public boolean addFriendship(User user1, User user2){
        return friendShipRepository.addFriendship(user1.getId(), user2.getId());
    }

    public FriendRequestStatusNoDb checkFriendship(User authenticatedUser, User withUser){
        if (getAllFriendsByUser(authenticatedUser).contains(withUser)) {
            return FriendRequestStatusNoDb.FRIENDS;
        }
        for (FriendRequest friendRequest: getIncomingFriendRequestsByUser(authenticatedUser) ) {
            if (friendRequest.getSender() == withUser){
                return FriendRequestStatusNoDb.INCOMING;
            }
        }
        for (FriendRequest friendRequest: getOutcomingFriendRequestsByUser(authenticatedUser) ) {
            if (friendRequest.getRecipient() == withUser){
                return FriendRequestStatusNoDb.OUTCOMING;
            }
        }
        return FriendRequestStatusNoDb.NOT_FRIENDS;
    }
    //    --------------------------FRIEND REQUESTS------------------------

    @Cacheable(value = "userIncomingFriendRequests", key = "#user.id")
    public List<FriendRequest> getIncomingFriendRequestsByUser(User user){
        return friendRequestRepository.getIncomingFriendRequestsByUser(user.getId());
    }
    @Cacheable(value = "userOutcomingFriendRequests", key = "#user.id")
    public List<FriendRequest> getOutcomingFriendRequestsByUser(User user){
        return friendRequestRepository.getOutcomingFriendRequestsByUsers(user.getId());
    }



}
