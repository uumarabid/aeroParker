package com.interview.app.models;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime registered;

    @Column(nullable = false, unique = true)
    private String emailAddress;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String addressLine_1;

    private String addressLine_2;

    private String city;

    @Column(nullable = false)
    private String postcode;

    private String phoneNumber;

    @PrePersist
    public void prePersist() {
        registered = LocalDateTime.now();
    }
}
