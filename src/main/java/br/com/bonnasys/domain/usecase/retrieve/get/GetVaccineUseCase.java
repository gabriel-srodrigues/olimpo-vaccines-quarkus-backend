package br.com.bonnasys.domain.usecase.retrieve.get;


import br.com.bonnasys.domain.model.Vaccine;

public interface GetVaccineUseCase {
    Vaccine execute(String id);
}
