package com.example.demo.models.dtos;

import com.example.demo.models.*;
import com.example.demo.models.enums.Genre;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
public class BookDTO{

    private Long id;

    private String title;

    private String isbn;

    private Genre genre;

    private Long author_id;

    private String cover_url;

    private String author_pseudonym;

    private String author_profile_pic_url;

    private String library_title;

}
