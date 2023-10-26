package com.project.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import com.project.domain.ReviewInputDTO;

public interface ReviewInputMapper {
    // SELECT 쿼리
    ReviewInputDTO getReviewInput(int oNum);
    
    // INSERT 쿼리
    @Insert("INSERT INTO REVIEW_INFO (O_NUM, R_CONTENT, R_SCORE, R_WRIDATE) " +
            "VALUES(#{oNum}, #{reviewContent}, #{reviewScore}, SYSDATE)")
    void insertReview(ReviewInputDTO reviewInput);
    
    @Insert("INSERT INTO REVIEW_IMG (O_NUM, R_IMG) VALUES(#{oNum}, #{reviewImage})")
    void insertReviewImage(ReviewInputDTO reviewInput);
    
    // UPDATE 쿼리
    @Update("UPDATE REVIEW_INFO " +
            "SET R_CONTENT = #{reviewContent}, R_SCORE = #{reviewScore} " +
            "WHERE O_NUM = #{oNum}")
    void updateReview(ReviewInputDTO reviewInput);
    
    @Update("UPDATE REVIEW_IMG " +
            "SET R_IMG = #{reviewImage} " +
            "WHERE O_NUM = #{oNum}")
    void updateReviewImage(ReviewInputDTO reviewInput);
    
    // DELETE 쿼리
    @Delete("DELETE FROM REVIEW_INFO WHERE O_NUM = #{oNum}")
    void deleteReview(int oNum);
    
    @Delete("DELETE FROM REVIEW_IMG WHERE O_NUM = #{oNum}")
    void deleteReviewImage(int oNum);
}
