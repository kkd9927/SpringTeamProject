package com.project.mapper;

import com.project.domain.UserDTO;
import com.project.domain.UserVO;

public interface UserMapper {
	public void insert(UserDTO user);
	
	public UserVO selectByUserId(String u_id);
}
