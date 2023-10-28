package com.example.demo.models.dtos;

import com.example.demo.models.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FriendshipDTO {

    private Long id;

    private Long user1_id;

    private Long user2_id;
}
