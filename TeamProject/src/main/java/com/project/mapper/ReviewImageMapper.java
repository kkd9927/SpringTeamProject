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
    
    @Insert("INSERT INTO REVIEW_IMG (O_NUM, R_IMG) VALUES(#{o_num}, #{r_img})")
    void insertReviewImage(ReviewImageDTO reviewImage);
    
    @Update("UPDATE REVIEW_IMG SET R_IMG = #{r_img} WHERE O_NUM = #{o_num}")
    void updateReviewImage(ReviewImageDTO reviewImage);
    
    @Delete("DELETE FROM REVIEW_IMG WHERE O_NUM = #{o_num}")
    void deleteReviewImage(int o_num);
}
