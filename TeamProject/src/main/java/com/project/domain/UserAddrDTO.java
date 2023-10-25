package com.project.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserAddrDTO {
	private String u_id;
	private String u_atag;
	private String u_addr;
	private String u_dtad;
}
