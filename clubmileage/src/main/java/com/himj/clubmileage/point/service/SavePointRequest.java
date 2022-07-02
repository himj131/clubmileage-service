package com.himj.clubmileage.point.service;

import com.himj.clubmileage.point.domain.ActionType;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class SavePointRequest {
    private UUID userId;
    private UUID placeId;
    private ActionType action;
}
