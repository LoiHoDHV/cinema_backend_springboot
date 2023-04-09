package com.example.cinema_3.Repositories;

import com.example.cinema_3.domain.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowTimeRepostitory extends JpaRepository<ShowTime,Long> {
}
