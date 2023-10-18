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
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT * FROM book", nativeQuery = true)
    List<Book> getAllBooks();

}
