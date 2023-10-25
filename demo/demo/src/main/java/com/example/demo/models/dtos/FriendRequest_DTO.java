package com.example.demo.models.dtos;

import com.example.demo.models.User;
import com.example.demo.models.enums.Status;
import jakarta.persistence.*;
import lombok.Builder;

@Builder
public class FriendRequest_DTO {

    private Long id;

    private Long sender_id;

    private Long recipient_id;

    private Status status;
}
