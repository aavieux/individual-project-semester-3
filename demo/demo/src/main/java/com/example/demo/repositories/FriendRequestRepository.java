package com.example.demo.repositories;

import com.example.demo.models.FriendRequest;
import com.example.demo.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FriendRequestRepository extends JpaRepository<FriendRequest, Long> {

    @Query(value = "SELECT * FROM friend_request", nativeQuery = true)
    List<FriendRequest> getAllFriendRequests();

    @Query(value ="SELECT recipient FROM friend_request WHERE sender LIKE :sender_id_p", nativeQuery = true)
    List<FriendRequest> getOutcomingFriendRequestsByUsers(@Param("sender_id_p") Long sender_id);

    @Query(value ="SELECT sender FROM friend_request WHERE recipient LIKE :recipient_id_p", nativeQuery = true)
    List<FriendRequest> getIncomingFriendRequestsByUser(@Param ("recipient_id_p") Long recipient_id);

    @Query(value = "INSERT INTO friend_request (sender, recipient ) VALUES (:sender_id_p, :recipient_id_p)", nativeQuery = true)
    boolean addFriendRequest(@Param("sender_id_p") Long sender_id, @Param("recipient_id_p") Long recipient_id);
}
