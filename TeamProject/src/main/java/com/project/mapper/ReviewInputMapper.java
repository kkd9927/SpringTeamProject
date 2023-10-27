package com.project.mapper;

import org.apache.ibatis.annotations.*;
import com.project.domain.ReviewInputDTO;

public interface ReviewInputMapper {
    ReviewInputDTO getReviewInput(int o_num);
    
    @Insert("INSERT INTO REVIEW_INFO (O_NUM, R_CONTENT, R_SCORE, R_WRIDATE) " +
            "VALUES(#{o_num}, #{r_content}, #{r_score}, #{r_wriDate})")
    void insertReview(ReviewInputDTO reviewInput);
    
    @Insert("INSERT INTO REVIEW_IMG (O_NUM, R_IMG) VALUES(#{o_num}, #{r_img})")
    void insertReviewImage(ReviewInputDTO reviewInput);
    
    @Update("UPDATE REVIEW_INFO " +
            "SET R_CONTENT = #{r_content}, R_SCORE = #{r_score} " +
            "WHERE O_NUM = #{o_num}")
    void updateReview(ReviewInputDTO reviewInput);
    
    @Update("UPDATE REVIEW_IMG " +
            "SET R_IMG = #{r_img} " +
            "WHERE O_NUM = #{o_num}")
    void updateReviewImage(ReviewInputDTO reviewInput);
    
    @Delete("DELETE FROM REVIEW_INFO WHERE O_NUM = #{o_num}")
    void deleteReview(int o_num);
    
    @Delete("DELETE FROM REVIEW_IMG WHERE O_NUM = #{o_num}")
    void deleteReviewImage(int o_num);
}
