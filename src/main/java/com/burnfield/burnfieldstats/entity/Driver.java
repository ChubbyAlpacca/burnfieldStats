package com.burnfield.burnfieldstats.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Table(name = "DRIVERS")
@RequiredArgsConstructor
@Getter
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DRIVER_ID")
    private BigInteger driverId;
    @Column(name = "DRIVER_REF")
    private String driverRef;
    @Column(name = "RACE_NUMBER")
    private String raceNumber;
    @Column(name = "CODE")
    private String code;
    @Column(name = "FORENAME")
    private String name;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "DOB")
    private LocalDate birthDate;
    @Column(name = "NATIONALITY")
    private String nationality;
    @Column(name = "URL")
    private String url;


}
