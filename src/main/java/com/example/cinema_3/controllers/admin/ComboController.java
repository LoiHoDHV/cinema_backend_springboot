package com.example.cinema_3.controllers.admin;


import com.example.cinema_3.Services.ComboFoodServices;
import com.example.cinema_3.dto.FoodComboDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
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
    @GetMapping(value = "/{comboId}")
    public ResponseEntity<?> getDetailsCombo(@PathVariable Long comboId){
        try{
            return ResponseEntity.ok(comboFoodServices.getDetailsCombobyId(comboId));
        }catch (EntityNotFoundException e){
            Map<String, String> errors = new HashMap<>();
            errors.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(errors);
        }
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

    @PutMapping(value = "/{comboId}")
    public ResponseEntity<?> updateTheComBo(@PathVariable Long comboId,@RequestBody FoodComboDTO foodComboDTO){
        try{
            return ResponseEntity.ok(comboFoodServices.updateFoodCombo(comboId, foodComboDTO));
        }catch(RuntimeException e){
            Map<String, String> errors = new HashMap<>();
            errors.put("message", "Bad Request");
            return ResponseEntity.internalServerError().body(errors);
        }
    }

    @DeleteMapping(value = "/{comboId}")
    public ResponseEntity<?> deleteTheCombo(@PathVariable Long comboId){
        Integer status = comboFoodServices.deleteComboFood(comboId);
        if(status == -1){
            Map<String, String> errors = new HashMap<>();
            errors.put("message", "Internal Servcer Errors");
            return ResponseEntity.internalServerError().body(errors);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .header("comboDeleted", String.valueOf(status))
                .body("Deleted Successfully");
    }
}
