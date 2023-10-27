package com.project.domain;

import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ReviewInputDTO {
    private int o_num;
    private String r_content;
    private double r_score;
    
    @DateTimeFormat(pattern = "yyyyMMdd")
    private Date r_wriDate;
    private String r_img;
}
