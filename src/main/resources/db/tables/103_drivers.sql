CREATE TABLE DRIVERS
(

    DRIVER_ID   NUMBER(19, 0) NOT NULL GENERATED BY DEFAULT AS IDENTITY (START WITH 1000),
    DRIVER_REF  VARCHAR(255),
    RACE_NUMBER NUMBER(255) DEFAULT NULL,
    CODE        VARCHAR(255),
    FORENAME    VARCHAR(255),
    SURNAME     VARCHAR(255),
    DOB         DATE,
    NATIONALITY VARCHAR(255),
    URL         VARCHAR(255),

    PRIMARY KEY (DRIVER_ID)

);