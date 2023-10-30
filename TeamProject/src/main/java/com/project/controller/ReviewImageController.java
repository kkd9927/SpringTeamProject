package com.project.controller;

import com.project.mapper.ReviewImageMapper;
import com.project.domain.ReviewImageDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class ReviewImageController {
    private final ReviewImageMapper reviewImageMapper;

    public ReviewImageController(ReviewImageMapper reviewImageMapper) {
        this.reviewImageMapper = reviewImageMapper;
    }

    @GetMapping("/reviewImages")
    public String showReviewImages(Model model) {
        List<ReviewImageDTO> reviewImages = reviewImageMapper.getReviewImages();
        model.addAttribute("reviewImages", reviewImages);
        return "restaurant-readreview";
    }
}
