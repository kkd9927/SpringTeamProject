package com.project.service;

import com.project.domain.ReviewDTO;
import com.project.mapper.ReviewUserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewUserServiceImpl implements ReviewUserService {

    private final ReviewUserMapper reviewUserMapper;

    @Autowired
    public ReviewUserServiceImpl(ReviewUserMapper reviewUserMapper) {
        this.reviewUserMapper = reviewUserMapper;
    }

    @Override
    public List<ReviewDTO> getuserReviews(String userId) {
        return reviewUserMapper.getuserReviews(userId);
    }
}

