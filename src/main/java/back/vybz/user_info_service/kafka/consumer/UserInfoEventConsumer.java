package back.vybz.user_info_service.kafka.consumer;

import back.vybz.user_info_service.common.entity.BaseResponseStatus;
import back.vybz.user_info_service.common.exception.BaseException;
import back.vybz.user_info_service.kafka.event.UserInfoEvent;
import back.vybz.user_info_service.user_info.domain.UserInfo;
import back.vybz.user_info_service.user_info.infrastructure.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserInfoEventConsumer {

    private final UserInfoRepository userInfoRepository;

    @KafkaListener(
            topics = "create-user-auth-1",
            groupId = "user-info-group",
            containerFactory = "userInfoKafkaListenerContainerFactory"
    )
    public void consumeUserInfoEvent(UserInfoEvent userInfoEvent) {
        log.info("🔥 Kafka 유저 정보 메시지 수신: {}", userInfoEvent);

        boolean exists = userInfoRepository.existsByUserUuid(userInfoEvent.getUserUuid());
        if (exists) {
            log.warn("🔥 유저 정보가 이미 존재합니다. userUuid: {}", userInfoEvent.getUserUuid());
            throw new BaseException(BaseResponseStatus.DUPLICATE_USER);
        }

        UserInfo userInfo = userInfoRepository.findByUserUuidAndDeletedFalse(userInfoEvent.getUserUuid())
                .orElse(UserInfo.builder()
                        .userUuid(userInfoEvent.getUserUuid())
                        .nickname(userInfoEvent.getNickname())
                        .profileImageUrl(userInfoEvent.getProfileImageUrl())
                        .build());
        userInfoRepository.save(userInfo);
        log.info("🔥 유저 정보 저장 완료: {}", userInfo);
    }

}
