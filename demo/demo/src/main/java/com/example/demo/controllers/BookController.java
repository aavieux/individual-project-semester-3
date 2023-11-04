package com.example.demo.controllers;
import com.example.demo.models.Book;
import com.example.demo.models.dtos.BookDTO;
import com.example.demo.security.jwt.JwtService_TokenService;
import com.example.demo.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping()
    public ResponseEntity<List<BookDTO>> allBooks(){
//        System.out.println("ZLIZA -----------------------------------------------------------------------------------");

        List<BookDTO> listBookDTO = new java.util.ArrayList<>(List.of());
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
//    @GetMapping("/search")
//    public List<Book> searchBooks(@RequestParam("query") String query) {
//        return bookService.getAllBooksBySearch(query);
//    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getBookDetails(@PathVariable("id") Long book_id){
           Book book = bookService.getBookById(book_id);
            if (book != null) {
                try {
                    BookDTO bookDTO = BookDTO.builder()
                            .title(book.getTitle())
                            .isbn(book.getIsbn())
                            .id(book.getId())
                            .cover_url(book.getCover_url())
                            .genre(book.getGenre())
                            .author_id(book.getAuthor().getId())
                            .author_pseudonym(book.getAuthor().getPseudonym())
                            .build();
                    return ResponseEntity.ok(bookDTO);
                }
                catch (Exception e ){
                    return ResponseEntity.status(HttpStatus.CONFLICT).body("Error serializing Book to JSON");
                }
            }
            else {
                ResponseEntity.ok("No such book");
            }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not Authenticated");

    }
}