package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="book_id",nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
//    @JsonBackReference
    private User user;

    @Column(nullable = false)
    private float rating;

    @Column(nullable = true)
    private String description;

}
