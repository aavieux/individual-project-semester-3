package com.example.demo.repositories;

import com.example.demo.models.Book;
import com.example.demo.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "SELECT * FROM book", nativeQuery = true)
    public List<Book> getAllBooks();
}
