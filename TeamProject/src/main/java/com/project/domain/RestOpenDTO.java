package com.project.domain;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RestOpenDTO {

	private int r_id;
	private int w_code;
	@DateTimeFormat(pattern = "HH24:MI")
	private Date r_opent;
	private Date r_closet;
	private String w_cname;
	
}
