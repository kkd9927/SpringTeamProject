package com.project.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.domain.UserAddrDTO;
import com.project.domain.UserAddrVO;
import com.project.domain.UserDTO;
import com.project.domain.UserVO;
import com.project.mapper.UserAddrMapper;
import com.project.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserMapper userMapper;
	private final UserAddrMapper addrMapper;
	private final PasswordEncoder encoder;

	@Override
	public void register(UserDTO user) {
		String pw = user.getU_pw();
		String encodedPW = encoder.encode(pw);
		user.setU_pw(encodedPW);
		
		userMapper.insert(user);
	}
	
	@Override
	public List<UserAddrVO> getAddr(String u_id) {
		return addrMapper.selectByUserId(u_id);
	}
	
	@Override
	public UserDTO addAddr(UserAddrDTO addr) {
		addrMapper.insert(addr);
		
		UserVO vo = userMapper.selectByUserId(addr.getU_id());
		UserDTO dto = new UserDTO();
		dto.setU_id(vo.getU_id());
		dto.setU_phone(encoder.encode(vo.getU_pw()));
		dto.setU_rname(vo.getU_rname());
		dto.setU_phone(vo.getU_phone());
		dto.setU_nname(vo.getU_nname());
		dto.setU_code(vo.getU_code());
		dto.setU_regdate(vo.getU_regdate());
		dto.setU_img(vo.getU_img());
		
		return dto;
	}
}
