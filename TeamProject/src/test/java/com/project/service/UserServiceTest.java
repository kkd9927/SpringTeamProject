package com.project.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.domain.UserAddrDTO;
import com.project.domain.UserDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.project.config.RootConfig.class,
		 						 com.project.config.SecurityConfig.class})
@Log4j
public class UserServiceTest {
	@Autowired
	private UserService service;
	
//	@Test
	public void registerTest() {
		UserDTO user = new UserDTO();
		user.setU_id("test_id4");
		user.setU_pw("test_pw");
		user.setU_rname("test_name");
		user.setU_phone("01015123179");
		user.setU_code(1);
		log.info(user);
		
		service.register(user);
	}
	
//	@Test
	public void getAddrTest() {
		log.info(service.getAddr("test"));
	}
	
//	@Test
	public void addAddrTest() {
		UserAddrDTO addr = new UserAddrDTO();
		addr.setU_id("test");
		addr.setU_atag("null");
		addr.setU_addr("부산시 부산진구");
		addr.setU_dtad("부전동 300-3");
		service.addAddr(addr);
		
		log.info(addr);
	}
}
