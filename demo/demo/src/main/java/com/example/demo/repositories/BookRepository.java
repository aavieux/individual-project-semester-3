package com.example.demo.repositories;
import com.example.demo.models.Book;
import com.example.demo.models.Library;
import com.example.demo.models.Transaction;
import com.example.demo.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

//@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "SELECT * FROM book", nativeQuery = true)
    List<Book> getAllBooks();



//    ---------------------------------TRANSACTIONS---------------------------------------
    @Query(value ="SELECT * FROM [transaction]", nativeQuery = true)
    List<Transaction> getAllTransactions();

    @Query(value ="SELECT * FROM [transaction] t WHERE t.user_id LIKE ':user_id_p'", nativeQuery = true)
    List<Transaction> getAllTransactionsByUser(@Param("user_id_p")Integer user_id);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO [transaction] (user_id, book_id, value, status, date VALUES (:user_id_p, :book_id_p, :value_p, :status_p, :date_p)", nativeQuery = true)
    boolean addTransaction(@Param("user_id_p") Integer user_id, @Param("book_id_p") Integer book_id, @Param("value_p") Float value, @Param("status_p") String status, @Param("date_p") Date date);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM [transaction] t WHERE t.id = :transaction_id_p", nativeQuery = true)
    boolean deleteTransaction(@Param("transaction_id_p") Integer transaction_id);
//        ---------------------------------TRANSACTIONS---------------------------------------
//        ---------------------------------Library---------------------------------------
    @Query(value = "SELECT * FROM library", nativeQuery = true)
    List<Library> getAllLibraries();
    @Query(value = "SELECT * FROM library l WHERE l.user_id = :user_id_p", nativeQuery = true)
    List<Library> getAllLibrariesByUser(@Param("user_id_p") Integer user_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO library (user_id, book_id, value, status, date VALUES (:user_id_p, :book_id_p, :value_p, :status_p, :date_p)", nativeQuery = true)
    boolean addLibrary(@Param("user_id_p") Integer user_id, @Param("book_id_p") Integer book_id, @Param("value_p") Float value, @Param("status_p") String status, @Param("date_p") Date date);

    //        ---------------------------------Library---------------------------------------


    //rerview
}
