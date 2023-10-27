package com.project.mapper;

import com.project.mapper.ReviewInputMapper;
import com.project.config.RootConfig;
import com.project.domain.ReviewInputDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class ReviewInputMapperTest {

    @Autowired
    private ReviewInputMapper reviewInputMapper;

    @Before
    public void setUp() {
    }

    @Test
    public void testGetReviewInput() {
        int oNum = 22; // 테스트할 주문 번호
        ReviewInputDTO review = reviewInputMapper.getReviewInput(oNum);
        assertNotNull(review);
        assertEquals(oNum, review.getO_num());
    }

    @Test
    public void testInsertReview() {
        ReviewInputDTO reviewInput = new ReviewInputDTO();
        reviewInput.setO_num(22);
        reviewInput.setR_content("테스트 리뷰");
        reviewInput.setR_score(4.5);
        reviewInputMapper.insertReview(reviewInput);

        ReviewInputDTO savedReview = reviewInputMapper.getReviewInput(22);
        assertNotNull(savedReview);
        assertEquals(reviewInput.getO_num(), savedReview.getO_num());
        assertEquals(reviewInput.getR_content(), savedReview.getR_content());
        assertEquals(reviewInput.getR_score(), savedReview.getR_score(), 0.01);
    }
}
