package com.example.demo.repositories;
import com.example.demo.models.ShadowProfile;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShadowProfileRepository extends JpaRepository<ShadowProfile, Long> {

    @Query(value = "SELECT * FROM shadow_profile", nativeQuery = true)
    public List<ShadowProfile> getAllShadowProfiles();

    @Modifying //it will change the database
    @Transactional
    //  If an exception occurs, the transaction is rolled back, reverting any changes made within the method, ensuring that the database remains in a consistent state.
    @Query(value = "INSERT INTO shadow_profile () VALUES (:first_name_p, :last_name_p, :profile_pic_url_p, :pseudonym_p))", nativeQuery = true)
    boolean addShadowProfile(@Param("first_name_p") String first_name, @Param("last_name_p") String last_name, @Param("profile_pic_url_p") String profile_pic_url, @Param("pseudonym_p") String pseudonym);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM shadow_profile s WHERE s.id LIKE :shadowprofile_id_p", nativeQuery = true)
    boolean deleteShadowProfileById(@Param("shadowprofile_id_p") Long shadowprofile_id);
}
