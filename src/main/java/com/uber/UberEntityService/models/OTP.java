package com.uber.UberEntityService.models;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.Random;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OTP extends BaseModel {

    private String code;

    private String sentToNumber;

    public static OTP make(String phoneNumber) {

        Random random = new Random();
        Integer otp = random.nextInt(9000) + 1000;

        return OTP.builder()
                .code(otp.toString())
                .sentToNumber(phoneNumber)
                .build();
    }

}
