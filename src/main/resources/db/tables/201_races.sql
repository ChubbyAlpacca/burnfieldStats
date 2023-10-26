CREATE TABLE RACES
(
    RACE_ID     NUMBER(19, 0) GENERATED BY DEFAULT AS IDENTITY,
    RACE_YEAR   INT,
    ROUND       INT,
    CIRCUIT_ID  NUMBER(19, 0),
    NAME        VARCHAR(255),
    RACE_DATE   DATE,
    RACE_TIME   TIME,
    URL         VARCHAR(255),
    FP1_DATE    DATE,
    FP1_TIME    TIME,
    FP2_DATE    DATE,
    FP2_TIME    TIME,
    FP3_DATE    DATE,
    FP3_TIME    TIME,
    QUALI_DATE  DATE,
    QUALI_TIME  TIME,
    SPRINT_DATE DATE,
    SPRINT_TIME TIME
);
