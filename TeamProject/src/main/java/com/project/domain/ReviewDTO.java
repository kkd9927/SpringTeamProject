package com.project.domain;

import lombok.Data;

@Data
public class ReviewDTO {
    private String O_NUM;
    private String R_BNAME;
    private String U_NNAME;
    private String R_CONTENT;
    private double R_SCORE;
    private String R_WRIDATE;
    private String R_IMG;
}
