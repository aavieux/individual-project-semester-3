//package com.example.demo.models.mappers;
//
//import com.example.demo.models.User;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.HashMap; // import the HashMap class
//import java.util.Map;
//import java.util.Optional;
//
//public class UserDetailsToJSON {
//    public String Map(Optional<User> user) throws JsonProcessingException {
//        HashMap<String, String> data = new HashMap<>();
//        data.put("id", user.getId().toString());
//        data.put("email", user.getEmail());
//        data.put("f_genre", user.getF_genre().toString());
//        data.put("first_name", user.getFirst_name());
//        data.put("last_name", user.getLast_name());
//        data.put("phone_number", user.getPhone_number());
//        data.put("profile_pic_url",user.getProfile_pic_url() );
//        data.put("role", user.getRole().toString());
//        data.put("shadow_profile_id", user.getF_author().getId().toString());
//        data.put("book_id",user.getF_book().getId().toString());
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        return  objectMapper.writeValueAsString(data);
//    }
//
//}
