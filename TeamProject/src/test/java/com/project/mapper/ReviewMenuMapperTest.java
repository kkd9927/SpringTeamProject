package com.project.mapper;

import com.project.config.RootConfig;
import com.project.domain.ReviewMenuDTO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.List;

public class ReviewMenuMapperTest {

    @Test
    public void testGetReviewMenus() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);

        try {
            SqlSessionFactory sqlSessionFactory = context.getBean(SqlSessionFactory.class);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            ReviewMenuMapper reviewMenuMapper = sqlSession.getMapper(ReviewMenuMapper.class);

            List<ReviewMenuDTO> reviewMenus = reviewMenuMapper.getReviewMenus();

            for (ReviewMenuDTO reviewMenu : reviewMenus) {
                System.out.println("O_NUM" + reviewMenu.getO_NUM());
                System.out.println("M_NAME" + reviewMenu.getM_NAME());
            }
        } finally {
            context.close();
        }
    }
}
