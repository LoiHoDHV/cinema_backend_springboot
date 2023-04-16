package com.example.cinema_3.dto;


import lombok.Data;

import java.util.Map;
import java.util.Set;

@Data
public class FoodComboDTO {

    private String comboName;
    private String comboDescription;
    private double comBoDiscount;
    private int comboQuantity;
    private Map<Integer, Integer> foodInCombo;
    private Set<FoodDTO> listResponseDTOS;

}
