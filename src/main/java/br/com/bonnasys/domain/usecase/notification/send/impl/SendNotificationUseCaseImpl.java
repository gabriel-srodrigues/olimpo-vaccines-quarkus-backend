package br.com.bonnasys.domain.usecase.notification.send.impl;

import br.com.bonnasys.domain.enums.NotificationTemplate;
import br.com.bonnasys.domain.usecase.notification.send.SendNotificationUseCase;
import br.com.bonnasys.domain.usecase.notification.send.NotifyStrategy;
import jakarta.inject.Singleton;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class SendNotificationUseCaseImpl implements SendNotificationUseCase {

    private final Map<NotificationTemplate, NotifyStrategy> strategies;

    public SendNotificationUseCaseImpl() {
        this.strategies = new HashMap<>() {{
            put(NotificationTemplate.WELCOME, new WelcomeNotifyStrategy());
            put(NotificationTemplate.PATIENT_VACCINATED, new PatientVaccinatedNotifyStrategy());
            put(NotificationTemplate.PENDING_ORDER, new PendingOrderNotifyStrategy());
        }};
    }

    @Override
    public void execute(SendNotificationCommand command) {
        NotifyStrategy notifyStrategy = strategies.get(command.template());
        notifyStrategy.send(command);
    }
}
