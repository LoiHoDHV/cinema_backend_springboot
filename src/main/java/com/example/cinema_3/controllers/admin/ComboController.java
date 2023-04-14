package com.example.cinema_3.controllers.admin;


import com.example.cinema_3.Services.ComboFoodServices;
import com.example.cinema_3.dto.FoodComboDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin/foodcombos")
public class ComboController {


    @Autowired
    ComboFoodServices comboFoodServices;


    @GetMapping
    public ResponseEntity<?> getAllCombo(){
        return ResponseEntity.ok(comboFoodServices.getAllFoodCombo());
    }

    @PostMapping
    public ResponseEntity<?> createNewCombo(@RequestBody FoodComboDTO foodComboDTO){

        try{
            return ResponseEntity.ok(comboFoodServices.createACombo(foodComboDTO));
        }catch (RuntimeException e){
            Map<String, String> errors = new HashMap<>();
            errors.put("message", "Bad Request");
            return ResponseEntity.badRequest().body(errors);
        }

    }
}
