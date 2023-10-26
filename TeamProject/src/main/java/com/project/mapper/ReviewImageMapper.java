package com.project.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import com.project.domain.ReviewImageDTO;

public interface ReviewImageMapper {
    
    @Select("SELECT O_NUM, R_IMG FROM REVIEW_IMG")
    List<ReviewImageDTO> getReviewImages();
    
    @Insert("INSERT INTO REVIEW_IMG (O_NUM, R_IMG) VALUES(#{oNum}, #{rImg})")
    void insertReviewImage(ReviewImageDTO reviewImage);
    
    @Update("UPDATE REVIEW_IMG SET R_IMG = #{rImg} WHERE O_NUM = #{oNum}")
    void updateReviewImage(ReviewImageDTO reviewImage);
    
    @Delete("DELETE FROM REVIEW_IMG WHERE O_NUM = #{oNum}")
    void deleteReviewImage(int oNum);
}
