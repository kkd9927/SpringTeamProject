package com.project.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.domain.ReviewDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.project.config.RootConfig.class})
public class ReviewServiceTest {

    @Autowired
    private ReviewService reviewService;

    @Test
    public void testGetReviews() {
        List<ReviewDTO> reviews = reviewService.getReviews();
        assertNotNull(reviews);
        for (ReviewDTO review : reviews) {
            System.out.println("O_NUM: " + review.getO_num());
            System.out.println("R_BNAME: " + review.getR_bname());
            System.out.println("U_NNAME: " + review.getR_bname());
            System.out.println("R_CONTENT: " + review.getR_content());
            System.out.println("R_SCORE: " + review.getR_score());
            System.out.println("R_WRIDATE: " + review.getR_wridate());
            System.out.println("R_IMG: " + review.getR_img());
        }
    }
}
