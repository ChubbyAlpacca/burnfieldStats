package com.burnfield.burnfieldstats.service.Impl;

import com.burnfield.burnfieldstats.controller.constructors.dto.ConstructorResponse;
import com.burnfield.burnfieldstats.controller.constructors.dto.ConstructorsResponse;
import com.burnfield.burnfieldstats.entity.Constructor;
import com.burnfield.burnfieldstats.entity.Races;
import com.burnfield.burnfieldstats.exception.BurnfieldException;
import com.burnfield.burnfieldstats.repository.ConstructorRepository;
import com.burnfield.burnfieldstats.repository.RaceResultsRepository;
import com.burnfield.burnfieldstats.repository.RacesRepository;
import com.burnfield.burnfieldstats.service.ConstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.burnfield.burnfieldstats.exception.ExceptionConstants.INVALID_CONSTRUCTOR_NAME;
import static com.burnfield.burnfieldstats.transform.ConstructorAdapter.*;

@Service
@RequiredArgsConstructor
public class ConstructorServiceImpl implements ConstructorService {

    private final RacesRepository racesRepository;

    private final RaceResultsRepository resultsRepository;

    private final ConstructorRepository constructorRepository;

    @Override
    public ConstructorResponse getConstructorByName(String name) throws BurnfieldException {
        var optionalConstructor = constructorRepository.findConstructorByName(name);
        if (optionalConstructor.isEmpty()) {
            throw new BurnfieldException(INVALID_CONSTRUCTOR_NAME + name, HttpStatus.BAD_REQUEST);
        } else {
            return mapToConstructorResponse(optionalConstructor.get());
        }
    }

    @Override
    public ConstructorsResponse getAllConstructors(int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        var constructorList = constructorRepository.findAll(pageable);
        var metaData = constructorsMetaDataBuilder(Optional.of(page), Optional.of(limit), Optional.of(constructorList.getSize()), Optional.empty(), Optional.empty());
        return mapToConstructorsResponsePaginated(constructorList, metaData);
    }

    @Override
    public ConstructorsResponse getConstructorsByRoundAndYear(Optional<Integer> round, int year) {
        List<Constructor> constructorList = new ArrayList<>();
        var race = racesRepository.getRacesByRoundAndRaceYear(round.orElse(1), year);
        if (null == race) {
            //TODO REVIEW THIS AS EXCEPTION NOT RETURNED TO CLIENT SIDE
            throw new BurnfieldException(String.format("No race data found for year %s and round %s", year, round), HttpStatus.BAD_REQUEST);
        } else {
            var results = resultsRepository.findRaceResultsByRaceId(race.getRaceId());
            results.forEach(result -> {
                var constructor = constructorRepository.getReferenceById(BigInteger.valueOf(result.getConstructorId()));
                constructorList.add(constructor);
            });
            return mapToConstructorsResponse(constructorList, constructorsMetaDataBuilder(Optional.empty(), Optional.empty(), Optional.of(constructorList.size()), Optional.of(year), round));
        }
    }

    @Override
    public ConstructorsResponse getConstructorsByYear(int year) {
        List<Constructor> constructorList = new ArrayList<>();
        var races = racesRepository.getRacesByRaceYear(year);
        var results = resultsRepository.findRaceResultsByRaceId(races.get(0).getRaceId());
        results.forEach(result -> {
            var constructor = constructorRepository.getReferenceById(BigInteger.valueOf(result.getConstructorId()));
            constructorList.add(constructor);
        });
        return mapToConstructorsResponse(constructorList, constructorsMetaDataBuilder(Optional.empty(), Optional.empty(), Optional.of(constructorList.size()), Optional.of(year), Optional.empty()));
    }

}
