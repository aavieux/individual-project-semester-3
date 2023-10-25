package com.example.demo.models.dtos;

import com.example.demo.models.*;
import com.example.demo.models.enums.Genre;
import com.example.demo.models.enums.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class UserDTO {

    private Long id;

    private Role role;

    private String first_name;

    private String last_name;

    private String email;

    private String phone_number;

    private String profile_pic_url;

    private Genre f_genre;

    private Long f_book_id;

    private Long f_author_id;


}
