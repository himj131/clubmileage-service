package com.himj.clubmileage.review.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Review {
    private UUID userId;
    private UUID placeId;
    private List<String> attatchedPhotoIds;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
