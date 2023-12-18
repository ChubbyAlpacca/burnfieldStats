package com.burnfield.burnfieldstats.controller.drivers.dto;

import com.burnfield.burnfieldstats.controller.circuits.dto.PageMetaData;
import com.burnfield.burnfieldstats.entity.Driver;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_NULL)
public class DriversReponse {

    private PageMetaData metaData;

    private List<Driver> driverList;

    public DriversReponse() {

    }
}
