package com.example.demo.models;

import com.example.demo.models.enums.Status;
import jakarta.persistence.*;

@Entity
public class FriendRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender",nullable = false)
    private User sender;

    @ManyToOne
    @JoinColumn(name = "recipient",nullable = false)
    private User recipient;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
}
