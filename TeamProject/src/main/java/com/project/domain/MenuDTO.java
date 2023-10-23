package com.project.domain;

import java.util.ArrayList;

import lombok.Data;

@Data
public class MenuDTO {
	private int m_id;
	private int r_id;
	private String m_name;
	private int m_price;
	private String m_cat;
	private String m_intro;
	private int m_code;
	private String m_img;
	
	private ArrayList<MenuAddDTO> maDTOList;
	
	public MenuDTO() {
		maDTOList = new ArrayList<>();
	}
}
