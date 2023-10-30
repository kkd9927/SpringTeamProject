package com.project.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

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
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx)
									  .addFilter(new CharacterEncodingFilter("UTF-8", true))
									  .build();
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
			.param("u_id", "test151")
			.param("u_pw", "test")
			.param("u_rname", "홍길동")
			.param("u_phone", "01097656432")
			.param("u_code", "2")
		)
		.andReturn()
		.getModelAndView()
		.getViewName();

		log.info(resultPage);
	}
	
//	@Test
	public void loginGetTest() throws Exception {
		String resultPage = mockMvc.perform(
			MockMvcRequestBuilders
			.get("/login")
		)
		.andReturn()
		.getModelAndView()
		.getViewName();

		log.info(resultPage);
	}
	
//	@Test
	public void loginPostTest() throws Exception {
		String resultPage = mockMvc.perform(
			MockMvcRequestBuilders
			.post("/login")
			.param("u_id", "test_id4")
			.param("u_pw", "test_pw")
		)
		.andReturn()
		.getModelAndView()
		.getViewName();

		log.info(resultPage);
	}
	
//	@Test
	public void addAddressTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
			.post("/address/add")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{\"u_id\": \"test\", \"u_atag\": \"12ddgw\", \"u_addr\": \"부산시 부산진구\", \"u_dtad\": \"부전동 400-49\"}")
		)
    	.andExpect(MockMvcResultMatchers.status().isOk())
    	.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void removeAddressTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
			.delete("/address/remove")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{\"u_id\": \"test\", \"u_atag\": \"12ddgw\", \"u_addr\": \"부산시 부산진구\", \"u_dtad\": \"부전동 400-49\"}")
		)
    	.andExpect(MockMvcResultMatchers.status().isOk())
    	.andDo(MockMvcResultHandlers.print());
	}
}
