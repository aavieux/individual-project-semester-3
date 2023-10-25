package com.example.demo.models.dtos;

import com.example.demo.models.*;
import com.example.demo.models.enums.Genre;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;

import java.util.List;

@Builder
public class BookDTO {

    private Long id;

    private String title;

    private String isbn;

    private Genre genre;

    private Long author_id;

    private String cover_url;

}
