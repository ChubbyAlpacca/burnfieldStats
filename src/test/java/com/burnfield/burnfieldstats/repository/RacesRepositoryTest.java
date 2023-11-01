package com.burnfield.burnfieldstats.repository;

import com.burnfield.burnfieldstats.entity.Races;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RacesRepositoryTest {

    @Autowired
    private RacesRepository repository;

    @Test
    void getRacesByRoundAndRaceYear() {
        //given
        var expectedResponse = roundAndYearMockResponse();
        //when
        var response = repository.getRacesByRoundAndRaceYear(4, 2021);
        //then
        assertEquals(response.getRaceYear(), expectedResponse.getRaceYear());
        assertEquals(response.getRaceId(), expectedResponse.getRaceId());
        assertEquals(response.getRound(), expectedResponse.getRound());
        assertEquals(response.getName(), expectedResponse.getName());
    }

    private Races roundAndYearMockResponse() {
        Races race = new Races();
        race.setRaceId(1055L);
        race.setName("Spanish Grand Prix");
        race.setRound(4);
        race.setRaceYear(2021);

        return race;
    }
}