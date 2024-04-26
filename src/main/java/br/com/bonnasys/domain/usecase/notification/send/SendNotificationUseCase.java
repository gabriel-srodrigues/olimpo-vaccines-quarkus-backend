package br.com.bonnasys.domain.usecase.notification.send;

import br.com.bonnasys.domain.enums.NotificationTemplate;

import java.util.List;
import java.util.Map;

public interface SendNotificationUseCase {

    void execute(SendNotificationCommand sendNotificationCommand);

    record SendNotificationCommand(NotificationTemplate template,
                                   Map<String, Object> params,
                                   List<String> tos,
                                   List<String> replyTos) {
    }
}
