package com.project.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.project.domain.ReviewDTO;

public interface ReviewMapper {
    @Select("SELECT RI.O_NUM, U.U_NNAME, RI.R_CONTENT, RI.R_SCORE, RI.R_WRIDATE, R.R_BNAME, R.R_IMG " +
            "FROM REVIEW_INFO RI " +
            "JOIN ORDER_INFO OI ON RI.O_NUM = OI.O_NUM " +
            "JOIN USER_INFO U ON OI.U_ID = U.U_ID " +
            "JOIN REST_INFO R ON OI.R_ID = R.R_ID " +
            "WHERE R.R_ID = #{restaurantId} " +
            "ORDER BY RI.R_WRIDATE DESC")
    public List<ReviewDTO> getReviews(int restaurantId);
}
