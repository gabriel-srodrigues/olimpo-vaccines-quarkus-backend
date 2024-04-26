package br.com.bonnasys.domain.usecase;

import br.com.bonnasys.domain.usecase.notification.send.SendNotificationUseCase;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;

@Singleton
@AllArgsConstructor
public class NotificationFacade {

    private final SendNotificationUseCase sendNotificationUseCase;

    public void sendNotificationUseCase(SendNotificationUseCase.SendNotificationCommand command) {
        sendNotificationUseCase.execute(command);
    }
}
