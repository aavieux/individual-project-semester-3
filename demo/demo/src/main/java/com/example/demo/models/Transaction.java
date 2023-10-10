package com.example.demo.models;

import com.example.demo.models.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="\"transaction\"")
@NoArgsConstructor
@AllArgsConstructor

public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne //
    @JoinColumn(name="user_id",nullable = false)
    private User user;

    @ManyToOne //
    @JoinColumn(name="book_id",nullable = false)
    private Book book; // this



    @Column(nullable = false)
    private Status status; // this

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private float value;

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public Status getStatus() {
        return status;
    }

    public Date getDate() {
        return date;
    }

    public float getValue() {
        return value;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setValue(float value) {
        this.value = value;
    }
}//