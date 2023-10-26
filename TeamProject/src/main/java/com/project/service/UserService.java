package com.project.service;

import java.util.List;

import com.project.domain.UserAddrDTO;
import com.project.domain.UserAddrVO;
import com.project.domain.UserDTO;

public interface UserService {
	public void register(UserDTO user);
	
	public List<UserAddrVO> getAddr(String u_id);
	
	public UserDTO addAddr(UserAddrDTO addr);
}
