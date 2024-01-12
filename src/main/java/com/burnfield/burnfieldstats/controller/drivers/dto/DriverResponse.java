package com.burnfield.burnfieldstats.controller.drivers.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_NULL)
@Builder
public class DriverResponse {

    private String name;

    private String surname;

    private LocalDate birthDate;

    private String nationality;

    private String url;

    private String driverRef;

    private String raceNumber;

    private String code;

}

