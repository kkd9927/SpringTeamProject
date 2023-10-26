package com.project.service;

import com.project.domain.ReviewImageDTO;

public interface ReviewImageService {
    void insertReviewImage(ReviewImageDTO reviewImage);
    void updateReviewImage(ReviewImageDTO reviewImage);
    void deleteReviewImage(int oNum);
}
