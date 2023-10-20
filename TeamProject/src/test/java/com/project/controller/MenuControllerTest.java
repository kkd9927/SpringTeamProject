package com.project.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {com.project.config.RootConfig.class,
								 com.project.config.ServletConfig.class})
@Log4j
public class MenuControllerTest {

	@Setter(onMethod_ = { @Autowired })
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test //입력
	public void TestRegister() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/menu/register")
																  .param("r_id", "1")
																  .param("m_name", "f")
																  .param("m_price", "3500")
																  .param("m_cat", "f메뉴")
																  .param("m_intro", "f메뉴소개")
																  .param("m_code", "0")
																  .param("m_img", "m11.png")
																  .param("maDTOList[0].m_id", "11")
																  .param("maDTOList[0].a_name", "11추가")
																  .param("maDTOList[0].a_price", "1000")
																  .param("maDTOList[1].m_id", "11")
																  .param("maDTOList[1].a_name", "11추가1")
																  .param("maDTOList[1].a_price", "1500")
																  )
										.andReturn()
										.getModelAndView()
										.getViewName();
		log.info(resultPage);
		
	}
}
