package com.uber.UberEntityService.models;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExactLocation extends BaseModel {

    private Double longitude;
    private Double latitude;

}
