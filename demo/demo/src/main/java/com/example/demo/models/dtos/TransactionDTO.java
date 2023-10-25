package com.example.demo.models.dtos;

import com.example.demo.models.Book;
import com.example.demo.models.User;
import com.example.demo.models.enums.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Builder;

import java.util.Date;

@Builder
public class TransactionDTO {

    private Long id;

    private Long user_id;

    private Long book_id; // this

    private Status status; // this

    private Date date;

    private float value;
}
