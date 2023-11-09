package com.burnfield.burnfieldstats.service;

import com.burnfield.burnfieldstats.controller.constructors.dto.ConstructorResponse;
import com.burnfield.burnfieldstats.controller.constructors.dto.ConstructorsResponse;
import com.burnfield.burnfieldstats.exception.BurnfieldException;

import java.util.Optional;

public interface ConstructorService {

    ConstructorResponse getConstructorByName(String name);

    ConstructorsResponse getAllConstructors(int page, int limit);

    ConstructorsResponse getConstructorsByRoundAndYear(Optional<Integer> round, int year);

    ConstructorsResponse getConstructorsByYear(int year);


}
