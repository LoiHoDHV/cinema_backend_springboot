package com.example.cinema_3.dto.responseDTO;

import lombok.Data;

@Data
public class FoodResponseDTO {
    private Long foodId;
    private String foodName;
    private Double foodPrice;
    private Integer foodQuantity;

    public FoodResponseDTO(Long foodId, String foodName, Double foodPrice, Integer foodQuantity) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodQuantity = foodQuantity;
    }
}
