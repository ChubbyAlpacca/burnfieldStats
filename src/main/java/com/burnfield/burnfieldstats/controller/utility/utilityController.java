package com.burnfield.burnfieldstats.controller.utility;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class utilityController {
    @GetMapping("/ping")
    public ResponseEntity<String> getPing() {
        log.info("Ping is alive!");
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }
}
