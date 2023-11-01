package com.burnfield.burnfieldstats.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "RACES")
@RequiredArgsConstructor
@Getter
@Setter
public class Races {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RACE_ID")
    private Long raceId;

    @Column(name = "RACE_YEAR")
    private Integer raceYear;

    @Column(name = "ROUND")
    private Integer round;

    @ManyToOne
    @JoinColumn(name = "CIRCUIT_ID")
    private Circuit circuit;

    @Column(name = "NAME", length = 255)
    private String name;

    @Column(name = "RACE_DATE")
    private LocalDate raceDate;

    @Column(name = "RACE_TIME")
    private LocalTime raceTime;

    @Column(name = "URL", length = 255)
    private String url;

    @Column(name = "FP1_DATE")
    private LocalDate fp1Date;

    @Column(name = "FP1_TIME")
    private LocalTime fp1Time;

    @Column(name = "FP2_DATE")
    private LocalDate fp2Date;

    @Column(name = "FP2_TIME")
    private LocalTime fp2Time;

    @Column(name = "FP3_DATE")
    private LocalDate fp3Date;

    @Column(name = "FP3_TIME")
    private LocalTime fp3Time;

    @Column(name = "QUALI_DATE")
    private LocalDate qualiDate;

    @Column(name = "QUALI_TIME")
    private LocalTime qualiTime;

    @Column(name = "SPRINT_DATE")
    private LocalDate sprintDate;

    @Column(name = "SPRINT_TIME")
    private LocalTime sprintTime;
}

