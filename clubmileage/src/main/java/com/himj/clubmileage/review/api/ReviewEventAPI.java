package com.himj.clubmileage.review.api;

import com.himj.clubmileage.review.service.ReviewEventRequest;
import com.himj.clubmileage.review.service.ReviewEventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewEventAPI {
    private ReviewEventService service;

    public ReviewEventAPI(ReviewEventService service) {
        this.service = service;
    }

    @PostMapping("/events")
    public ResponseEntity publishEvents(@RequestBody ReviewEventRequest req) {
        service.publishEvent(req);
        return ResponseEntity.ok().build();
    }
}
