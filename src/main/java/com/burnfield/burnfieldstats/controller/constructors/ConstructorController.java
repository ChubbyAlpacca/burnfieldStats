package com.burnfield.burnfieldstats.controller.constructors;

import com.burnfield.burnfieldstats.controller.circuits.dto.CircuitsResponse;
import com.burnfield.burnfieldstats.controller.constructors.dto.ConstructorResponse;
import com.burnfield.burnfieldstats.controller.constructors.dto.ConstructorsResponse;
import com.burnfield.burnfieldstats.repository.ConstructorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Slf4j
@RequiredArgsConstructor
@Controller
public class ConstructorController {

    private final ConstructorRepository constructorRepository;

    @GetMapping("/constructors")
    public ResponseEntity<ConstructorsResponse> getAllCircuit(
    ) {
        var constructorList = constructorRepository.findAll();
        ArrayList teamList = new ArrayList();
        constructorList.forEach(constructor -> {
            var item =
            ConstructorResponse.builder()
                    .name(constructor.getName())
                    .nationality(constructor.getNationality())
                    .url(constructor.getUrl())
                    .build();

            teamList.add(item);
        });

        ConstructorsResponse response = new ConstructorsResponse(teamList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
