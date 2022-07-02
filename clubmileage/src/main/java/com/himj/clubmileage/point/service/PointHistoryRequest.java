package com.himj.clubmileage.point.service;

import com.himj.clubmileage.point.domain.ActionType;
import com.himj.clubmileage.point.domain.PointType;
import com.himj.clubmileage.point.domain.SaveType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
public class PointHistoryRequest {
    private SaveType saveType;
    private PointType pointType;
    private ActionType actionType;
    private UUID userId;
    private UUID placeId;
    private Integer point;
    private LocalDateTime createdAt;
}
