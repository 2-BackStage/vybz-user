package back.vybz.user_info_service.user_info.application.scheduler;

import back.vybz.user_info_service.common.util.AmazonS3UploaderUtil;
import back.vybz.user_info_service.user_info.domain.UserInfo;
import back.vybz.user_info_service.user_info.infrastructure.UserInfoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserProfileImageScheduler {

    private final UserInfoRepository userInfoRepository;
    private final AmazonS3UploaderUtil amazonS3UploaderUtil;

    @Transactional
    @Scheduled(fixedRate = 30000)
    public void cleanUpDeletedProfileImages() {
        List<UserInfo> deletedUserWithImage = userInfoRepository.findAllByDeletedTrueAndProfileImageUrlIsNotNull();

        log.info("[SCHEDULER] 유저 프로필 이미지 삭제 대상 유저 수: {}", deletedUserWithImage.size());

        for (UserInfo user : deletedUserWithImage) {
            try {
                amazonS3UploaderUtil.delete(user.getProfileImageUrl());
                user.clearProfileImageUrl(); // DB에서도 null 처리
                log.info("S3 이미지 삭제 완료 - {}", user.getUserUuid());
            } catch (Exception e) {
                log.warn("S3 이미지 삭제 실패 - {} / {}", user.getUserUuid(), e.getMessage());
            }
        }
    }

}
