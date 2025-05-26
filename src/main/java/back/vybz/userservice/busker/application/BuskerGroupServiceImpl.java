package back.vybz.userservice.busker.application;

import back.vybz.userservice.busker.domain.mysql.BuskerGroup;
import back.vybz.userservice.busker.dto.request.RequestAddBuskerGroupDto;
import back.vybz.userservice.busker.dto.request.RequestDeleteBuskerGroupDto;
import back.vybz.userservice.busker.dto.request.RequestUpdateBuskerGroupDto;
import back.vybz.userservice.busker.dto.response.ResponseBuskerGroupDto;
import back.vybz.userservice.busker.infrastructure.BuskerGroupRepository;
import back.vybz.userservice.common.entity.BaseResponseStatus;
import back.vybz.userservice.exception.BaseException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuskerGroupServiceImpl implements BuskerGroupService {

    private final BuskerGroupRepository buskerGroupRepository;

    /**
     * 버스커 그룹 멤버 추가
     * @param requestAddBuskerGroupDto
     */
    @Transactional
    @Override
    public void createBuskerGroup(RequestAddBuskerGroupDto requestAddBuskerGroupDto) {
        if(buskerGroupRepository.existsByGroupUuidAndUserUuidAndDeletedFalse(requestAddBuskerGroupDto.getGroupUuid(), requestAddBuskerGroupDto.getUserUuid())) {
            throw new BaseException(BaseResponseStatus.DUPLICATE_BUSKER_MEMBER);
        }
        buskerGroupRepository.save(requestAddBuskerGroupDto.toEntity());
    }

    /**
     * 버스커 그룹에 있는 멤버 조회
     * @param groupUuid
     * @param userUuid
     */
    @Override
    public ResponseBuskerGroupDto getBuskerGroupAndBuskerMember(String groupUuid, String userUuid) {
        BuskerGroup buskerGroup = buskerGroupRepository.findByGroupUuidAndUserUuidAndDeletedFalse(groupUuid, userUuid)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_BUSKER_MEMBER));
        return ResponseBuskerGroupDto.from(buskerGroup);
    }

    /**
     * 버스커 그룹에 속한 멤버 리스트 조회
     * @param groupUuid
     */
    @Override
    public List<ResponseBuskerGroupDto> getBuskerGroupByGroupUuid(String groupUuid) {
        return buskerGroupRepository.findByGroupUuidAndDeletedFalse(groupUuid)
                .stream()
                .map(ResponseBuskerGroupDto::from)
                .toList();
    }

    /**
     * 유저가 속한 버스커 그룹 리스트 조회
     * @param userUuid
     */
    @Override
    public List<ResponseBuskerGroupDto> getBuskerGroupByUserUuid(String userUuid) {
        return buskerGroupRepository.findByUserUuidAndDeletedFalse(userUuid)
                .stream()
                .map(ResponseBuskerGroupDto::from)
                .toList();
    }

    /**
     * 버스커 그룹 멤버 상태 수정
     * @param requestUpdateBuskerGroupDto
     */
    @Transactional
    @Override
    public void updateBuskerGroup(RequestUpdateBuskerGroupDto requestUpdateBuskerGroupDto) {
        BuskerGroup buskerGroup = buskerGroupRepository.findByGroupUuidAndUserUuidAndDeletedFalse(
                requestUpdateBuskerGroupDto.getGroupUuid(), requestUpdateBuskerGroupDto.getUserUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_BUSKER_MEMBER));
        buskerGroup.updateState(requestUpdateBuskerGroupDto.getState());
    }

    /**
     * 버스커 그룹 멤버 삭제
     * @param requestDeleteBuskerGroupDto
     */
    @Transactional
    @Override
    public void deleteBuskerGroup(RequestDeleteBuskerGroupDto requestDeleteBuskerGroupDto) {
        BuskerGroup buskerGroup = buskerGroupRepository.findByGroupUuidAndUserUuidAndDeletedFalse(
                requestDeleteBuskerGroupDto.getGroupUuid(), requestDeleteBuskerGroupDto.getUserUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_BUSKER_MEMBER));
        buskerGroup.softDelete();
    }
}
