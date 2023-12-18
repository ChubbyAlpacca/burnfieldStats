package com.burnfield.burnfieldstats.controller.drivers;

import com.burnfield.burnfieldstats.controller.circuits.dto.PageMetaData;
import com.burnfield.burnfieldstats.controller.drivers.dto.DriversReponse;
import com.burnfield.burnfieldstats.service.DriverService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
public class DriversController {

    private final DriverService driverService;

    //get all (paginated)
    @GetMapping("/drivers")
    public ResponseEntity<DriversReponse> getAllCircuit(
            @RequestParam Optional<Integer> limit,
            @RequestParam Optional<Integer> page) {
        var responseBody = driverService.getAllDrivers();
        DriversReponse response = new DriversReponse();
        response.setMetaData(getPageMetaData(limit, page, responseBody.size()));
        response.setDriverList(responseBody.subList(0, limit.orElse(25)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    //get drivers by year

    //get by round && race

    //get by driver id
    private PageMetaData getPageMetaData(Optional<Integer> limit, Optional<Integer> page, int items) {
        return PageMetaData.builder().page(page.orElse(1)).limit(limit.orElse(25)).totalItems(items).build();
    }
}
