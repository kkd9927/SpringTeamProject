package com.project.service;

import java.util.List;

import com.project.domain.UserAddrDTO;
import com.project.domain.UserAddrVO;

public interface UserAddrService {
	public List<UserAddrVO> getAddr(String u_id);
	
	public void addAddr(UserAddrDTO addr);
}
