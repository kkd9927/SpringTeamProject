package com.project.mapper;

import com.project.domain.UserDTO;
import com.project.domain.UserVO;

public interface UserMapper {
	public void insert(UserDTO user);
	
	public UserVO selectByUserId(String u_id);
	
	public void updateNname(String arg0, String arg1);
	
	public void updateImg(String arg0, String arg1);
	
	public void updatePassword(String arg0, String arg1);
	
	public void updatePhone(String arg0, String arg1);
}
