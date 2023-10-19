package com.delivery.service;

import org.springframework.stereotype.Service;

import com.delivery.domain.UserDTO;
import com.delivery.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserMapper mapper;

	@Override
	public void register(UserDTO user) {
		mapper.insert(user);
	}
}
