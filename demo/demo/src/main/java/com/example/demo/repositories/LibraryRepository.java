package com.example.demo.repositories;

import com.example.demo.models.Library;
import com.example.demo.models.Transaction;
import com.example.demo.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LibraryRepository extends JpaRepository<Library, Long> {
    @Query(value = "SELECT * FROM library", nativeQuery = true)
    public List<Library> getAllLibraries();
    @Query(value = "SELECT * FROM library l WHERE l.user_id LIKE :user_id_p", nativeQuery = true)
    public List<Library> getAllLibrariesByUser(@Param("user_id_p") Long user_id);
    @Query(value = "SELECT * FROM library l WHERE l.id LIKE :library_id_p AND l.user_id LIKE :authenticatedUser_id_p", nativeQuery = true)
    public Optional<Library> getLibraryById(@Param("library_id_p") Long library_id, @Param("authenticatedUser_id_p") Long authenticatedUser_id);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO library (title, user_id) VALUES (:title_p, :user_id_p)", nativeQuery = true)
    public boolean addLibrary(@Param("title_p") String title, @Param("user_id_p") Long user_id);


}
