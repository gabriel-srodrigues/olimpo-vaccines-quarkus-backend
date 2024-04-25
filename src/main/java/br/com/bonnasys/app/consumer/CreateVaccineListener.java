package br.com.bonnasys.app.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.smallrye.reactive.messaging.annotations.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

import java.util.concurrent.CompletionStage;


@Slf4j
@ApplicationScoped
@AllArgsConstructor
public class CreateVaccineListener {
    public static final String LISTENER_ID = "createVaccineListener";
    public static final String PATIENT_LISTENER_ID = "vaccinationPatientListener";

    @Blocking
    @Incoming("create-vaccines")
    public void onCreateVaccine(byte[] message) throws JsonProcessingException {
        log.info(new String(message));
    }


}
