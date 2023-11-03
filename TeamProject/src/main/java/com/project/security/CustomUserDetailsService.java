package com.project.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.domain.UserAddrVO;
import com.project.domain.UserVO;
import com.project.mapper.UserAddrMapper;
import com.project.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	private final UserMapper userMapper;
	private final UserAddrMapper addrMapper;
	
	// 로그인 요청이 들어오면 아래 메소드를 거쳐 인증객체를 생성함
	@Override
	public UserDetails loadUserByUsername(String u_id) throws UsernameNotFoundException {
		UserVO user = userMapper.selectByUserId(u_id);
		List<UserAddrVO> addr = (ArrayList<UserAddrVO>)addrMapper.selectByUserId(u_id);
		
		if(user == null) {
			throw new UsernameNotFoundException("존재하지 않는 유저입니다.");
		}
		
		int userCode = user.getU_code();
		List<GrantedAuthority> authorities = new ArrayList<>();
		// 유저의 권한 설정을 위한 리스트
		
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
		
		if(userCode == 2) {
			int rId = userMapper.selectRIdByUserId(u_id);
			return new CustomUser(user, addr, authorities, rId);
		}
		
		return new CustomUser(user, addr, authorities, 0);
	}
	
	public void createNewAuthentication() {
		Authentication currentAuth = SecurityContextHolder.getContext().getAuthentication();
		CustomUser oldPrincipal = (CustomUser) currentAuth.getPrincipal();
		CustomUser newPrincipal = (CustomUser) loadUserByUsername(oldPrincipal.getUsername());
		
		UsernamePasswordAuthenticationToken newAuth = new UsernamePasswordAuthenticationToken(newPrincipal, currentAuth.getCredentials(), newPrincipal.getAuthorities());
		newAuth.setDetails(currentAuth.getDetails());
		
		SecurityContextHolder.getContext().setAuthentication(newAuth);
	}
}
