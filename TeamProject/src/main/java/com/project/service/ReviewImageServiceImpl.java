package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.mapper.ReviewImageMapper;
import com.project.domain.ReviewImageDTO;
import java.util.List;

@Service
public class ReviewImageServiceImpl implements ReviewImageService {

    @Autowired
    private ReviewImageMapper reviewImageMapper;

    @Override
    public List<ReviewImageDTO> getReviewImages() {
        return reviewImageMapper.getReviewImages();
    }

    @Override
    public void insertReviewImage(ReviewImageDTO reviewImage) {
        reviewImageMapper.insertReviewImage(reviewImage);
    }

    @Override
    public void updateReviewImage(ReviewImageDTO reviewImage) {
        reviewImageMapper.updateReviewImage(reviewImage);
    }

    @Override
    public void deleteReviewImage(int o_num) {
        reviewImageMapper.deleteReviewImage(o_num);
    }
}
