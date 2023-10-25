package com.burnfield.burnfieldstats.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;

@Entity
@Table(name = "CIRCUITS")
@RequiredArgsConstructor
@Getter
public class Circuit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CIRCUIT_ID")
    private BigInteger circuitId;
    @Column(name = "CIRCUIT_REF")
    private String circuitRef;
    @Column(name = "NAME")
    private String name;
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "LAT")
    private String lat;
    @Column(name = "LNG")
    private String lng;
    @Column(name = "ALT")
    private String alt;
    @Column(name = "URL")
    private String url;

}
