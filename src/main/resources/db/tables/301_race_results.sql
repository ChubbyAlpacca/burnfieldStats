CREATE TABLE RACE_RESULTS
(
    RESULT_ID         NUMBER(19, 0) GENERATED BY DEFAULT AS IDENTITY,
    RACE_ID           INT,
    DRIVER_ID         INT,
    CONSTRUCTOR_ID    INT,
    NUMBER            INT,
    GRID              INT,
    POSITION          INT,
    POSITION_TEXT     VARCHAR(255),
    POSITION_ORDER    INT,
    POINTS            DECIMAL(10, 2),
    LAPS              INT,
    TIME              VARCHAR(20),
    MILLISECONDS      INT,
    FASTEST_LAP       INT,
    RANK              INT,
    FASTEST_LAP_TIME  VARCHAR(10),
    FASTEST_LAP_SPEED VARCHAR(10),
    STATUS_ID         INT,


    FOREIGN KEY (RACE_ID) REFERENCES RACES (RACE_ID),
    FOREIGN KEY (DRIVER_ID) REFERENCES DRIVERS (DRIVER_ID),
    FOREIGN KEY (CONSTRUCTOR_ID) REFERENCES CONSTRUCTORS (CONSTRUCTOR_ID),
    FOREIGN KEY (STATUS_ID) REFERENCES STATUS (STATUS_ID)
);
