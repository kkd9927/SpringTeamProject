package com.project.domain;

import lombok.Data;

@Data
public class ReviewInputDTO {
    private int O_NUM;
    private String R_CONTENT;
    private double R_SCORE;
    private String R_IMG;
}
