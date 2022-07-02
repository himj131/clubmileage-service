package com.himj.clubmileage.review.service;

import com.himj.clubmileage.point.domain.ActionType;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class ReviewEventRequest {
    private ActionType action;
    private UUID reviewId;
    private String content;
    private List<UUID> attachedPotoIds;
    private UUID userId;
    private UUID placeId;


    public boolean existsContent() {
        return !content.isEmpty();
    }

    public boolean existsPhoto() {
        return !attachedPotoIds.isEmpty();
    }
}
