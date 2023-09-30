package com.example.individualproject.models;

import com.example.individualproject.models.enums.Genre;

public class Book {
    public Book(int id, String isbn, Genre genre, int author_id, String cover_url) {
        this.id = id;
        this.isbn = isbn;
        this.genre = genre;
        this.author_id = author_id;
        this.cover_url = cover_url;
    }

    private int id;
    private String isbn;
    private Genre genre;
    private int author_id;
    private String cover_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getCover_url() {
        return cover_url;
    }

    public void setCover_url(String cover_url) {
        this.cover_url = cover_url;
    }
}
