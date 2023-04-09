package com.example.cinema_3.controllers.admin;


import com.example.cinema_3.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/welcome22")
@CrossOrigin("*")
public class WelcomeController {


    @GetMapping
    ResponseEntity<?> helloAdmin(){
        User user
                 = new User();
        user.setUsername("Loi");
        return ResponseEntity.ok(user);
    }


}
