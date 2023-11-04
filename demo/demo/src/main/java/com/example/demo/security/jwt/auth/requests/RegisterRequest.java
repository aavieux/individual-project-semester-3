package com.example.demo.security.jwt.auth.requests;
import com.example.demo.models.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private Role role;

    private String first_name;


    private String last_name;


    private String email;


    private String password;


    private String phone_number; //nullable


    private String profile_pic_url; //nullable


}
