package com.example.cinema_3.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "tbl_bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;


//    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
//    private Set<Ticket> tickets;
//
//
//    @OneToMany(mappedBy = "booking")
//    private Set<Seat> seats;



    //WEB Users
//    @ManyToOne
//    @JoinColumn(name = "user_web_id")
//    private UserWeb userWeb;

    //Combo

//    @OneToMany(mappedBy = "booking")
//    private Set<FoodCombo> foodCombos;

    //food
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "tbl_booking_food",
//            joinColumns = {@JoinColumn(name = "booking_id")},
//            inverseJoinColumns = {@JoinColumn(name = "food_id")}
//    )
//    @JsonManagedReference
//    private Set<Food> foods;




}