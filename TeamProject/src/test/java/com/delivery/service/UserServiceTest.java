package com.delivery.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.domain.UserDTO;
import com.project.service.UserService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.project.config.RootConfig.class,
								 com.project.security.SecurityConfig.class})
@Log4j
public class UserServiceTest {
	@Autowired
	private UserService service;
	
	@Test
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
}
