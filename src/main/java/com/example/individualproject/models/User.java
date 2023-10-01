package com.example.individualproject.models;
import com.example.individualproject.models.enums.Genre;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class User {
    public User() {} // required for JPA
    public User(int id,String first_name, String last_name, String email, String password, String phone_number, int default_lib_id) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.default_lib_id = default_lib_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String phone_number; //nullable
    private int default_lib_id;
    private Genre f_genre;
    private Genre f_book;
    private int f_author;

    public int getId() {
        return id;
    }

    public void setId(int id) {this.id = id;}
    public String getFirst_name() {return first_name;}

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getDefault_lib_id() {
        return default_lib_id;
    }

    public void setDefault_lib_id(int default_lib_id) {
        this.default_lib_id = default_lib_id;
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
