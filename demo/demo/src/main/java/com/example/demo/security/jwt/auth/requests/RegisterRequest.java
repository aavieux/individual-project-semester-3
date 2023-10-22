package com.example.demo.security.jwt.auth.requests;

import com.example.demo.models.Book;
import com.example.demo.models.Library;
import com.example.demo.models.ShadowProfile;
import com.example.demo.models.enums.Genre;
import com.example.demo.models.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private Role role;

    private String first_name;


    private String last_name;


    private String email;


    private String password;


    private String phone_number; //nullable


    private String profile_pic_url; //nullable


}
