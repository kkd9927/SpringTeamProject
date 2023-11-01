package com.project.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	
	@Autowired
	private PasswordEncoder encoder;
	
//	@Test
	public void insertTest() {
		UserDTO user = new UserDTO();
		user.setU_id("test_id2");
		user.setU_pw("test_pw");
		user.setU_rname("test_name");
		user.setU_phone("01012341112");
		user.setU_code(1);
		log.info(user);
		
		mapper.insert(user);
	}
	
//	@Test
	public void selectByUserIdTest() {
		log.info(mapper.selectByUserId("test"));
	}
	
//	@Test
	public void updateNname() {
		mapper.updateNname("test", "수정된닉네임");
		log.info(mapper.selectByUserId("test"));
	}
	
//	@Test
	public void updateImg() {
		mapper.updateImg("test", "수정된이미지");
		log.info(mapper.selectByUserId("test"));
	}
	
//	@Test
	public void updatePassword() {
		log.info("변경전:" + mapper.selectByUserId("test").getU_pw());
		mapper.updatePassword("test", encoder.encode("테스트1"));
		log.info("변경후:" + mapper.selectByUserId("test").getU_pw());
	}
	
	@Test
	public void updatePhone() {
		mapper.updatePhone("test", "01012345678");
		log.info(mapper.selectByUserId("test"));
	}
}
