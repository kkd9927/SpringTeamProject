package com.project.service;

import com.project.domain.ReviewImageDTO;
import java.util.List;

public interface ReviewImageService {
    List<ReviewImageDTO> getReviewImages(); // 추가된 메서드

    void insertReviewImage(ReviewImageDTO reviewImage);
    void updateReviewImage(ReviewImageDTO reviewImage);
    void deleteReviewImage(int o_num);
}
