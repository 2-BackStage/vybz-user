package back.vybz.userservice.busker.application.scheduler;

import back.vybz.userservice.busker.domain.mysql.BuskerInfo;
import back.vybz.userservice.busker.infrastructure.BuskerInfoRepository;
import back.vybz.userservice.common.util.AmazonS3UploaderUtil;
import back.vybz.userservice.user.domain.mysql.UserInfo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class BuskerProfileImageScheduler {

    private final BuskerInfoRepository buskerInfoRepository;
    private final AmazonS3UploaderUtil amazonS3UploaderUtil;

    @Transactional
    @Scheduled(fixedRate = 30000)
    public void cleanUpDeletedProfileImages() {
        List<BuskerInfo> deletedUserWithImage = buskerInfoRepository.findAllByDeletedTrueAndProfileImageUrlIsNotNull();

        log.info("[SCHEDULER] 버스커 프로필 이미지 삭제 대상 유저 수: {}", deletedUserWithImage.size());

        for (BuskerInfo busker : deletedUserWithImage) {
            try {
                amazonS3UploaderUtil.delete(busker.getProfileImageUrl());
                busker.clearProfileImageUrl(); // DB에서도 null 처리
                log.info("S3 이미지 삭제 완료 - {}", busker.getUserUuid());
            } catch (Exception e) {
                log.warn("S3 이미지 삭제 실패 - {} / {}", busker.getUserUuid(), e.getMessage());
            }
        }
    }

}
