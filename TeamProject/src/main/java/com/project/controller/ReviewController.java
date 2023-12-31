package com.project.controller;

import com.project.service.ReviewService;
import com.project.domain.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public String getReviews(@RequestParam int r_id, Model model) {
        List<ReviewDTO> reviews = reviewService.getReviews(r_id);
        model.addAttribute("reviews", reviews);
        return "restaurant-readreview";
    }
}
