package com.burnfield.burnfieldstats.service.Impl;

import com.burnfield.burnfieldstats.controller.drivers.dto.CreateDriver;
import com.burnfield.burnfieldstats.controller.drivers.dto.DriverResponse;
import com.burnfield.burnfieldstats.entity.Driver;
import com.burnfield.burnfieldstats.repository.DriverRepository;
import com.burnfield.burnfieldstats.repository.RaceResultsRepository;
import com.burnfield.burnfieldstats.repository.RacesRepository;
import com.burnfield.burnfieldstats.service.DriverService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DriverServiceImpl implements DriverService {
    private final RacesRepository racesRepository;
    private final DriverRepository driverRepository;
    private final RaceResultsRepository resultsRepository;

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public List<Driver> getDriversByYear(int year) {
        List<Driver> driverList = new ArrayList<>();
        //get races by year, get results by raceId, get drivers
        var raceList = racesRepository.getRacesByRaceYear(year);
        var resultsList = resultsRepository.findRaceResultsByRaceId(raceList.get(0).getRaceId());
        resultsList.forEach(result -> {
           var driver = driverRepository.getDriverByDriverId(Long.valueOf(result.getDriverId()));
            driver.ifPresent(driverList::add);
        });
        return driverList;
    }

    @Override
    public List<Driver> getDriversByYearAndRound(int year, int round) {
        List<Driver> driverList = new ArrayList<>();
        var raceList = racesRepository.getRacesByRoundAndRaceYear(round, year);
        var resultsList = resultsRepository.findRaceResultsByRaceId(raceList.getRaceId());
        resultsList.forEach(result -> {
            var driver = driverRepository.getDriverByDriverId(Long.valueOf(result.getDriverId()));
            driver.ifPresent(driverList::add);
        });
        return driverList;    }

    @Override
    public DriverResponse getDriverBySurname(String name) throws Exception {
       var driver = driverRepository.getDriverBySurname(name);
       if (driver.isPresent()) {
           return mapToDriverResponse(driver.get());
       } else {
           throw new Exception("invalid name provided.");
       }
    }

    @Override
    public DriverResponse createNewDriver(CreateDriver payload) {
//        var existingDriverCount = driverRepository.count();
        var newDriver = Driver.builder()
//                .driverId(BigInteger.valueOf(existingDriverCount++))
                .driverRef(payload.getDriverRef())
                .raceNumber(payload.getRaceNumber())
                .surname(payload.getSurname())
                .url(payload.getUrl())
                .name(payload.getName())
                .birthDate(payload.getBirthDate())
                .code(payload.getCode())
                .nationality(payload.getNationality())
                .build();
        try {
            driverRepository.save(newDriver);
        } catch (Exception e) {
            log.info("Sql exception caught on create driver at " + LocalDateTime.now());
            throw new RuntimeException("Unable to create driver record");
        }
        return mapToDriverResponse(newDriver);
    }


    private Boolean existsInDriverList(List<Driver> exiistingList, Long driverId) {
        return null;
    }

    private DriverResponse mapToDriverResponse(Driver driver) {
        return DriverResponse.builder()
                .driverRef(driver.getDriverRef())
                .birthDate(driver.getBirthDate())
                .code(driver.getCode())
                .url(driver.getUrl())
                .surname(driver.getSurname())
                .raceNumber(driver.getRaceNumber())
                .nationality(driver.getNationality())
                .name(driver.getName())
                .surname(driver.getSurname())
                .build();
    }
}
