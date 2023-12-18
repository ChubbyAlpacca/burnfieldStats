package com.burnfield.burnfieldstats.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class DriverRepositoryTest {

    @Autowired
    private DriverRepository underTest;

    @Test
    void isValidRepository() {
        var response = underTest.findById(BigInteger.ONE);
        System.out.println(response);
        assertNotNull(response);
        assertEquals(BigInteger.ONE, response.get().getDriverId());
    }
}