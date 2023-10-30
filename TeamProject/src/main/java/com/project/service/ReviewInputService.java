package com.project.service;

import com.project.domain.ReviewInputDTO;

public interface ReviewInputService {
    ReviewInputDTO getReviewInput(int o_num);
    void insertReview(ReviewInputDTO reviewInput);
    void insertReviewImage(ReviewInputDTO reviewInput);
    void updateReview(ReviewInputDTO reviewInput);
    void updateReviewImage(ReviewInputDTO reviewInput);
    void deleteReview(int o_num);
    void deleteReviewImage(int o_num);
}
