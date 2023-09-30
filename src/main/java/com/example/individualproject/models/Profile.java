package com.example.individualproject.models;

import com.example.individualproject.models.enums.Genre;

public class Profile {
    public Profile(int id, int user_id, Genre f_genre, Genre f_book, int f_author) {
        this.id = id;
        this.user_id = user_id;
        this.f_genre = f_genre;
        this.f_book = f_book;
        this.f_author = f_author;
    }

    private int id;
    private int user_id;
    private Genre f_genre;
    private Genre f_book;
    private int f_author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Genre getF_genre() {
        return f_genre;
    }

    public void setF_genre(Genre f_genre) {
        this.f_genre = f_genre;
    }

    public Genre getF_book() {
        return f_book;
    }

    public void setF_book(Genre f_book) {
        this.f_book = f_book;
    }

    public int getF_author() {
        return f_author;
    }

    public void setF_author(int f_author) {
        this.f_author = f_author;
    }
}
