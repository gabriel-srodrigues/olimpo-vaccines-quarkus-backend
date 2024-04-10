package br.com.bonnasys.infrastructure.configuration;

import br.com.bonnasys.app.mapper.VaccineMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class MapStructConfiguration {


    @Produces
    public VaccineMapper vaccineMapper() {
        log.info("[vaccineMapper]: starting vaccine mapper");
        return VaccineMapper.INSTANCE;
    }
}
