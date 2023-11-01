package com.burnfield.burnfieldstats.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Table(name = "RACE_RESULTS")
@RequiredArgsConstructor
@Getter
@Setter
public class RaceResults {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESULT_ID")
    private BigInteger resultId;

    @Column(name = "RACE_ID")
    private Long raceId;

    @Column(name = "DRIVER_ID")
    private Integer driverId;

    @Column(name = "CONSTRUCTOR_ID")
    private Integer constructorId;

    @Column(name = "NUMBER")
    private Integer number;

    @Column(name = "GRID")
    private Integer grid;

    @Column(name = "POSITION")
    private Integer position;

    @Column(name = "POSITION_TEXT")
    private String positionText;

    @Column(name = "POSITION_ORDER")
    private Integer positionOrder;

    @Column(name = "POINTS")
    private double points;

    @Column(name = "LAPS")
    private Integer laps;

    @Column(name = "TIME")
    private String time;

    @Column(name = "MILLISECONDS")
    private Integer milliseconds;

    @Column(name = "FASTEST_LAP")
    private Integer fastestLap;

    @Column(name = "RANK")
    private Integer rank;

    @Column(name = "FASTEST_LAP_TIME")
    private String fastestLapTime;

    @Column(name = "FASTEST_LAP_SPEED")
    private String fastestLapSpeed;

    @Column(name = "STATUS_ID")
    private Integer statusId;
}

