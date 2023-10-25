package com.burnfield.burnfieldstats.controller.circuits;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class CircuitController {

    @GetMapping("/circuits")
    public ResponseEntity<String> getPing() {
        log.info("circuits is alive!");
        return new ResponseEntity<>("circuits", HttpStatus.I_AM_A_TEAPOT);
    }
}
