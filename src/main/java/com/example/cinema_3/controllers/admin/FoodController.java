package com.example.cinema_3.controllers.admin;


import com.example.cinema_3.Services.FoodServices;
import com.example.cinema_3.dto.FoodDTO;
import com.example.cinema_3.exceptions.FoodNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin/foods")
public class FoodController {

    @Autowired
    FoodServices foodServices;

    // lấy ra tất cả số lượng thức ăn còn trong kho
    @GetMapping
    public ResponseEntity<?> getAllFoods(){
        return ResponseEntity.ok(foodServices.getAllFood());
    }

    @GetMapping(value = "{foodId}")
    public ResponseEntity<?> getDetailsFoods(@PathVariable Long foodId) {
        if (foodServices.findFoodById(foodId) == null) {
            throw new FoodNotFoundException("We don't find that food!!");
        }
        return ResponseEntity.ok(foodServices.findFoodById(foodId));
    }
    @PutMapping(value = "{foodId}")
    public ResponseEntity<?> updateTheFood(@PathVariable Long foodId, @RequestBody FoodDTO foodDTO){
        return null;

    }

    @PostMapping
    public ResponseEntity<?> createNewFood(@RequestBody FoodDTO foodDTO){
        return ResponseEntity.ok(foodServices.save(foodDTO));
    }


}
