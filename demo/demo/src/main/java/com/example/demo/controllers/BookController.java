package com.example.demo.controllers;

import com.example.demo.models.Book;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//@Controller
//@RequestMapping("/books")
//public class BookController {
//
//    private final BookService bookService;
//    @Autowired
//    public BookController(BookService bookService) {
//        this.bookService = bookService;
//    }
//
//    @GetMapping("/search")
//    public List<Book> searchBooks(@RequestParam("query") String query) {
//        return bookService.getAllBooksBySearch(query);
//    }
//}