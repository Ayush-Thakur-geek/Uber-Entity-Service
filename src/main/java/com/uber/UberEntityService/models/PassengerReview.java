package com.uber.UberEntityService.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class PassengerReview extends Review {

    private Double passengerRating;
    private String passengerReviewComment;

}
