package br.com.bonnasys.domain.usecase.notification.send;

public interface NotifyStrategy {

    void send(SendNotificationUseCase.SendNotificationCommand command);
}
