package com.example.demo.controllers;

import static org.mockito.Mockito.when;

import com.example.demo.models.Book;
import com.example.demo.models.ShadowProfile;
import com.example.demo.models.enums.Genre;
import com.example.demo.services.BookService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {BookController.class})
@ExtendWith(SpringExtension.class)
class BookControllerDiffblueTest {
    @Autowired
    private BookController bookController;

    @MockBean
    private BookService bookService;

    /**
     * Method under test: {@link BookController#allBooks()}
     */
    @Test
    void testAllBooks() throws Exception {
        when(bookService.getAllBooks()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/books");
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link BookController#allBooks()}
     */
    @Test
    void testAllBooks2() throws Exception {
        ShadowProfile author = new ShadowProfile();
        author.setFirst_name("Jane");
        author.setFollowers(new ArrayList<>());
        author.setId(1L);
        author.setLast_name("Doe");
        author.setProfile_pic_url("https://example.org/example");
        author.setPseudonym("Pseudonym");

        Book book = new Book();
        book.setAuthor(author);
        book.setCover_url("https://example.org/example");
        book.setFollowers(new ArrayList<>());
        book.setGenre(Genre.SCI_FI);
        book.setId(1L);
        book.setIsbn("Isbn");
        book.setReviews(new ArrayList<>());
        book.setTitle("Dr");
        book.setTransactions(new ArrayList<>());

        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(book);
        when(bookService.getAllBooks()).thenReturn(bookList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/books");
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":1,\"title\":\"Dr\",\"isbn\":null,\"genre\":\"SCI_FI\",\"author_id\":1,\"cover_url\":\"https://example.org"
                                        + "/example\",\"author_pseudonym\":null,\"author_profile_pic_url\":null,\"library_title\":null}]"));
    }

    /**
     * Method under test: {@link BookController#getBookDetails(Long)}
     */
    @Test
    void testGetBookDetails() throws Exception {
        ShadowProfile author = new ShadowProfile();
        author.setFirst_name("Jane");
        author.setFollowers(new ArrayList<>());
        author.setId(1L);
        author.setLast_name("Doe");
        author.setProfile_pic_url("https://example.org/example");
        author.setPseudonym("Pseudonym");

        Book book = new Book();
        book.setAuthor(author);
        book.setCover_url("https://example.org/example");
        book.setFollowers(new ArrayList<>());
        book.setGenre(Genre.SCI_FI);
        book.setId(1L);
        book.setIsbn("Isbn");
        book.setReviews(new ArrayList<>());
        book.setTitle("Dr");
        book.setTransactions(new ArrayList<>());
        when(bookService.getBookById(Mockito.<Long>any())).thenReturn(book);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/books/{id}", 1L);
        MockMvcBuilders.standaloneSetup(bookController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"title\":\"Dr\",\"isbn\":\"Isbn\",\"genre\":\"SCI_FI\",\"author_id\":1,\"cover_url\":\"https://example.org"
                                        + "/example\",\"author_pseudonym\":\"Pseudonym\",\"author_profile_pic_url\":null,\"library_title\":null}"));
    }
}

