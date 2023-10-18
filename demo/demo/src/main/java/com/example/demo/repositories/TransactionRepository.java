package com.example.demo.repositories;

import com.example.demo.models.Transaction;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query(value ="SELECT * FROM [transaction]", nativeQuery = true)
    List<Transaction> getAllTransactions();

    @Query(value ="SELECT * FROM [transaction] t WHERE t.user_id LIKE :user_id_p", nativeQuery = true)
    List<Transaction> getAllTransactionsByUser(@Param("user_id_p")Long user_id);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO [transaction] (user_id, book_id, value, status, date VALUES (:user_id_p, :book_id_p, :value_p, :status_p, :date_p)", nativeQuery = true)
    boolean addTransaction(@Param("user_id_p") Long user_id, @Param("book_id_p") Long book_id, @Param("value_p") Float value, @Param("status_p") String status, @Param("date_p") Date date);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM [transaction] t WHERE t.id LIKE :transaction_id_p", nativeQuery = true)
    boolean deleteTransaction(@Param("transaction_id_p") Long transaction_id);
}
