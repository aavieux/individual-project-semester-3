package com.example.demo.repositories;

import com.example.demo.models.Review;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "SELECT * FROM review", nativeQuery = true)
    public List<Review> getAllReviews();


    @Modifying //it will change the database
    @Transactional
    //  If an exception occurs, the transaction is rolled back, reverting any changes made within the method, ensuring that the database remains in a consistent state.
    @Query(value = "INSERT INTO review (description, rating, book_id, user_id) VALUES (:description_p, :rating_p, :book_id_p, :user_id_p))", nativeQuery = true)
    boolean addReview(@Param("description_p") String description, @Param("rating_p") Float rating, @Param("book_id_p") Long book_id_p, @Param("user_id_p") Long user_id_p);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM review r WHERE r.id LIKE :review_id_p", nativeQuery = true)
    boolean deleteReviewById(@Param("review_id_p") Long review_id);

}
