package com.burnfield.burnfieldstats.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RaceResultsRepositoryTest {

    @Autowired
    RaceResultsRepository resultsRepository;

    @Test
    void shpouldFindRaceResultsByRaceId() {
        //given
        var expectedResults = "null";

        //when
        var result = resultsRepository.findRaceResultsByRaceId(2L);
        resultsRepository.findRaceResultsByRaceId(7L);
        //then
//        assertEquals();


    }
}