package br.com.bonnasys.app.mapper;

import br.com.bonnasys.app.rest.response.VaccineResponse;
import br.com.bonnasys.domain.model.Vaccine;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VaccineMapper {
    VaccineMapper INSTANCE = Mappers.getMapper(VaccineMapper.class);

    VaccineResponse domainObjectToResponse(Vaccine vaccine);
}
