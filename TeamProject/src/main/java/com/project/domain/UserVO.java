package com.project.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class UserVO {
	private String u_id;
	private String u_pw;
	private String u_rname;
	private String u_phone;
	private String u_nname;
	private int u_code;
	private String u_regdate;
	private String u_img;
}
