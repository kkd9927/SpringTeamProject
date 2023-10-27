package com.project.domain;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RestDTO {
	private int r_id;
	private String r_licnum;
	private String u_id;
	private String r_lname;
	private String r_addr;
	private String r_dtad;
	private String r_bname;
	private String r_tel;
	private int f_code;
	private String r_intro;
	private int r_minprice;
	private String r_img;
	private int sum2;
	private double avg;
	private double r_score;
	
	private RestOpenDTO restOpen;
//	private ArrayList<RestOpenDTO> roDTOList;
	private RestClosedDTO restClosed;
	private ArrayList<RestCatDTO> rcaDTOList;
	private ArrayList<MethodDTO> mDTOList;
	
	public RestDTO() {
//		roDTOList = new ArrayList<>();
		restClosed = new RestClosedDTO();
		rcaDTOList = new ArrayList<>();
		mDTOList = new ArrayList<>();
		restOpen = new RestOpenDTO();
	}
//	
//	public setAllRid(r_id) {
//		
//	}
}
