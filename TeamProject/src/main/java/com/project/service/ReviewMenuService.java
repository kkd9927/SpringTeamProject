package com.project.service;

import java.util.List;

import com.project.domain.ReviewMenuDTO;

public interface ReviewMenuService {
    List<ReviewMenuDTO> getReviewMenus(int o_num);
}
