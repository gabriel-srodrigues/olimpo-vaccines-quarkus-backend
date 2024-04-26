package br.com.bonnasys.domain.usecase.notification.send.impl;

import br.com.bonnasys.domain.usecase.notification.send.NotifyStrategy;
import br.com.bonnasys.domain.usecase.notification.send.SendNotificationUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class WelcomeNotifyStrategy implements NotifyStrategy {

    @Override
    public void send(SendNotificationUseCase.SendNotificationCommand command) {
        log.info("[welcome] sending notification: {}", command);
    }
}
