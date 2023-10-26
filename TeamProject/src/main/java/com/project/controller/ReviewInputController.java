package com.project.controller;

import com.project.mapper.ReviewInputMapper;
import com.project.domain.ReviewInputDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReviewInputController {
    private final ReviewInputMapper reviewInputMapper;

    public ReviewInputController(ReviewInputMapper reviewInputMapper) {
        this.reviewInputMapper = reviewInputMapper;
    }

    @GetMapping("/reviewInput")
    public String showReviewInput(Model model) {
        int oNum = 21;
        ReviewInputDTO reviewInput = reviewInputMapper.getReviewInput(oNum);
        model.addAttribute("reviewInput", reviewInput);
        return "review-input";
    }
}
