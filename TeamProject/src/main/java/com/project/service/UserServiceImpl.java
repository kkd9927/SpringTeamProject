package com.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.domain.UserAddrDTO;
import com.project.domain.UserAddrVO;
import com.project.domain.UserDTO;
import com.project.mapper.UserAddrMapper;
import com.project.mapper.UserMapper;
import com.project.security.CustomUser;

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
	public void addAddr(UserAddrDTO addr) {
		addrMapper.insert(addr);
	}
	
	@Override
	public void removeAddr(UserAddrDTO addr) {
		addrMapper.delete(addr);
	}

	@Override
	public void modifyNname(Map<String, String> map) {
		userMapper.updateNname(map.get("u_id"), map.get("u_nname"));
	}

	@Override
	public void modifyImg(Map<String, String> map) {
		userMapper.updateImg(map.get("u_id"), map.get("u_nname"));
	}

	@Override
	public int modifyPassword(Map<String, String> map, CustomUser user) {
		if(!user.getUser().getU_pw().equals(encoder.encode(map.get("u_pw_before")))) {
			return 0;
		}
		
		userMapper.updatePassword(map.get("u_id"), encoder.encode(map.get("u_pw_after")));
		return 1;
	}

	@Override
	public void modifyPhone(Map<String, String> map) {
		userMapper.updatePhone(map.get("u_id"), map.get("u_nname"));
	}
}
