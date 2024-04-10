package br.com.bonnasys.domain.usecase.retrieve.get;

import br.com.bonnasys.domain.model.Vaccine;
import br.com.bonnasys.domain.repository.VaccineRepository;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;

@Singleton
@AllArgsConstructor
public class GetVaccineUseCaseImpl implements GetVaccineUseCase {
    private final VaccineRepository vaccineRepository;

    @Override
    public Vaccine execute(String id) {
        Vaccine vaccine = vaccineRepository.findById(id);
        if (vaccine == null) {
            throw new RuntimeException("Vaccine with id " + id + " not found");
        }
        return vaccine;
    }
}
