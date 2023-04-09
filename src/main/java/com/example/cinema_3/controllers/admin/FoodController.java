package com.example.cinema_3.controllers.admin;


import com.example.cinema_3.Services.FoodServices;
import com.example.cinema_3.domain.Food;
import com.example.cinema_3.dto.FoodDTO;
import com.example.cinema_3.exceptions.FoodNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
        Food savedFood = foodServices.updateTheFood(foodId, foodDTO);
        if(savedFood == null){
            Map<String, String> errors = new HashMap<>();
            errors.put("message", "404 Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
        }

        return ResponseEntity.ok(savedFood);


    }

    @DeleteMapping(value = "{foodId}")
    public ResponseEntity<?> deleteTheFood(@PathVariable Long foodId){
        int isDelete = foodServices.deleteFood(foodId);
        if(isDelete == -1){
            Map<String, String> errors = new HashMap<>();
            errors.put("message", "404 Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .header("idDeleted", String.valueOf(foodId))
                .body("Deleted Successfully");

    }

    @PostMapping
    public ResponseEntity<?> createNewFood(@RequestBody FoodDTO foodDTO){
        return ResponseEntity.ok(foodServices.save(foodDTO));
    }


}
