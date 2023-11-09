package com.burnfield.burnfieldstats.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CircuitRepositoryTest {

    @Autowired
    private CircuitRepository circuitRepository;

    @Test
    void isValidRepository() {
        var response = circuitRepository.findCircuitsByCountry("Spain");
        assertEquals(response.size(), 6);
    }

}