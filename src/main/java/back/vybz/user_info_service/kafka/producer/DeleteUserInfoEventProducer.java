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
public class DeleteUserInfoEventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "delete-user-info";

    public void sendUserInfoEvent(String userUuid) {
        log.info("[Kafka] Sending DeleteFollowEvent to topic '{}': {}", TOPIC, userUuid);
        CompletableFuture<SendResult<String, String>> future =
                kafkaTemplate.send(TOPIC, userUuid);

        future.whenComplete((result, ex) -> {
            if (ex != null) {
                log.error("[Kafka] Failed to send DeleteUserInfoEvent: {}", ex.getMessage(), ex);
            } else {
                log.info("[Kafka] Successfully sent DeleteUserInfoEvent with offset: {}", result.getRecordMetadata().offset());
            }
        });
    }

}
