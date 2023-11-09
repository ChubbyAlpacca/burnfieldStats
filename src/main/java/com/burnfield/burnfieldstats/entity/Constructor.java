package com.burnfield.burnfieldstats.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Table(name = "CONSTRUCTORS")
@RequiredArgsConstructor
@Getter
@Setter
public class Constructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONSTRUCTOR_ID")
    private BigInteger constructorId;

    @Column(name = "CONSTRUCTOR_REF")
    private String constructorRef;

    @Column(name = "NAME")
    private String name;

    @Column(name = "NATIONALITY")
    private String nationality;

    @Column(name = "URL")
    private String url;
}
