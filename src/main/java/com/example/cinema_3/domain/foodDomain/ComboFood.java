package com.example.cinema_3.domain.foodDomain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_combo_food")
@EqualsAndHashCode
public class ComboFood {



    @EmbeddedId
    private ComboFoodId comboFoodId;


    @ManyToOne(fetch =  FetchType.LAZY)
    @MapsId("comboId")
    private Combo combo;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("foodId")
    private Food food;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;


}
