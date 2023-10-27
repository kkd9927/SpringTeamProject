package com.project.controller;

import com.project.service.ReviewService;
import com.project.domain.ReviewDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.project.config.RootConfig.class})
@WebAppConfiguration
public class ReviewControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Autowired
    private ReviewService reviewService;

    private Logger log = LoggerFactory.getLogger(ReviewControllerTest.class);

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testGetReviewsWithRealData() throws Exception {
        // 여기에서 실제 데이터베이스에 액세스하고 데이터를 가져오는 코드를 작성
        // 아래는 가상의 데이터를 대신 사용하는 코드 예시입니다.
        List<ReviewDTO> realReviews = new ArrayList<>();
        realReviews.add(new ReviewDTO(/* 데이터 초기화 */));

        // ReviewService의 getReviews 메서드가 호출될 때 모의 데이터 대신 실제 데이터를 반환하도록 설정
        when(reviewService.getReviews()).thenReturn(realReviews);

        String resultPage = mockMvc.perform(get("/reviews"))
                .andExpect(status().isOk())
                .andExpect(view().name("restaurant-readreview"))
                .andExpect(model().attributeExists("reviews"))
                .andExpect(model().size(1))
                .andReturn()
                .getModelAndView()
                .getViewName();

        log.info(resultPage);

        // ReviewService의 getReviews 메서드 호출 여부를 확인
        verify(reviewService, times(1)).getReviews();
    }
}
