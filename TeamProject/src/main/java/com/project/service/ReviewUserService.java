package com.project.service;

import com.project.domain.ReviewDTO;
import java.util.List;

public interface ReviewUserService {
    List<ReviewDTO> getuserReviews(String userId);
}
