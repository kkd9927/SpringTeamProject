package com.project.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.domain.UserDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.project.config.RootConfig.class,
								 com.project.config.SecurityConfig.class})
@Log4j
public class UserMapperTest {
	@Autowired
	private UserMapper mapper;
	
//	@Test
	public void insertUserTest() {
		UserDTO user = new UserDTO();
		user.setU_id("test_id2");
		user.setU_pw("test_pw");
		user.setU_rname("test_name");
		user.setU_phone("01012341112");
		user.setU_code(1);
		log.info(user);
		
		mapper.insert(user);
	}
	
	@Test
	public void selectByUserIdTest() {
		log.info(mapper.selectByUserId("test_id2"));
	}
}
