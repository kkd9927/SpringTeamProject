package com.project.controller;

import com.project.mapper.ReviewMenuMapper;
import com.project.domain.ReviewMenuDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReviewMenuController {
    private final ReviewMenuMapper reviewMenuMapper;

    public ReviewMenuController(ReviewMenuMapper reviewMenuMapper) {
        this.reviewMenuMapper = reviewMenuMapper;
    }

    @GetMapping("/reviewMenus")
    public String showReviewMenus(Model model) {
        List<ReviewMenuDTO> reviewMenus = reviewMenuMapper.getReviewMenus();
        model.addAttribute("reviewMenus", reviewMenus);
        return "restaurant-readreview";
    }
}
