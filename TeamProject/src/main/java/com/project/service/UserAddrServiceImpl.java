package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.domain.UserAddrDTO;
import com.project.domain.UserAddrVO;
import com.project.mapper.UserAddrMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserAddrServiceImpl implements UserAddrService {
	private final UserAddrMapper mapper;
	
	@Override
	public List<UserAddrVO> getAddr(String u_id) {
		return mapper.selectByUserId(u_id);
	}
	
	@Override
	public void addAddr(UserAddrDTO addr) {
		mapper.insert(addr);
	}
}
