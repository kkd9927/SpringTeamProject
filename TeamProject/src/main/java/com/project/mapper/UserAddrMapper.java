package com.project.mapper;

import java.util.List;

import com.project.domain.UserAddrVO;

public interface UserAddrMapper {
	public List<UserAddrVO> selectByUserId(String u_id);
}
