package com.example.demo.models;
import com.example.demo.models.enums.Genre;
import jakarta.persistence.*;
import lombok.*;
//import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.lang.NonNull;

import java.util.List;

@Entity
//@Data
@Table(name="\"user\"")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String phone_number; //nullable

    @OneToMany(mappedBy = "user")
    private List<Library> collection;

    //favourites
    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private Genre f_genre;

    //null default
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = true)
    private Book f_book;

    //null default
    @ManyToOne
    @JoinColumn(name = "shadowprofile_id", nullable = true)
    private ShadowProfile f_author;

    @OneToMany(mappedBy = "user")//ok
    private List<Review>reviews;

    @OneToMany(mappedBy = "user")//ok
    private List<Transaction> transactions;

    //friends //TODO


    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public List<Library> getCollection() {
        return collection;
    }

    public Genre getF_genre() {
        return f_genre;
    }

    public Book getF_book() {
        return f_book;
    }

    public ShadowProfile getF_author() {
        return f_author;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public List<Transaction> getTransactions() {
        return transactions;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setCollection(List<Library> collection) {
        this.collection = collection;
    }

    public void setF_genre(Genre f_genre) {
        this.f_genre = f_genre;
    }

    public void setF_book(Book f_book) {
        this.f_book = f_book;
    }

    public void setF_author(ShadowProfile f_author) {
        this.f_author = f_author;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
