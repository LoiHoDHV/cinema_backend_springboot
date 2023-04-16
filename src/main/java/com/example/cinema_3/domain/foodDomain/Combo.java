package com.example.cinema_3.domain.foodDomain;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name="tbl_combo")
@ToString
public class Combo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "combo_id")
    private Long foodComboId;

    @Column(name="combo_name", unique = true)
    private String comboName;

    @Column(name="combo_description")
    private String comboDescription;

    @Column(name="combo_discount", nullable = true)
    private double comBoDiscount;

    @Column(name = "combo_quantity")
    private int comboQuantity;

    @OneToMany(mappedBy = "combo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ToString.Exclude
    private List<ComboFood> listCombo = new ArrayList<>();


    public void addFoodCombo(Food food, Integer foodQuantity){
        ComboFood comboFood = new ComboFood();
        comboFood.setFood(food);
        comboFood.setCombo(this);
        comboFood.setQuantity(foodQuantity);
        ComboFoodId cbId = new ComboFoodId();
        cbId.setFoodId(food.getFoodId());
        cbId.setComboId(this.getFoodComboId());
        comboFood.setComboFoodId(cbId);
        this.listCombo.add(comboFood);
        food.setFoodQuantity(food.getFoodQuantity() - foodQuantity);
        food.getListCombo().add(comboFood);
    }


    public void removeFood(){
        for(Iterator<ComboFood> iterator = listCombo.iterator(); iterator.hasNext();){
            ComboFood comboFood = iterator.next();

            if(comboFood.getCombo().equals(this)){
                iterator.remove();
                comboFood.getFood().getListCombo().remove(comboFood);
                comboFood.setFood(null);
                comboFood.setCombo(null);
            }
        }
    }








//    // Bookings
//    @ManyToOne
//    @JoinColumn(name="booking_id")
//    private Booking booking;



}
