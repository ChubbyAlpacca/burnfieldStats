package com.burnfield.burnfieldstats.transform;

import com.burnfield.burnfieldstats.controller.constructors.dto.ConstructorResponse;
import com.burnfield.burnfieldstats.controller.constructors.dto.ConstructorsMetaData;
import com.burnfield.burnfieldstats.controller.constructors.dto.ConstructorsResponse;
import com.burnfield.burnfieldstats.entity.Constructor;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ConstructorAdapter {

    public static ConstructorResponse mapToConstructorResponse(Constructor constructor) {
        return ConstructorResponse.builder()
                .name(constructor.getName())
                .nationality(constructor.getNationality())
                .url(constructor.getUrl())
                .build();
    }

    public static ConstructorsResponse mapToConstructorsResponsePaginated(Page<Constructor> constructors, ConstructorsMetaData metaData) {
        ArrayList<ConstructorResponse> constructorResponseList = new ArrayList<>();
        constructors.forEach(constructor -> {
            var constructorResponse = mapToConstructorResponse(constructor);
            constructorResponseList.add(constructorResponse);
        });
        return ConstructorsResponse.builder().metaData(metaData).constructors(constructorResponseList).build();
    }

    public static ConstructorsResponse mapToConstructorsResponse(List<Constructor> constructors, ConstructorsMetaData metaData) {
        ArrayList<ConstructorResponse> constructorResponseList = new ArrayList<>();
        constructors.forEach(constructor -> {
            var constructorResponse = mapToConstructorResponse(constructor);
            constructorResponseList.add(constructorResponse);
        });
        return ConstructorsResponse.builder().metaData(metaData).constructors(constructorResponseList).build();
    }


    public static ConstructorsMetaData constructorsMetaDataBuilder(Optional<Integer> page, Optional<Integer> limit, Optional<Integer> totalSize, Optional<Integer> year, Optional<Integer> round) {
        return ConstructorsMetaData.builder()
                .page(page)
                .limit(limit)
                .totalSize(totalSize)
                .year(year)
                .round(round)
                .build();
    }

}
