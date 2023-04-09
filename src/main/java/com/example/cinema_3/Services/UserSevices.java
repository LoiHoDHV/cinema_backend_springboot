package com.example.cinema_3.Services;


import com.example.cinema_3.Repositories.UserRepository;
import com.example.cinema_3.domain.User;
import com.example.cinema_3.domain.UserRole;
import com.example.cinema_3.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSevices {

    @Autowired
    UserRepository userRepository;

        public User save(UserDTO user) {
        User saveUser = new User();
        saveUser.setUsername(user.getUsername());
        saveUser.setPassword(user.getPassword());
        UserRole userRole = new UserRole();
        userRole.setId(user.getUserRole());

        if (user.getUserRole() == 1) {// admin
            userRole.setRoleName("ROLE_ADMIN");
        } else if (user.getUserRole() == 2) {
            userRole.setRoleName("ROLE_STAFF");
        } else if (user.getUserRole() == 3) {
            userRole.setRoleName("ROLE_STAFF");
        } else {// not match => set to user
            userRole.setRoleName("ROLE_USER");
        }


        saveUser.setUserRole(userRole);
        return userRepository.save(saveUser);
    }
}
