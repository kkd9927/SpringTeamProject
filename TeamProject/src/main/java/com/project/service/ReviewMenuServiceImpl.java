package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.mapper.ReviewMenuMapper;
import com.project.domain.ReviewMenuDTO;

@Service
public class ReviewMenuServiceImpl implements ReviewMenuService {

    @Autowired
    private ReviewMenuMapper reviewMenuMapper;

    @Override
    public List<ReviewMenuDTO> getReviewMenus(int oNum) {
        return reviewMenuMapper.getReviewMenus();
    }
}

