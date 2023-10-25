package com.burnfield.burnfieldstats.controller.circuits;

import com.burnfield.burnfieldstats.controller.circuits.dto.CircuitResponse;
import com.burnfield.burnfieldstats.controller.circuits.dto.CircuitsResponse;
import com.burnfield.burnfieldstats.controller.circuits.dto.PageMetaData;
import com.burnfield.burnfieldstats.entity.Circuit;
import com.burnfield.burnfieldstats.repository.CircuitRepository;
import com.burnfield.burnfieldstats.service.CircuitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Controller
public class CircuitController {

    private final CircuitService circuitService;

    @GetMapping("/circuits/{country}")
    public ResponseEntity<List<CircuitResponse>> getCircuitsByCountry(
             @PathVariable String country) {
        var responseBody = circuitService.getCircuitByCountry(country);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @GetMapping("/circuits")
    public ResponseEntity<CircuitsResponse> getAllCircuit(
            @RequestParam Optional<Integer> limit,
            @RequestParam Optional<Integer> page) {
        var responseBody = circuitService.getAllCircuits();
        CircuitsResponse response = new CircuitsResponse();
        response.setMetaData(getPageMetaData(limit, page, responseBody.size()));
        response.setCircuits(responseBody.subList(0, limit.orElse(25)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private PageMetaData getPageMetaData(Optional<Integer> limit, Optional<Integer> page, int items) {
       return PageMetaData.builder().page(page.orElse(1)).limit(limit.orElse(25)).totalItems(items).build();
    }


}
