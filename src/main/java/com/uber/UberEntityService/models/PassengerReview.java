package com.uber.UberEntityService.models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PassengerReview extends Review {

    private Double passengerRating;
    private String passengerReviewComment;

}
