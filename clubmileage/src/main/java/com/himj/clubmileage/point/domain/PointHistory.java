package com.himj.clubmileage.point.domain;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public class PointHistory {
    private Long id;
    private SaveType saveType;
    private PointType pointType;
    private ActionType actionType;
    private UUID userId;
    private UUID placeId;
    private Integer point;
    private LocalDateTime createdAt;
}
