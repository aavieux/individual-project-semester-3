package com.example.demo.models;

import com.example.demo.models.enums.Genre;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String isbn;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToOne
    @JoinColumn(name="shadowprofile_id",nullable = false)
    private ShadowProfile author;

    @Column(nullable = true)
    private String cover_url;

    @OneToMany(mappedBy = "book")
    private List<Review> reviews; // ok

    @OneToMany(mappedBy = "f_book") // ok // f_book
    @JsonManagedReference
    private List<User> followers;

    @OneToMany(mappedBy = "book")
    private List<Transaction>transactions;

    @ManyToMany(mappedBy = "books")
    private List<Library> libraries;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public Genre getGenre() {
        return genre;
    }

    public ShadowProfile getAuthor() {
        return author;
    }

    public String getCover_url() {
        return cover_url;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setAuthor(ShadowProfile author) {
        this.author = author;
    }

    public void setCover_url(String cover_url) {
        this.cover_url = cover_url;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void setLibraries(List<Library> libraries) {
        this.libraries = libraries;
    }
}
