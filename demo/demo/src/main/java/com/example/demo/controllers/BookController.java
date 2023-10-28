package com.example.demo.controllers;
import com.example.demo.models.Book;
import com.example.demo.models.dtos.BookDTO;
import com.example.demo.security.jwt.JwtService_TokenService;
import com.example.demo.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;
    private final JwtService_TokenService jwtServiceTokenService;

    @GetMapping()
    public ResponseEntity<List<BookDTO>> allBooks(@RequestHeader("Authorization") String authorizationHeader, Authentication authentication){
        List<BookDTO> listBookDTO = new java.util.ArrayList<>(List.of());
//        System.out.println("ZLIZA -----------------------------------------------------------------------------------");
        if (authentication != null && authentication.isAuthenticated()) {
            for (Book book :bookService.getAllBooks()
                 ) {
                BookDTO bookDTO = BookDTO.builder()
                        .id(book.getId())
                        .title(book.getTitle())
                        .genre(book.getGenre())
                        .genre(book.getGenre())
                        .author_id(book.getAuthor().getId())
                        .cover_url(book.getCover_url())
                        .build();

               listBookDTO.add(bookDTO);
            }
            return ResponseEntity.ok(listBookDTO);
        }
        else{
            return null;
        }
    }
//    @GetMapping("/search")
//    public List<Book> searchBooks(@RequestParam("query") String query) {
//        return bookService.getAllBooksBySearch(query);
//    }
}