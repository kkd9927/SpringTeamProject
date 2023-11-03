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
		// Authentication => 사용자 정보를 가지고있는 인증객체
		// SecurityContext => Authentication 객체를 가지고있는 객체
		// SecurityContextHolder => SecurityContext를 가지고있는 보관소로 getContext() 메소드를 통해 SecurityContext 반환
		
		CustomUser oldPrincipal = (CustomUser) currentAuth.getPrincipal();
		// Authentication 객체로부터 유저객체를 반환
		
		CustomUser newPrincipal = (CustomUser) loadUserByUsername(oldPrincipal.getUsername());
		// 새로운 사용자 정보를 담은 유저객체 생성
		
		UsernamePasswordAuthenticationToken newAuth = new UsernamePasswordAuthenticationToken(newPrincipal, currentAuth.getCredentials(), newPrincipal.getAuthorities());
		// UsernamePasswordAuthenticationToken => 유저인증객체, AbstractAuthenticationToken 상속
		// AbstractAuthenticationToken => Authentication 인터페이스를 구현한 추상 클래스
		
		newAuth.setDetails(currentAuth.getDetails());
		// 기존 인증객체로부터 디테일을 가져옴?
		
		SecurityContextHolder.getContext().setAuthentication(newAuth);
		// 변경된 유저인증객체를 보관소에 저장 -> 세션에 저장
	}
}
