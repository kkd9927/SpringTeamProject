package com.project.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserDTO {
	private String u_id;
	private String u_pw;
	private String u_rname;
	private String u_phone;
	private String u_nname;
	private int u_code;
	private String u_regdate;
	private String u_img;
}
