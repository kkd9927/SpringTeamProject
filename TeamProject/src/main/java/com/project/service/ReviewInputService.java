package com.project.service;

import com.project.domain.ReviewInputDTO;

public interface ReviewInputService {
    ReviewInputDTO getReviewInput(int oNum);
    void insertReview(ReviewInputDTO reviewInput);
    void insertReviewImage(ReviewInputDTO reviewInput);
    void updateReview(ReviewInputDTO reviewInput);
    void updateReviewImage(ReviewInputDTO reviewInput);
    void deleteReview(int oNum);
    void deleteReviewImage(int oNum);
}