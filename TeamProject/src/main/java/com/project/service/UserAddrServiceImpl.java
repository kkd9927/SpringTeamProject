package com.project.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.project.domain.UserAddrVO;
import com.project.domain.UserAddrVOList;
import com.project.mapper.UserAddrMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserAddrServiceImpl implements UserAddrService {
	private final UserAddrMapper mapper;
	
	@Override
	public UserAddrVOList getAddr(String u_id) {
		return new UserAddrVOList((ArrayList<UserAddrVO>)mapper.selectByUserId(u_id));
	}
}
