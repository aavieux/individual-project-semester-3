package com.example.demo.repositories;

import com.example.demo.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

//@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM [user]", nativeQuery = true)
    List<User> getAllUsers();

    @Modifying //it will change the database
    @Transactional //  If an exception occurs, the transaction is rolled back, reverting any changes made within the method, ensuring that the database remains in a consistent state.
    @Query(value = "INSERT INTO user (first_name, last_name, email, password, phone_number, f_genre, shadowprofile_id, book_id ) VALUES (:first_name_p, :last_name_p, :email_p, :password_p, :phone_number_p, :f_genre_p, :shadowprofile_id_p, :book_id_p)", nativeQuery = true)
    boolean addUser(@Param("first_name_p")String first_name,
                    @Param("last_name_p") String last_name,
                    @Param("email_p") String email,
                    @Param("password_p") String password,
                    @Param("phone_number_p") String phone_number,
                    @Param("f_genre_p")String genre,
                    @Param("shadowprofile_id_p") Integer shadowprofile_id,
                    @Param("book_id_p") Integer book_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM User u WHERE u.id = :userId_p", nativeQuery = true)
    boolean deleteUser(@Param("userId_p") Integer userId);

    @Query(value = "SELECT FROM User u WHERE u.email = :user_email_p", nativeQuery = true)
    User getUserByEmail(@Param("user_email_p") String user_email);
}