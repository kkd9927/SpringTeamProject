package com.project.domain;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RestOpenDTO {

	private int r_id;
	@DateTimeFormat(pattern = "HH24:MI")
	private Date r_opent;
	@DateTimeFormat(pattern = "HH24:MI")
	private Date r_closet;
}
