package br.com.bonnasys.app.listener;

import br.com.bonnasys.app.rest.request.CreateVaccineRequest;
import br.com.bonnasys.domain.usecase.create.CreateVaccineCommand;
import br.com.bonnasys.domain.usecase.create.CreateVaccineUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.smallrye.reactive.messaging.annotations.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@Slf4j
@ApplicationScoped
@AllArgsConstructor
public class CreateVaccineListener {
    private final CreateVaccineUseCase createVaccineUseCase;

    @Blocking
    @Incoming("create-vaccines")
    public void onCreateVaccine(final byte[] array) throws JsonProcessingException {
        String message = new String(array);
        log.info("[onCreateVaccine]: recebendo registro: {}", message);
        CreateVaccineRequest aRequest = new ObjectMapper().readValue(message, CreateVaccineRequest.class);
        CreateVaccineCommand command = new CreateVaccineCommand(aRequest.name(), aRequest.producer());
        createVaccineUseCase.execute(command);
    }

}
