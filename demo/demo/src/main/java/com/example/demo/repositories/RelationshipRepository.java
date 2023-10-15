package com.example.demo.repositories;

import com.example.demo.models.FriendRequest;
import com.example.demo.models.Friendship;
import com.example.demo.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RelationshipRepository extends JpaRepository<Transaction, Integer> {
    @Query(value = "SELECT * FROM friendship", nativeQuery = true)
    List<Friendship> getAllFriendships();
    @Query(value ="SELECT user_id1 FROM friendship WHERE user_id2 LIKE :user_id_p", nativeQuery = true)
    List<Integer> friendshipRow1(@Param ("user_id_p") Integer user_id);
    @Query(value ="SELECT user_id2 FROM friendship WHERE user_id1 LIKE :user_id_p", nativeQuery = true)
    List<Integer> friendshipRow2(@Param ("user_id_p") Integer user_id);
    @Query(value = "INSERT INTO friendship (user_id1, user_id2 ) VALUES (:user_id1_p, :user_id2_p)", nativeQuery = true)
    boolean addFriendship(@Param("user_id1_p") Integer user_id1, @Param("user_id2_p") Integer user_id2);


    @Query(value = "SELECT * FROM friend_request", nativeQuery = true)
    List<FriendRequest> getAllFriendRequests();

    @Query(value ="SELECT recipient FROM friend_request WHERE sender LIKE :sender_id_p", nativeQuery = true)
    List<FriendRequest> getOutcomingFriendRequestsByUsers(@Param ("sender_id_p") Integer sender_id);

    @Query(value ="SELECT sender FROM friend_request WHERE recipient LIKE :recipient_id_p", nativeQuery = true)
    List<FriendRequest> getIncomingFriendRequestsByUser(@Param ("recipient_id_p") Integer recipient_id);

    @Query(value = "INSERT INTO friend_request (sender, recipient ) VALUES (:sender_id_p, :recipient_id_p)", nativeQuery = true)
    boolean addFriendRequest(@Param("sender_id_p") Integer sender_id, @Param("recipient_id_p") Integer recipient_id);
}
