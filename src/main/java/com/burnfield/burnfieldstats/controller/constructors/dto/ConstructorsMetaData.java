package com.burnfield.burnfieldstats.controller.constructors.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
@Builder
@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_NULL)
public class ConstructorsMetaData {

    private Optional<Integer> year;

    private Optional<Integer> round;

    private Optional<Integer> page;

    private Optional<Integer> limit;

    private Optional<Integer> totalSize;

}
