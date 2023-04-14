package com.example.cinema_3.domain.foodDomain;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name="tbl_food")
@EqualsAndHashCode
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
    @ToString.Exclude
    private List<ComboFood> listCombo = new ArrayList<>();

}
