package com.example.individualproject.models;

public class User {
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String phone_number; //nullable
    private int default_lib_id;

    public String getFirst_name() {
        return first_name;
    }

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
}
