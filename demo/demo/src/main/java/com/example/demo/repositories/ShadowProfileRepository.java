package com.example.demo.repositories;

import com.example.demo.models.ShadowProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShadowProfileRepository extends JpaRepository<ShadowProfile, Long> {
}
