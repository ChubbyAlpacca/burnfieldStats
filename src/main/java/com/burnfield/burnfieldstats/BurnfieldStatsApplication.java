package com.burnfield.burnfieldstats;

import liquibase.Liquibase;
import liquibase.database.Database;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class BurnfieldStatsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BurnfieldStatsApplication.class, args);
    }

}
