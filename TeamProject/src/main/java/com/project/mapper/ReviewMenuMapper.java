package com.project.mapper;

import com.project.domain.ReviewMenuDTO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ReviewMenuMapper {
    @Select("SELECT RI.O_NUM, M.M_NAME " +
            "FROM REVIEW_INFO RI " +
            "JOIN ORDER_INFO OI ON RI.O_NUM = OI.O_NUM " +
            "JOIN ORDER_MENU OM ON OI.O_NUM = OM.O_NUM " +
            "JOIN MENU_INFO M ON OM.M_ID = M.M_ID")
    List<ReviewMenuDTO> getReviewMenus();

}