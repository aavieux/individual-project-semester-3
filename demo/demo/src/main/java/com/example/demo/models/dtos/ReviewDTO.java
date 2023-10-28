package com.example.demo.models.dtos;

import com.example.demo.models.Book;
import com.example.demo.models.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ReviewDTO {

    private Long id;

    private Long book_id;

    private Long user_id;

    private float rating;

    private String description;
}
