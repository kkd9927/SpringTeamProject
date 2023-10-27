package com.project.mapper;

import com.project.config.RootConfig;
import com.project.domain.ReviewDTO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.List;

public class ReviewMapperTest {

    @Test
    public void testGetReviews() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);

        SqlSessionFactory sqlSessionFactory = context.getBean(SqlSessionFactory.class);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ReviewMapper reviewMapper = sqlSession.getMapper(ReviewMapper.class);

        List<ReviewDTO> reviews = reviewMapper.getReviews();

        for (ReviewDTO review : reviews) {
            System.out.println("ONUM: " + review.getO_NUM());
            System.out.println("RBNAME: " + review.getR_BNAME());
            System.out.println("UNNAME: " + review.getU_NNAME());
            System.out.println("RCONTENT: " + review.getR_CONTENT());
            System.out.println("RSCORE: " + review.getR_SCORE());
            System.out.println("RWRIDATE: " + review.getR_WRIDATE());
            System.out.println("RIMG: " + review.getR_IMG());
        }


        context.close();
    }
}
