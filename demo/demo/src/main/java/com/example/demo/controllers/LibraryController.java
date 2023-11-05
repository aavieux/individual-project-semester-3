package com.example.demo.controllers;
import com.example.demo.models.Book;
import com.example.demo.models.Library;
import com.example.demo.models.User;
import com.example.demo.models.dtos.BookDTO;
import com.example.demo.models.dtos.LibraryDTO;
import com.example.demo.security.jwt.JwtService_TokenService;
import com.example.demo.services.BookService;
import com.example.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/libraries")
public class LibraryController {

    private final BookService bookService;
    private final UserService userService;
    @GetMapping("/mylibrary")
    public ResponseEntity<Object> userLibraries(Authentication authentication){
        User authenticatedUser = userService.getUserByEmail(((UserDetails) authentication.getPrincipal()).getUsername());
        List<Library> libraries = bookService.getAllLibrariesByUser(authenticatedUser);
            if (libraries != null) {
                List<LibraryDTO> libraryDTOList = new java.util.ArrayList<>(List.of());
                try {
                    for (Library library : libraries
                    ) {
                        List<Long> book_ids = new java.util.ArrayList<>(List.of());
                        for (Book book :
                                library.getBooks()) {
                            book_ids.add(book.getId());
                        }
                        LibraryDTO libraryDTO = LibraryDTO.builder()
                                .id(library.getId())
                                .user_id(library.getUser().getId())
                                .title(library.getTitle())
                                .book_ids(book_ids)
                                .build();
                        libraryDTOList.add(libraryDTO);
                    }
                    return ResponseEntity.ok(libraryDTOList); //200
                }
                catch (Exception e ){
                    return ResponseEntity.status(HttpStatus.CONFLICT).body("Error serializing User to JSON"); //409
                }
            }
            else {
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("User has no libraries"); // 404
            }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("There was a problem with the authorisation"); // 401

    }
    @GetMapping("/mylibrary/{id}")
    public ResponseEntity<Object> getBooksByLibraryId(@PathVariable("id") Long id, Authentication authentication){
        User authenticatedUser = userService.getUserByEmail(((UserDetails) authentication.getPrincipal()).getUsername());
            try {
                Library library = bookService.getLibraryByIdByAuthenticatedUser(id, authenticatedUser); //TODO check if it is null
                if (library != null) {
                    if (!library.getBooks().isEmpty()){
                        List<BookDTO> bookDTOList = new java.util.ArrayList<>(List.of());
                        try {
                            for (Book book : library.getBooks()
                            ) {
                                BookDTO bookDTO = BookDTO.builder()
                                        .id(book.getId())
                                        .genre(book.getGenre())
                                        .cover_url(book.getCover_url())
                                        .author_id(book.getAuthor().getId())
                                        .author_pseudonym(book.getAuthor().getPseudonym())
                                        .title(book.getTitle())
                                        .library_title(library.getTitle())
                                        .isbn(book.getIsbn())
                                        .build();
                                bookDTOList.add(bookDTO);
                            }
                            return ResponseEntity.ok(bookDTOList); // 200
                        }

                        catch (Exception e ){
                            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error serializing Books to JSON"); //409
                        }
                    }
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No books in this library"); //  404

                }
                else {
                    System.out.println("in the else");
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Library does not exist"); // 404
                }
            }
            catch (Exception e ){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error Extracting User From Token"); // 401
            }

    }

}
