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

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {com.project.config.RootConfig.class,
								 com.project.config.ServletConfig.class,
								 com.project.config.SecurityConfig.class})
@Log4j
public class UserControllerTest {
	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
//	@Test
	public void registerGetTest() throws Exception {
		String resultPage = mockMvc.perform(
			MockMvcRequestBuilders
			.get("/register")
		)
		.andReturn()
		.getModelAndView()
		.getViewName();

		log.info(resultPage);
	}
	
//	@Test
	public void registerPostTest() throws Exception {
		String resultPage = mockMvc.perform(
			MockMvcRequestBuilders
			.post("/register")
			.param("u_id", "test_id4")
			.param("u_pw", "test_pw")
			.param("u_rname", "test_name")
			.param("u_phone", "01015123171")
			.param("u_code", "1")
		)
		.andReturn()
		.getModelAndView()
		.getViewName();

		log.info(resultPage);
	}
}
