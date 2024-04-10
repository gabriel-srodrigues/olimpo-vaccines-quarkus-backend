package br.com.bonnasys.domain.usecase.create.impl;

import br.com.bonnasys.domain.model.Vaccine;
import br.com.bonnasys.domain.repository.VaccineRepository;
import br.com.bonnasys.domain.usecase.create.CreateVaccineCommand;
import br.com.bonnasys.domain.usecase.create.CreateVaccineUseCase;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Singleton
@AllArgsConstructor
public class CreateVaccineUseCaseImpl implements CreateVaccineUseCase {
    private final VaccineRepository vaccineRepository;

    @Override
    @Transactional
    public Vaccine execute(CreateVaccineCommand command) {
        Vaccine vaccine = Vaccine.newVaccine(command.name(), command.producer());
        vaccineRepository.persist(vaccine);
        return vaccine;
    }
}
