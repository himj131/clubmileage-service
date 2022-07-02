package com.himj.clubmileage.point.domain;

import org.springframework.data.repository.Repository;

import java.util.Optional;
import java.util.UUID;

public interface UserPointRepository extends Repository<UserPoint, UUID> {
    UserPoint save(UserPoint userPoint);

    Optional<UserPoint> findById(UUID userId);
}
