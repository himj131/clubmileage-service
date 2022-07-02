package com.himj.clubmileage.point.service;

import com.himj.clubmileage.point.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserPointService {
    private UserPointRepository userPointRepository;
    private PointHistoryService pointHistoryService;


    public UserPointService(UserPointRepository userPointRepository, PointHistoryService pointHistoryService) {
        this.userPointRepository = userPointRepository;
        this.pointHistoryService = pointHistoryService;
    }

    public void savePoint(PointType pointType, SavePointRequest request) {
        Optional<UserPoint> userPoint = userPointRepository.findById(request.getUserId());
        userPoint.ifPresentOrElse(it -> {
                    it.updateSavePoint(pointType);
                },
                () -> {
                    UserPoint userpoint = UserPoint.builder()
                            .userId(request.getUserId())
                            .totalSavedPoint(pointType.getPoint())
                            .totalRemainPoint(pointType.getPoint())
                            .totalUsedPoint(0)
                            .createdAt(LocalDateTime.now())
                            .build();
                    userPointRepository.save(userpoint);
                });

        PointHistoryRequest historyReq = createSavePointHistoryReq(pointType, ActionType.ADD, request);
        pointHistoryService.savePointHistory(historyReq);

    }

    private PointHistoryRequest createSavePointHistoryReq(PointType pointType, ActionType actionType, SavePointRequest request) {
        return PointHistoryRequest.builder()
                .point(pointType.getPoint())
                .pointType(pointType)
                .saveType(SaveType.SAVE)
                .actionType(actionType)
                .userId(request.getUserId())
                .placeId(request.getPlaceId())
                .createdAt(LocalDateTime.now())
                .build();
    }


}
