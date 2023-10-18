package com.example.demo.repositories;
import com.example.demo.models.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FriendshipRepository extends JpaRepository<Friendship, Long> {
    @Query(value = "SELECT * FROM friendship", nativeQuery = true)
    List<Friendship> getAllFriendships();
    @Query(value ="SELECT user_id1 FROM friendship WHERE user_id2 LIKE :user_id_p", nativeQuery = true)
    List<Long> friendshipRow1(@Param ("user_id_p") Long user_id);
    @Query(value ="SELECT user_id2 FROM friendship WHERE user_id1 LIKE :user_id_p", nativeQuery = true)
    List<Long> friendshipRow2(@Param ("user_id_p") Long user_id);
    @Query(value = "INSERT INTO friendship (user_id1, user_id2 ) VALUES (:user_id1_p, :user_id2_p)", nativeQuery = true)
    boolean addFriendship(@Param("user_id1_p") Long user_id1, @Param("user_id2_p") Long user_id2);


}
