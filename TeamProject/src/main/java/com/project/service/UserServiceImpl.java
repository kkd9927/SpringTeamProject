package com.project.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.domain.UserDTO;
import com.project.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserMapper mapper;
	private final PasswordEncoder encoder;

	@Override
	public void register(UserDTO user) {
		String pw = user.getU_pw();
		String encodedPW = encoder.encode(pw);
		user.setU_pw(encodedPW);
		
		mapper.insert(user);
	}
}
