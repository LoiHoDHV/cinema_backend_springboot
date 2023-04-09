package com.example.cinema_3.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name="tbl_combo")
public class FoodCombo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodComboId;

    @Column(name="combo_name")
    private String comboName;

    @Column(name="combo_description")
    private String comboDescription;

    @Column(name="combo_discount", nullable = true)
    private double comBoDiscount;


    @OneToMany(mappedBy = "foodCombo", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<FoodComboItem> foods;






//    // Bookings
//    @ManyToOne
//    @JoinColumn(name="booking_id")
//    private Booking booking;



}
