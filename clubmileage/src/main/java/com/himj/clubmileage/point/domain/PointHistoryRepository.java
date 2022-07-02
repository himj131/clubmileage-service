package com.himj.clubmileage.point.domain;

import org.springframework.data.repository.Repository;

public interface PointHistoryRepository extends Repository<PointHistory, Long> {
    PointHistory save(PointHistory pointHistory);
}
