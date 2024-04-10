package br.com.bonnasys.domain.usecase.create;


import br.com.bonnasys.domain.model.Vaccine;

public interface CreateVaccineUseCase {

    Vaccine execute(CreateVaccineCommand command);
}
