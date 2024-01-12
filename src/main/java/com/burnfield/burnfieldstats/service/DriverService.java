package com.burnfield.burnfieldstats.service;

import com.burnfield.burnfieldstats.controller.drivers.dto.CreateDriver;
import com.burnfield.burnfieldstats.controller.drivers.dto.DriverResponse;
import com.burnfield.burnfieldstats.entity.Driver;
import com.burnfield.burnfieldstats.repository.DriverRepository;

import java.util.List;
import java.util.Optional;

public interface DriverService {
    List<Driver> getAllDrivers();

    List<Driver> getDriversByYear(int year);

    List<Driver> getDriversByYearAndRound(int year, int round);

    DriverResponse getDriverBySurname(String name) throws Exception;

    DriverResponse createNewDriver(CreateDriver payload);
}
