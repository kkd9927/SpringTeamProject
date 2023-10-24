package com.project.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.domain.UserVO;
import com.project.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
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
			authorities.add(new SimpleGrantedAuthority("ADMIN"));
			authorities.add(new SimpleGrantedAuthority("USER"));
			authorities.add(new SimpleGrantedAuthority("BUSINESS"));
		} else if(userCode == 1) {
			authorities.add(new SimpleGrantedAuthority("USER"));
		} else {
			authorities.add(new SimpleGrantedAuthority("USER"));
			authorities.add(new SimpleGrantedAuthority("BUSINESS"));
		}
		
		return new CustomUser(user, authorities);
	}
}
