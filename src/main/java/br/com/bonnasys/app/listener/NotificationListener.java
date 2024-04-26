package br.com.bonnasys.app.listener;

import br.com.bonnasys.domain.usecase.NotificationFacade;
import br.com.bonnasys.domain.usecase.notification.send.SendNotificationUseCase;
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
public class NotificationListener {
    private final ObjectMapper mapper;
    private final NotificationFacade notificationFacade;

    @Blocking
    @Incoming("notification")
    public void onNotification(byte[] array) throws JsonProcessingException {
        String messageAsString = new String(array);
        var message = mapper.readValue(messageAsString, SendNotificationUseCase.SendNotificationCommand.class);
        notificationFacade.sendNotificationUseCase(message);
    }
}
