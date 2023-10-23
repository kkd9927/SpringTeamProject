package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.domain.UserVO;
import com.project.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserLoginService implements UserDetailsService {
	private final UserMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String u_id) throws UsernameNotFoundException {
		UserVO user = mapper.selectByUserId(u_id);
		
		if(user == null) {
			throw new UsernameNotFoundException("존재하지 않는 유저입니다.");
		}
		
		int userCode = user.getU_code();
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		if(userCode == 0) {
			authorities.add(new SimpleGrantedAuthority("admin"));
		} else if(userCode == 1) {
			authorities.add(new SimpleGrantedAuthority("user"));
		} else {
			authorities.add(new SimpleGrantedAuthority("business"));
		}
		
		return new User(user.getU_id(), user.getU_pw(), authorities);
	}
}
