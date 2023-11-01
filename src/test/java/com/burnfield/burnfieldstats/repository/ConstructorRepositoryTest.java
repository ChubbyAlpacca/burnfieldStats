package com.burnfield.burnfieldstats.repository;

import com.burnfield.burnfieldstats.entity.Constructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigInteger;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class ConstructorRepositoryTest {

    @Autowired
    ConstructorRepository constructorRepository;

    @Test
    void findConstructorByName() {
        var maserati = getMaseratiResponse();

        var name1 = "Maserati";
        var name2 = "non-existent";

        var response1 = constructorRepository.findConstructorByName(name1);
        var response2 = constructorRepository.findConstructorByName(name2);

        assertEquals(response1.get().getName(), maserati.getName());
        assertEquals(response1.get().getUrl(), maserati.getUrl());
        assertEquals(response1.get().getNationality(), maserati.getNationality());

        assertEquals(response2, Optional.empty());

    }

    private Constructor getMaseratiResponse() {
        Constructor constructor = new Constructor();
        constructor.setName("Maserati");
        constructor.setNationality("Italian");
        constructor.setUrl("http://en.wikipedia.org/wiki/Maserati");

        return constructor;
    }

}