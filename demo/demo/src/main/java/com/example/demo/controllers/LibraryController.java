package com.example.demo.controllers;

import com.example.demo.models.Library;
import com.example.demo.models.dtos.LibraryDTO;
import com.example.demo.security.jwt.JwtService_TokenService;
import com.example.demo.services.BookService;
import com.example.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/libraries")
public class LibraryController {

    private final BookService bookService;
    private final UserService userService;
    private final JwtService_TokenService jwtServiceTokenService;
    @GetMapping("/mylibrary")
    public ResponseEntity<Object> userLibraries(@RequestHeader("Authorization") String authorizationHeader, Authentication authentication){
        if (authentication != null && authentication.isAuthenticated()) {

            List<Library> libraries = bookService.getAllLibrariesByUser(userService.getUserByEmail(jwtServiceTokenService.extractToken(authorizationHeader)));
            if (libraries != null) {
                List<LibraryDTO> libraryDTOList = new java.util.ArrayList<>(List.of());
                try {
                    for (Library library : libraries
                    ) {
                        LibraryDTO libraryDTO = LibraryDTO.builder()
                                .id(library.getId())
                                .user_id(library.getUser().getId())
                                .title(library.getTitle())
                                .build();
                        libraryDTOList.add(libraryDTO);
                    }
                    return ResponseEntity.ok(libraryDTOList);
                }
                catch (Exception e ){
                    return ResponseEntity.status(HttpStatus.CONFLICT).body("Error serializing User to JSON");
                }
            }
            else {
                ResponseEntity.ok("User has no libraries");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not Authenticated");

    }
    @GetMapping("/profile/mylibrary/{library_id}")
    public String userLibrariesId(@PathVariable(value = "library_id") Long library_id, Model model, Authentication authentication){
        Library authenticatedLibrary = bookService.getLibraryByIdByAuthenticatedUser(library_id,getAuthenticatedUser(authentication));
        if (authenticatedLibrary == null){

            return "redirect:/";
        }
        model.addAttribute("authenticatedLibrary", authenticatedLibrary);
        return "booksFromLibrary";
    }

}
