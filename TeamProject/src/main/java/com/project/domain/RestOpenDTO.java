package com.project.domain;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RestOpenDTO {

	private int r_id;
	@DateTimeFormat(pattern = "HH24:MI")
	private Date r_opent;
	private Date r_closet;
	private String r_opentS;
	private String r_closetS;
	
}
