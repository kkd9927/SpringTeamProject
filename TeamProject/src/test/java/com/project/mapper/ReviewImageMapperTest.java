package com.project.mapper;

import com.project.config.RootConfig;
import com.project.domain.ReviewImageDTO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.List;

public class ReviewImageMapperTest {

    @Test
    public void testGetReviewImages() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);

        try {
            SqlSessionFactory sqlSessionFactory = context.getBean(SqlSessionFactory.class);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            ReviewImageMapper reviewImageMapper = sqlSession.getMapper(ReviewImageMapper.class);

            List<ReviewImageDTO> reviewImages = reviewImageMapper.getReviewImages();

            for (ReviewImageDTO reviewImage : reviewImages) {
                System.out.println("O_NUM" + reviewImage.getO_NUM());
                System.out.println("R_IMG" + reviewImage.getR_IMG());
            }
        } finally {
            context.close();
        }
    }
}
