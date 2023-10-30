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
	private static final long serialVersionUID = 1L;
	
	private UserVO user;
	private List<UserAddrVO> addr;
	private int rid;
	
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
