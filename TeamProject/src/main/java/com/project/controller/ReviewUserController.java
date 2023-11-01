package com.project.controller;

import com.project.service.ReviewUserService;
import com.project.domain.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReviewUserController {

    private final ReviewUserService reviewuserService;

    @Autowired
    public ReviewUserController(ReviewUserService reviewuserService) {
        this.reviewuserService = reviewuserService;
    }

    @GetMapping("/user-reviews")
    public String getuserReviews(@RequestParam String u_id, Model model) {
        List<ReviewDTO> reviews = reviewuserService.getuserReviews(u_id);
        model.addAttribute("reviews", reviews);
        return "user-readreview";
    }
}
