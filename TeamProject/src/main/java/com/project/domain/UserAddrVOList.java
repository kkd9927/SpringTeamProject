package com.project.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class UserAddrVOList {
	List<UserAddrVO> addrList;
	
	public UserAddrVOList(ArrayList<UserAddrVO> addrList) {
		this.addrList = addrList;
	}
}
