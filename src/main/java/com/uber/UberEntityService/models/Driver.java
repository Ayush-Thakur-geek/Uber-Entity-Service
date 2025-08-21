package com.uber.UberEntityService.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Driver extends BaseModel {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String licenseNumber;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "driver")
    private Car car;

    @Enumerated(EnumType.STRING)
    private DriverApprovalStatus driverApprovalStatus;

    @OneToOne
    private ExactLocation lastKnownLocation;

    @OneToOne
    private ExactLocation home;

    @Column(name = "active_city")
    private String activeCity;

    private boolean isAvailable;

    @DecimalMin(value = "0.01", message = "Rating must be greater than or equal to 0.01")
    @DecimalMax(value = "5.00", message = "Rating must be less than or equal to 5.0")
    private Double rating;

    @OneToMany(mappedBy = "driver", fetch = FetchType.LAZY) // By default, the fetch mode is LAZY for ONE to MANY.
    @Fetch(FetchMode.SUBSELECT) // But remember to annotate the service method with @Transactional
    private List<Booking> bookings = new ArrayList<>(); // One side doesn't get a foreign key.

}
