package com.example.demo.models.dtos;

import com.example.demo.models.Book;
import com.example.demo.models.User;
import jakarta.persistence.*;
import lombok.Builder;

import java.util.List;

@Builder
public class LibraryDTO {

    private Long id;

    private User user;

    private String title;
}
