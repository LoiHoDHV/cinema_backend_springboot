package com.example.cinema_3.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name="tbl_food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;

    @Column(name="food_name", unique = true)
    private String foodName;

    @Column(name = "food_price")
    private Double foodPrice;

    @Column(name = "food_quantity")
    private Long foodQuantity;

    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
    @JsonIgnore
    @JsonManagedReference
    private Set<FoodComboItem> foodCombos;







}
