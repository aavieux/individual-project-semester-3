package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FriendList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

//    @ManyToOne
//    @JoinColumn(name="user_id",nullable = false)
//    private User user1;
//    @ManyToOne
//    @JoinColumn(name="user_id",nullable = false)
//    private User user2;

//TODO
}
