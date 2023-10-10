package com.example.demo.repositories;

import com.example.demo.models.Transaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

//@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query(value ="SELECT * FROM transaction", nativeQuery = true)
    List<Transaction> getAllTransactions();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO transaction (user_id, book_id, value, status, date VALUES (:user_id_p, :book_id_p, :value_p, :status_p, :date_p)", nativeQuery = true)
    boolean addTransaction(@Param("user_id_p") Integer user_id, @Param("book_id_p") Integer book_id, @Param("value_p") Float value, @Param("status_p") String status, @Param("date_p") Date date);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM transaction t WHERE t.id = :transaction_id_p", nativeQuery = true)
    boolean deleteTransaction(@Param("transaction_id_p") Integer transaction_id);
}
