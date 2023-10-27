package com.project.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ReviewDTO {
    private String o_num;
    private String r_bname;
    private String u_nname;
    private String r_content;
    private double r_score;
    
    @DateTimeFormat(pattern = "yyyyMMdd")
    private Date r_wridate;
    private String r_img;
}
