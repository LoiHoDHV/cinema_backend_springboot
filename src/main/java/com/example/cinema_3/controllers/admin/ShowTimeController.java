package com.example.cinema_3.controllers.admin;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/showtimes")
@CrossOrigin("*")
public class ShowTimeController {

    /// Lấy lịch tất cả các lịch chiếu từ hiện tại đến tương lai
    @GetMapping
    public ResponseEntity<?> getAllShowTimesFromCurrent(){
        return null;
    }

}
