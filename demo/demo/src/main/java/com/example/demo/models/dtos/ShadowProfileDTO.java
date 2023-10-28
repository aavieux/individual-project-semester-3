package com.example.demo.models.dtos;

import com.example.demo.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ShadowProfileDTO {

    private Long id;

    private String first_name;

    private String last_name;

    private String pseudonym;

    private String profile_pic_url;

}
