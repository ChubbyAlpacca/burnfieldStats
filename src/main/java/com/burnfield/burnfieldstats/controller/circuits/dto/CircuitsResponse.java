package com.burnfield.burnfieldstats.controller.circuits.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_NULL)
public class CircuitsResponse {

    private PageMetaData metaData;

    private List<CircuitResponse> circuits;

}
