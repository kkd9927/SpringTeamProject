package com.delivery.domain;

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
	private String u_phone;
	private String u_nname;
	private String u_pimg;
}
