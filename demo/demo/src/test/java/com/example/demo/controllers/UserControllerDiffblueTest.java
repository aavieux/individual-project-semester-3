package com.example.demo.controllers;

import static org.mockito.Mockito.when;

import com.example.demo.models.Book;
import com.example.demo.models.ShadowProfile;
import com.example.demo.models.User;
import com.example.demo.models.enums.Genre;
import com.example.demo.models.enums.Role;
import com.example.demo.services.UserService;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UserController.class})
@ExtendWith(SpringExtension.class)
class UserControllerDiffblueTest {
    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    /**
     * Method under test: {@link UserController#getUserDetails(Authentication)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUserDetails() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   jakarta.servlet.ServletException: Request processing failed: java.lang.NullPointerException: Cannot invoke "org.springframework.security.core.Authentication.getPrincipal()" because "authentication" is null
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:564)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.security.core.Authentication.getPrincipal()" because "authentication" is null
        //       at com.example.demo.controllers.UserController.getUserDetails(UserController.java:43)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:564)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{};
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/users/profile", uriVariables);
        Object[] controllers = new Object[]{userController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link UserController#getUserPage(Long, Authentication)}
     */
    @Test
    void testGetUserPage() throws Exception {
        ShadowProfile f_author = new ShadowProfile();
        f_author.setFirst_name("Jane");
        f_author.setFollowers(new ArrayList<>());
        f_author.setId(1L);
        f_author.setLast_name("Doe");
        f_author.setProfile_pic_url("https://example.org/example");
        f_author.setPseudonym("Pseudonym");

        ShadowProfile author = new ShadowProfile();
        author.setFirst_name("Jane");
        author.setFollowers(new ArrayList<>());
        author.setId(1L);
        author.setLast_name("Doe");
        author.setProfile_pic_url("https://example.org/example");
        author.setPseudonym("Pseudonym");

        Book f_book = new Book();
        f_book.setAuthor(author);
        f_book.setCover_url("https://example.org/example");
        f_book.setFollowers(new ArrayList<>());
        f_book.setGenre(Genre.SCI_FI);
        f_book.setId(1L);
        f_book.setIsbn("Isbn");
        f_book.setReviews(new ArrayList<>());
        f_book.setTitle("Dr");
        f_book.setTransactions(new ArrayList<>());

        User user = new User();
        user.setCollection(new ArrayList<>());
        user.setEmail("jane.doe@example.org");
        user.setF_author(f_author);
        user.setF_book(f_book);
        user.setF_genre(Genre.SCI_FI);
        user.setFirst_name("Jane");
        user.setId(1L);
        user.setLast_name("Doe");
        user.setPassword("iloveyou");
        user.setPhone_number("6625550144");
        user.setProfile_pic_url("https://example.org/example");
        user.setReviews(new ArrayList<>());
        user.setRole(Role.USER);
        user.setTransactions(new ArrayList<>());
        when(userService.getAllFriendsByUser(Mockito.<User>any())).thenReturn(new ArrayList<>());
        when(userService.getUserById(Mockito.<Long>any())).thenReturn(user);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/users");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":null,\"role\":null,\"first_name\":\"Jane\",\"last_name\":\"Doe\",\"email\":\"jane.doe@example.org\",\"phone"
                                        + "_number\":null,\"profile_pic_url\":\"https://example.org/example\",\"f_genre\":\"SCI_FI\",\"f_book_id\":1,\"f"
                                        + "_author_id\":1,\"f_author_pseudonym\":\"Pseudonym\",\"total_friends\":0}"));
    }
}

