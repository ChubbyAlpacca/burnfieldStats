package com.burnfield.burnfieldstats.controller.drivers;

import com.burnfield.burnfieldstats.controller.circuits.dto.PageMetaData;
import com.burnfield.burnfieldstats.controller.drivers.dto.CreateDriver;
import com.burnfield.burnfieldstats.controller.drivers.dto.DriverResponse;
import com.burnfield.burnfieldstats.controller.drivers.dto.DriversResponse;
import com.burnfield.burnfieldstats.service.DriverService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
public class DriversController {

    private final DriverService driverService;

    //get all (paginated)
    @GetMapping("/drivers")
    public ResponseEntity<DriversResponse> getAllDrivers(
            @RequestParam Optional<Integer> limit,
            @RequestParam Optional<Integer> page) {
        var responseBody = driverService.getAllDrivers();
        DriversResponse response = new DriversResponse();
        response.setMetaData(getPageMetaData(limit, page, responseBody.size()));
        response.setDriverList(responseBody.subList(0, limit.orElse(25)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/drivers/{year}")
    public ResponseEntity<DriversResponse> getDriversByYear(
            @PathVariable int year) {
        DriversResponse response = new DriversResponse();
        var drivers = driverService.getDriversByYear(year);
        response.setDriverList(drivers);
        response.setMetaData(getPageMetaData(Optional.empty(), Optional.empty(), drivers.size()));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //TODO fix get driver by surname
//    @GetMapping("/drivers/{name}")
//    public ResponseEntity<DriverResponse> getDriversBySurname(
//            @PathVariable String name) throws Exception {
//        var response = driverService.getDriverBySurname(name);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
    @GetMapping("/drivers/{year}/{round}")
    public ResponseEntity<DriversResponse> getDriversByYearAndRound(
            @PathVariable int year,
            @PathVariable int round) {
        DriversResponse response = new DriversResponse();
        var drivers = driverService.getDriversByYearAndRound(year, round);
        response.setDriverList(drivers);
        response.setMetaData(getPageMetaData(Optional.empty(), Optional.empty(), drivers.size()));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/drivers")
    public ResponseEntity<DriverResponse> postDrivers(
        @RequestBody CreateDriver data) {
        var response = driverService.createNewDriver(data);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private PageMetaData getPageMetaData(Optional<Integer> limit, Optional<Integer> page, int items) {
        return PageMetaData.builder().page(page.orElse(1)).limit(limit.orElse(25)).totalItems(items).build();
    }

}
