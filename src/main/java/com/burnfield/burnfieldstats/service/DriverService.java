package com.burnfield.burnfieldstats.service;

import com.burnfield.burnfieldstats.entity.Driver;
import com.burnfield.burnfieldstats.repository.DriverRepository;

import java.util.List;

public interface DriverService {
    List<Driver> getAllDrivers();

}
