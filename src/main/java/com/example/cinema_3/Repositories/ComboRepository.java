package com.example.cinema_3.Repositories;

import com.example.cinema_3.domain.foodDomain.Combo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComboRepository extends JpaRepository<Combo, Long> {

}
