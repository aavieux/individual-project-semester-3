package com.example.demo.repositories;

import com.example.demo.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RelationshipRepository extends JpaRepository<Transaction, Integer> {
    @Query(value ="SELECT user_id1 FROM friendship WHERE user_id2 LIKE :user_id_p", nativeQuery = true)
    List<Integer> friendshipRow1(@Param ("user_id_p") Integer user_id);
    @Query(value ="SELECT user_id2 FROM friendship WHERE user_id1 LIKE :user_id_p", nativeQuery = true)
    List<Integer> friendshipRow2(@Param ("user_id_p") Integer user_id);
}
