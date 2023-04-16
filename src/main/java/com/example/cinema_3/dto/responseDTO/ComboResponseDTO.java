package com.example.cinema_3.dto.responseDTO;

import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class ComboResponseDTO {
    private Long comboId;
    private String comboName;
    private String comboDescription;
    private Double comboDiscount;
    private Integer comboQuantity;
    private Double  comboPrice = Double.valueOf(0);

    private Set<FoodResponseDTO> listResponseDTOS = new HashSet<>();


    // Add new FoodResponseDTO
    // Sum a ComboPrice
    public void setListResponseDTOS( List<FoodResponseDTO> listFoodResponseDTO) {
        if(listFoodResponseDTO != null && listFoodResponseDTO.size() != 0){
            for (FoodResponseDTO foodResponseDTO : listFoodResponseDTO) {

                listResponseDTOS.add(foodResponseDTO);

                // combo 1: coca 2, pepsi 2 => gia tien : foodprice  * foodQuantity
                comboPrice += foodResponseDTO.getFoodPrice() * foodResponseDTO.getFoodQuantity();
            }
            comboPrice = comboDiscount * comboPrice;
        }
    }

}
