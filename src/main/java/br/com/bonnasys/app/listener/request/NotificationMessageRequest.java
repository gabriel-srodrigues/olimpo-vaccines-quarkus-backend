package br.com.bonnasys.app.listener.request;

import br.com.bonnasys.domain.enums.NotificationTemplate;

import java.util.List;
import java.util.Map;

public record NotificationMessageRequest(NotificationTemplate template,
                                         Map<String, Object> params,
                                         List<String> tos,
                                         List<String> replyTos) {
}




