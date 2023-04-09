package com.example.cinema_3.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Data
@Entity
@Table(name = "tbl_web_users")
public class UserWeb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userWebId;
    @Column(unique = true)
    private String username;
    private String password;

    @Column(name="userFullName")
    private String userFullName;
    @Column(name="userPhoneNumber",columnDefinition = "varchar(20) default '0123456789'")
    private String phoneNumber;
    @Column(name="userAddress",columnDefinition = "varchar(255) default 'Nghe An'")
    private String address;
    @Column(name="userImageUrl")
    private String imageUrl;
    @Column(columnDefinition = "varchar(20) default 'ROLE_USER'")
    private String userRole;
    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;



    // Bookings
//    @OneToMany(mappedBy = "userWeb", cascade = CascadeType.ALL)
//    private Set<Booking> bookings;



}
