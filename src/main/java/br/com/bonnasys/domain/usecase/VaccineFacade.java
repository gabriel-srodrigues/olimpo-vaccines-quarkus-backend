package br.com.bonnasys.domain.usecase;

import br.com.bonnasys.domain.model.Vaccine;
import br.com.bonnasys.domain.usecase.create.CreateVaccineCommand;
import br.com.bonnasys.domain.usecase.create.CreateVaccineUseCase;
import br.com.bonnasys.domain.usecase.delete.DeleteVaccineUseCase;
import br.com.bonnasys.domain.usecase.retrieve.get.GetVaccineUseCase;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;

@Singleton
@AllArgsConstructor
public class VaccineFacade {
    private final CreateVaccineUseCase createVaccineUseCase;
    private final GetVaccineUseCase getVaccineUseCase;
    private final DeleteVaccineUseCase deleteVaccineUseCase;


    public Vaccine createVaccineUseCase(CreateVaccineCommand command) {
        return createVaccineUseCase.execute(command);
    }

    public Vaccine getVaccineUseCase(String id) {
        return getVaccineUseCase.execute(id);
    }

    public void deleteVaccineUseCase(String id) {
        deleteVaccineUseCase.execute(id);
    }
}
