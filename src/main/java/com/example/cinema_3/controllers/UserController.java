package com.example.cinema_3.controllers;


import com.example.cinema_3.Repositories.UserRepository;
import com.example.cinema_3.Services.UserSevices;
import com.example.cinema_3.domain.User;
import com.example.cinema_3.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/createStaff")
public class UserController {


    @Autowired
    UserSevices userSevices;

    @PostMapping()
    public ResponseEntity<?> createStaff(@RequestBody UserDTO userDTO){
        User user = userSevices.save(userDTO);
        System.out.println(user.getUserRole().getRoleName());
        return ResponseEntity.ok(user);

    }


}
