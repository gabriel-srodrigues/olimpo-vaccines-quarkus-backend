package br.com.bonnasys.domain.usecase.delete;

import br.com.bonnasys.domain.model.Vaccine;
import br.com.bonnasys.domain.repository.VaccineRepository;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Singleton
@AllArgsConstructor
public class DeleteVaccineUseCaseImpl implements DeleteVaccineUseCase {
    private final VaccineRepository vaccineRepository;

    @Override
    @Transactional
    public void execute(String id) {
        Vaccine vaccine = vaccineRepository.findById(id);
        if (vaccine == null) {
            throw new RuntimeException("Vaccine with id " + id + " not found");
        }
        vaccineRepository.delete(vaccine);
    }
}
