package com.project.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.project.domain.UserAddrVO;
import com.project.domain.UserVO;

import lombok.Getter;

@Getter
public class CustomUser extends User {
	// 스프링 시큐리티에서 기본적으로 제공하는 User 클래스를 상속받은 사용자 정의 클래스
	private static final long serialVersionUID = 1L;
	
	private UserVO user;
	private List<UserAddrVO> addr;
	private int rid;
	// User 클래스는 username(아이디), password(비밀번호), authorities(인증)을 기본적인 멤버로 가지고있음
	// view 단에서 사용하기 위해 사용자 정의 멤버변수를 별도선언
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public CustomUser(UserVO user, List<UserAddrVO> addr, Collection<? extends GrantedAuthority> authorities, int rId) {
		super(user.getU_id(), user.getU_pw(), authorities);
		
		this.user = user;
		this.addr = addr;
		this.rid = rId;
	}
}
