package com.burnfield.burnfieldstats.service.Impl;

import com.burnfield.burnfieldstats.controller.circuits.dto.CircuitResponse;
import com.burnfield.burnfieldstats.controller.circuits.dto.Location;
import com.burnfield.burnfieldstats.entity.Circuit;
import com.burnfield.burnfieldstats.repository.CircuitRepository;
import com.burnfield.burnfieldstats.service.CircuitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CircuitServiceImpl implements CircuitService {

    private final CircuitRepository circuitRepository;
    @Override
    public List<CircuitResponse> getCircuitByCountry(String country) {
        var circuitList = circuitRepository.findCircuitsByCountry(country);
        return mapToCircuitResponse(circuitList);
    }

    @Override
    public List<CircuitResponse> getAllCircuits() {
        var circuitList = circuitRepository.findAll();
        return mapToCircuitResponse(circuitList);
    }


    private List<CircuitResponse> mapToCircuitResponse(List<Circuit> circuits) {
        List<CircuitResponse> responseList = new ArrayList<>();
        circuits.forEach(circuit -> {
            var location = Location.builder().location(circuit.getLocation()).country(circuit.getCountry()).longtitude(circuit.getLng()).latitude(circuit.getLat()).build();
            var circuitResponse = CircuitResponse.builder().name(circuit.getName()).location(location).url(circuit.getUrl()).build();
            responseList.add(circuitResponse);
        });
        return responseList;
    }
}
