package com.burnfield.burnfieldstats.controller.constructors;

import com.burnfield.burnfieldstats.controller.circuits.dto.CircuitsResponse;
import com.burnfield.burnfieldstats.controller.constructors.dto.ConstructorResponse;
import com.burnfield.burnfieldstats.controller.constructors.dto.ConstructorsResponse;
import com.burnfield.burnfieldstats.entity.Constructor;
import com.burnfield.burnfieldstats.repository.ConstructorRepository;
import com.burnfield.burnfieldstats.service.ConstructorService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/constructors")
public class ConstructorController {
    private static final int PAGE = 1;

    private static final int LIMIT = 20;

    private final ConstructorService constructorService;

    @GetMapping()
    public ResponseEntity<ConstructorsResponse> getAllConstructors(@Parameter Optional<Integer> page, @Parameter Optional<Integer> limit) {
        var body = constructorService.getAllConstructors(page.orElse(PAGE), limit.orElse(LIMIT));
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<ConstructorResponse> getConstructorByName(@Parameter String name) {
        var body = constructorService.getConstructorByName(name);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @GetMapping("/{year}")
    public ResponseEntity<ConstructorsResponse> getConstructorByRoundAndYear(@Parameter Optional<Integer> round, @PathVariable int year) {
        var body = constructorService.getConstructorsByRoundAndYear(round, year);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }


}
