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
	
//	@Test //입력
	public void TestRegister() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/menu/menuRegister")
																  .param("r_id", "1")
																  .param("m_name", "u")
																  .param("m_price", "3500")
																  .param("m_cat", "u메뉴")
																  .param("m_intro", "u메뉴소개")
																  .param("m_code", "0")
																  .param("m_img", "m17.png")
																  .param("maDTOList[0].m_id", "25")
																  .param("maDTOList[0].a_name", "25추가")
																  .param("maDTOList[0].a_price", "1000")
																  .param("maDTOList[1].m_id", "25")
																  .param("maDTOList[1].a_name", "25추가1")
																  .param("maDTOList[1].a_price", "1500")
																  )
										.andReturn()
										.getModelAndView()
										.getViewName();
		log.info(resultPage);
		
	}
	
//	@Test // 매장아이디가 ?인 메뉴 여러개 조회
	public void testGetList() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/menu/list").param("r_id", "1"))
								.andReturn().getModelAndView().getModelMap()
				);
	}
	
//	@Test //메뉴아이디가 ?인 메뉴,추가메뉴 정보 조회
	public void testGet() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/menu/get").param("m_id", "1"))
				.andReturn().getModelAndView().getModelMap()
				);
	}
	
//	@Test //삭제테스트
	public void testRemove() throws Exception {
		
		String resultPage = mockMvc.perform(MockMvcRequestBuilders
														.post("/menu/remove")
														.param("m_id", "21"))
									.andReturn()
									.getModelAndView()
									.getViewName();
		log.info(resultPage);
	}
	
//	@Test
	public void testModify() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders
																  .post("/menu/modify")
																  .param("m_id", "25")
																  .param("m_name", "q")
																  .param("m_cat", "q메뉴류")
																  .param("m_intro", "q메뉴류소개")
																  .param("maDTOList[0].a_id", "22")
																  .param("maDTOList[0].a_name", "25추가22")
																  .param("maDTOList[0].a_price", "1000")
																  .param("maDTOList[1].a_id", "23")
																  .param("maDTOList[1].a_name", "25추가33")
																  .param("maDTOList[1].a_price", "1500")
																  )
																  .andReturn()
																  .getModelAndView()
														     	  .getViewName();
		log.info(resultPage);
	}
}
