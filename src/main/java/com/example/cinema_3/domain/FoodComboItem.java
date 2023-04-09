package com.example.cinema_3.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_combo_food")
public class FoodComboItem {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long comboFoodId;

    @ManyToOne
    @JoinColumn(name = "food_id")
    @JsonBackReference
    private Food food;

    @ManyToOne
    @JoinColumn(name="food_combo_id")
    @JsonBackReference
    private FoodCombo foodCombo;


    @Column(name = "quantity", nullable = false)
    private Integer quantity;


}
