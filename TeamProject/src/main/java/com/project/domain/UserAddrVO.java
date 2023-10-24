package com.project.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class UserAddrVO {
	private String u_id;
	private String u_atag;
	private String u_addr;
	private String u_dtad;
}
