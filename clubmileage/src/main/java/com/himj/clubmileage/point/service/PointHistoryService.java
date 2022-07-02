package com.himj.clubmileage.point.service;

import com.himj.clubmileage.point.domain.PointHistory;
import com.himj.clubmileage.point.domain.PointHistoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PointHistoryService {
    private PointHistoryRepository pointHistoryRepository;

    public PointHistoryService(PointHistoryRepository pointHistoryRepository) {
        this.pointHistoryRepository = pointHistoryRepository;
    }

    public void savePointHistory(PointHistoryRequest req) {
        PointHistory pointHistory = PointHistory.builder()
                .userId(req.getUserId())
                .placeId(req.getPlaceId())
                .point(req.getPoint())
                .actionType(req.getActionType())
                .saveType(req.getSaveType())
                .pointType(req.getPointType())
                .createdAt(LocalDateTime.now())
                .build();
        pointHistoryRepository.save(pointHistory);
    }
}
