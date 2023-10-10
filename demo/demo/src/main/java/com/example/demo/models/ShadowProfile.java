package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class ShadowProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(nullable = true)
    private String first_name;

    @Column(nullable = true)
    private String last_name;

    @Column(nullable = true)
    private String pseudonym;

    @Column(nullable = true)
    private String profile_pic_url;

    @OneToMany(mappedBy = "author")//ok
    private List<Book> collection;

    @OneToMany(mappedBy = "f_author")//ok
    private List<User> followers;


    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public String getProfile_pic_url() {
        return profile_pic_url;
    }

    public List<Book> getCollection() {
        return collection;
    }

    public List<User> getFollowers() {
        return followers;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public void setProfile_pic_url(String profile_pic_url) {
        this.profile_pic_url = profile_pic_url;
    }

    public void setCollection(List<Book> collection) {
        this.collection = collection;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }
}