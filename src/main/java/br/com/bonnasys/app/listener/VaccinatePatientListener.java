package br.com.bonnasys.app.listener;

import br.com.bonnasys.domain.usecase.create.CreateVaccineUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import java.io.IOException;

@Slf4j
@ApplicationScoped
@AllArgsConstructor
public class VaccinatePatientListener {
    private static int count = 0;
    private final CreateVaccineUseCase createVaccineUseCase;

    @Incoming("vaccinate-patient")
    public void onVaccinatePatient(final byte[] array) throws IOException {
        Message aRequest = new ObjectMapper().readValue(array, Message.class);
        count++;
        log.info("""
                /                                                 %d
                =====================================================
                NOVA SOLICITAÇÃO DE VACINAÇÃO:             21/03/2024
                =====================================================
                PACIENTE: %s
                =====================================================
                VACINA: %s
                =====================================================
                CENTRO DE SAÚDE: %s
                =====================================================
                """.formatted(
                count,
                aRequest.patientName(),
                aRequest.vaccineName(),
                aRequest.healthCenterName()));
    }

    public record Message(String patientName, String vaccineName, String healthCenterName) {
    }

}
