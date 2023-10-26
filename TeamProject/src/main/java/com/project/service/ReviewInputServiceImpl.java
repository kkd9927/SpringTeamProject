package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.mapper.ReviewInputMapper;
import com.project.domain.ReviewInputDTO;

@Service
public class ReviewInputServiceImpl implements ReviewInputService {

    @Autowired
    private ReviewInputMapper reviewInputMapper;

    @Override
    public ReviewInputDTO getReviewInput(int oNum) {
        return reviewInputMapper.getReviewInput(oNum);
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
    public void deleteReview(int oNum) {
        reviewInputMapper.deleteReview(oNum);
    }

    @Override
    public void deleteReviewImage(int oNum) {
        reviewInputMapper.deleteReviewImage(oNum);
    }
}
