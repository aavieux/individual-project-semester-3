package com.example.demo.models.dtos;

import com.example.demo.models.Book;
import com.example.demo.models.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class LibraryDTO {

    private Long id;

    private Long user_id;

    private String title;

    private List<Long> book_ids;
}
