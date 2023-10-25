package com.burnfield.burnfieldstats.service;

import com.burnfield.burnfieldstats.controller.circuits.dto.CircuitResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CircuitService {

    List<CircuitResponse> getCircuitByCountry(String country);

    List<CircuitResponse> getAllCircuits();
}
