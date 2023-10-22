package com.example.demo.repositories;
import com.example.demo.models.Book;
import com.example.demo.models.Library;
import com.example.demo.models.Transaction;
import com.example.demo.models.User;
import com.example.demo.models.enums.Genre;
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

    @Modifying //it will change the database
    @Transactional //  If an exception occurs, the transaction is rolled back, reverting any changes made within the method, ensuring that the database remains in a consistent state.
    @Query(value = "INSERT INTO book (cover_url, genre, isbn, title, shadowprofile_id) VALUES (:cover_url_p, :genre_p, :isbn_p, :title_p, :shadowprofile_id_p)", nativeQuery = true)
    boolean addBook(@Param("cover_url_p") String cover_url, @Param("genre_p")Genre genre, @Param("isbn_p") String isbn, @Param("title_p") String title, @Param("shadowprofile_id_p") Long shadowprofile_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM book b WHERE b.id LIKE :book_id_p", nativeQuery = true)
    boolean deleteBookById(@Param("book_id_p") Long book_id);
}
