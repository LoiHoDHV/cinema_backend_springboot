package com.example.cinema_3.domain.foodDomain;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode
@Getter
@Setter
public class ComboFoodId implements Serializable {

    @Column(name = "combo_id")
    private Long comboId;

    @Column(name = "food_id")
    private Long foodId;



}
