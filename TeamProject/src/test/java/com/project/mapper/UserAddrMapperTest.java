package com.project.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.domain.UserAddrDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.project.config.RootConfig.class,
								 com.project.config.SecurityConfig.class})
@Log4j
public class UserAddrMapperTest {
	@Autowired
	private UserAddrMapper mapper;
	
//	@Test
	public void insertTest() {
		UserAddrDTO addr = new UserAddrDTO();
		addr.setU_id("test");
		addr.setU_atag("회사");
		addr.setU_addr("부산시 부산진구");
		addr.setU_dtad("부전동 200-2");
		
		mapper.insert(addr);
		
		log.info(addr);
	}
	
//	@Test
	public void selectByUserIdTest() {
		log.info(mapper.selectByUserId("test"));
	}
	
	@Test
	public void deleteTest() {
		UserAddrDTO addr = new UserAddrDTO();
		addr.setU_id("test");
		addr.setU_atag("제발");
		addr.setU_addr("제발");
		addr.setU_dtad("제발");
		
		mapper.delete(addr);
		
		log.info(addr);
	}
}
