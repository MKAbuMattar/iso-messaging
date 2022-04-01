package io.github.MKAbuMattar.isomessaging.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SMSRequestModel {

    @NotBlank
    private final String phoneNumber;

    public SMSRequestModel(@JsonProperty("phoneNumber") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
