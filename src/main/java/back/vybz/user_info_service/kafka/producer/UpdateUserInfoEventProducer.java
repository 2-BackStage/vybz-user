package back.vybz.user_info_service.kafka.producer;

import back.vybz.user_info_service.kafka.event.UserInfoEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class UpdateUserInfoEventProducer {

    private final KafkaTemplate<String, UserInfoEvent> kafkaTemplate;
    private static final String TOPIC = "update-user-info";

    public void sendUserInfoEvent(UserInfoEvent event) {
        log.info("[Kafka] Sending UpdateUserInfoEvent to topic '{}': {}", TOPIC, event);
        CompletableFuture<SendResult<String, UserInfoEvent>> future =
                kafkaTemplate.send(TOPIC, event);

        future.whenComplete((result, ex) -> {
            if (ex != null) {
                log.error("[Kafka] Failed to send UpdateUserInfoEvent: {}", ex.getMessage(), ex);
            } else {
                log.info("[Kafka] Successfully sent UpdateUserInfoEvent with offset: {}", result.getRecordMetadata().offset());
            }
        });
    }

}
