package com.delivery.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class UserVO {
	private String u_id;
	private String u_pw;
	private String u_phone;
	private String u_nname;
	private String u_pimg;
}
