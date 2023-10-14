package com.example.demo.models;

import jakarta.persistence.*;

@Entity
public class Friendship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id1",nullable = false)
    private User user1;

    @ManyToOne
    @JoinColumn(name = "user_id2",nullable = false)
    private User user2;

}
