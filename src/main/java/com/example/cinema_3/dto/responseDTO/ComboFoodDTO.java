package com.example.cinema_3.dto.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ComboFoodDTO {
    private Long comboId;
    private String comboName;
    private String comboDescription;
    private Double comboDiscount;
    private Integer comboQuantity;
    private Long foodId;
    private String foodName;
    private Double foodPrice;
}
