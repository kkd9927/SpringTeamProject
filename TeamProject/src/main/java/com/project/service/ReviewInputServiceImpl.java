package com.project.service;

import com.project.domain.ReviewInputDTO;
import com.project.mapper.ReviewInputMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewInputServiceImpl implements ReviewInputService {
    private final ReviewInputMapper reviewInputMapper;

    @Autowired
    public ReviewInputServiceImpl(ReviewInputMapper reviewInputMapper) {
        this.reviewInputMapper = reviewInputMapper;
    }

    @Override
    public ReviewInputDTO getReviewInput(int o_num) {
        return reviewInputMapper.getReviewInput(o_num);
    }

    @Override
    public void insertReview(ReviewInputDTO reviewInput) {
        reviewInputMapper.insertReview(reviewInput);
    }

    @Override
    public void insertReviewImage(ReviewInputDTO reviewInput) {
        reviewInputMapper.insertReviewImage(reviewInput);
    }

    @Override
    public void updateReview(ReviewInputDTO reviewInput) {
        reviewInputMapper.updateReview(reviewInput);
    }

    @Override
    public void updateReviewImage(ReviewInputDTO reviewInput) {
        reviewInputMapper.updateReviewImage(reviewInput);
    }

    @Override
    public void deleteReview(int o_num) {
        reviewInputMapper.deleteReview(o_num);
    }

    @Override
    public void deleteReviewImage(int o_num) {
        reviewInputMapper.deleteReviewImage(o_num);
    }
}
