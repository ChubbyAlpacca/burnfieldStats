package com.burnfield.burnfieldstats.controller.constructors.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_NULL)
public class ConstructorsResponse {

    //TODO add metadata with pagination

    List<ConstructorResponse> constructors;
}
