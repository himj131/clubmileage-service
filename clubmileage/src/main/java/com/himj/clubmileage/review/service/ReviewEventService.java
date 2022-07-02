package com.himj.clubmileage.review.service;

import com.himj.clubmileage.point.domain.ActionType;
import com.himj.clubmileage.point.domain.PointType;
import com.himj.clubmileage.point.service.SavePointRequest;
import com.himj.clubmileage.point.service.UserPointService;
import com.himj.clubmileage.review.domain.Review;
import com.himj.clubmileage.review.domain.ReviewRepository;
import com.himj.clubmileage.review.service.ReviewEventRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class ReviewEventService {
    private ReviewRepository reviewRepository;
    private UserPointService userPointService;

    public ReviewEventService(ReviewRepository reviewRepository, UserPointService userPointService) {
        this.reviewRepository = reviewRepository;
        this.userPointService = userPointService;
    }

    @Transactional
    public void publishEvent(ReviewEventRequest req) {
        ActionType action = req.getAction();
        if(action == ActionType.ADD) {
            addReview(req);
        }
    }


    private void addReview(ReviewEventRequest req) {
        SavePointRequest savePointReq = createSavePointReq(req);

        if(firstPlaceReview(req.getPlaceId())){
            userPointService.savePoint(PointType.FIRST_REVIEW, savePointReq);
        }
        if(req.existsContent()) userPointService.savePoint(PointType.NORMAL, savePointReq);
        if(req.existsPhoto()) userPointService.savePoint(PointType.NORMAL, savePointReq);


    }

    private boolean firstPlaceReview(UUID placeId) {
        Optional<Review> existsPlaceReview = reviewRepository.existsByPlaceId(placeId);
        return existsPlaceReview.isPresent();
    }

    private SavePointRequest createSavePointReq(ReviewEventRequest req) {
        return SavePointRequest.builder()
                .userId(req.getUserId())
                .placeId(req.getPlaceId())
                .action(ActionType.ADD)
                .build();
    }
}
