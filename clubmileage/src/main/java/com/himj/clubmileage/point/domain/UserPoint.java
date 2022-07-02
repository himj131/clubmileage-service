package com.himj.clubmileage.point.domain;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public class UserPoint {
    private UUID userId;
    private Integer totalSavedPoint;
    private Integer totalUsedPoint;
    private Integer totalRemainPoint;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserPoint updateSavePoint(PointType pointType) {
        this.totalSavedPoint = totalSavedPoint + pointType.getPoint();
        this.totalRemainPoint = totalRemainPoint + pointType.getPoint();
        this.updatedAt = LocalDateTime.now();
        return this;
    }
}
