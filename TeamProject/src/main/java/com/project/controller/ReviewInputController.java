package com.project.controller;

import com.project.domain.ReviewInputDTO;
import com.project.service.ReviewInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class ReviewInputController {
    private final ReviewInputService reviewInputService;

    @Autowired
    public ReviewInputController(ReviewInputService reviewInputService) {
        this.reviewInputService = reviewInputService;
    }

    @GetMapping("/review-input")
    public String showReviewInputForm(Model model, @RequestParam("o_num") int o_num) {
        ReviewInputDTO reviewInput = reviewInputService.getReviewInput(o_num);
        model.addAttribute("reviewInput", reviewInput);
        return "review-input";
    }

    @PostMapping("/review-input")
    public String handleReviewInput(
            @RequestParam("o_num") String o_num,
            @RequestParam("r_content") String r_content,
            @RequestParam("r_score") double r_score,
            @RequestPart("r_img") MultipartFile r_img) {

        ReviewInputDTO reviewInput = new ReviewInputDTO();
        reviewInput.setO_num(Integer.parseInt(o_num));
        reviewInput.setR_content(r_content);
        reviewInput.setR_score(r_score);
        reviewInput.setR_img(r_img.getOriginalFilename());

        try {
            // 이미지 파일을 저장할 경로
            String uploadDirectory = "src/main/webapp/resources/img/";
            String originalFileName = r_img.getOriginalFilename();
            String fileName = System.currentTimeMillis() + originalFileName;
            File file = new File(uploadDirectory + fileName);
            r_img.transferTo(file);
            reviewInput.setR_img("/resources/img/" + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        reviewInputService.insertReview(reviewInput);
        reviewInputService.insertReviewImage(reviewInput);

        return "redirect:/";
    }

    @GetMapping("/review-edit")
    public String showReviewEditForm(Model model, @RequestParam("o_num") int o_num) {
        ReviewInputDTO reviewInput = reviewInputService.getReviewInput(o_num);
        model.addAttribute("reviewInput", reviewInput);
        return "review-edit";
    }

    @PostMapping("/review-edit")
    public String processReviewEdit(ReviewInputDTO reviewInput) {
        reviewInputService.updateReview(reviewInput);
        reviewInputService.updateReviewImage(reviewInput);
        return "redirect:/reviews";
    }

    @GetMapping("/review-delete")
    public String deleteReview(@RequestParam("o_num") int o_num) {
        reviewInputService.deleteReview(o_num);
        reviewInputService.deleteReviewImage(o_num);
        return "redirect:/reviews";
    }
    
    @GetMapping("/restaurant-reviewcreate")
    public String showRestaurantReviewCreatePage() {
        // 필요한 로직 추가
        return "restaurant-reviewcreate";
    }
}
