package com.himj.clubmileage.review.domain;

import com.himj.clubmileage.review.domain.Review;
import org.springframework.data.repository.Repository;

import java.util.Optional;
import java.util.UUID;

public interface ReviewRepository extends Repository {
    Optional<Review> findByUserIdAndPlaceId(UUID userId, UUID placeId);
    Optional<Review> existsByPlaceId(UUID placeId);
}
