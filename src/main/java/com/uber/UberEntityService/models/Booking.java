package com.uber.UberEntityService.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(indexes = {
        @Index(columnList = "driver_id")
})
public class Booking extends BaseModel {

    @Enumerated(value = EnumType.STRING) // Default would be EnumType.ORDINAL, i.e. tiny int.
    private BookingStatus bookingStatus;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date endTime;

    private Double totalDistance;

    @ManyToOne(fetch = FetchType.LAZY) // The Default fetch mode for MANY to ONE and MANY to MANY is EAGER.
    private Driver driver; // Many side has a foreign key

    @ManyToOne(fetch = FetchType.LAZY)
    private Passenger passenger;

    @OneToOne(cascade = CascadeType.ALL)
    private ExactLocation startLocation;

    @OneToOne(cascade = CascadeType.ALL)
    private ExactLocation endLocation;

}
/*
    The booking table is going to act as a through table, as it provides many to many relationship between passanger and
    driver.
*/