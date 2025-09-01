package com.uber.UberEntityService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler" , "bookings"})
public class Passenger extends BaseModel {

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String phoneNumber;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @DecimalMin(value = "0.01", message = "Rating must be greater than or equal to 0.01")
    @DecimalMax(value = "5.00", message = "Rating must be less than or equal to 5.0")
    private double rating;

    @OneToOne(cascade = CascadeType.ALL)
    private Booking activeBooking;

    @OneToOne(cascade = CascadeType.ALL)
    private ExactLocation lastKnownLocation;

    @OneToOne(cascade = CascadeType.ALL)
    private ExactLocation home;

    @OneToMany(mappedBy = "passenger", fetch = FetchType.LAZY)
    private List<Booking> bookings = new ArrayList<>();
}
