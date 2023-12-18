package com.burnfield.burnfieldstats.service.Impl;

import com.burnfield.burnfieldstats.entity.Driver;
import com.burnfield.burnfieldstats.repository.DriverRepository;
import com.burnfield.burnfieldstats.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }
}
