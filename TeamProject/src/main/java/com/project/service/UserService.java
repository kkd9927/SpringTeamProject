package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.project.domain.RestDTO;
import com.project.domain.UserAddrDTO;
import com.project.domain.UserAddrVO;
import com.project.domain.UserDTO;
import com.project.security.CustomUser;

public interface UserService {
	public void register(UserDTO user);
	
	public ArrayList<RestDTO> getFavList(String u_id);
	
	public void modifyNname(Map<String, String> map);
	
	public void modifyImg(Map<String, String> map);
	
	public int modifyPassword(Map<String, String> map, CustomUser user);
	
	public void modifyPhone(Map<String, String> map);
	
	public void withdraw(Map<String, String> map);
	
	public List<UserAddrVO> getAddr(String u_id);
	
	public void addAddr(UserAddrDTO addr);
	
	public void removeAddr(UserAddrDTO addr);
}
