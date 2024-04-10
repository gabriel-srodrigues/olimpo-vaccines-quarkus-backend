package br.com.bonnasys.app.rest.controller;

import br.com.bonnasys.app.mapper.VaccineMapper;
import br.com.bonnasys.app.rest.VaccineApi;
import br.com.bonnasys.app.rest.request.CreateVaccineRequest;
import br.com.bonnasys.app.rest.response.VaccineResponse;
import br.com.bonnasys.domain.model.Vaccine;
import br.com.bonnasys.domain.usecase.VaccineFacade;
import br.com.bonnasys.domain.usecase.create.CreateVaccineCommand;
import io.quarkus.arc.All;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;

@ApplicationScoped
@AllArgsConstructor
public class VaccineController implements VaccineApi {
    private final VaccineFacade vaccineFacade;
    private final VaccineMapper vaccineMapper;

    @Override
    public Response create(CreateVaccineRequest request) {
        CreateVaccineCommand command = new CreateVaccineCommand(request.name(), request.producer());
        Vaccine actualVaccine = vaccineFacade.createVaccineUseCase(command);
        return Response.status(201)
                .entity(actualVaccine)
                .header("Location", "/vaccines/" + actualVaccine.getId())
                .build();
    }

    @Override
    public Response search() {
        return null;
    }

    @Override
    public Response getById(String id) {
        Vaccine actualVaccine = vaccineFacade.getVaccineUseCase(id);
        VaccineResponse response = vaccineMapper.domainObjectToResponse(actualVaccine);
        return Response.ok(response).build();
    }

    @Override
    public Response delete(String id) {
        vaccineFacade.deleteVaccineUseCase(id);
        return Response.noContent().build();
    }
}
