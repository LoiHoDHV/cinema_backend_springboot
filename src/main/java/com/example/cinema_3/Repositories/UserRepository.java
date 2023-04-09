package com.example.cinema_3.Repositories;


import com.example.cinema_3.domain.User;
import com.example.cinema_3.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User save(UserDTO user);

}
