package com.project.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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
public class RestControllerTest {

	@Setter(onMethod_ = {@Autowired})
	private WebApplicationContext ctx;
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
//	@Test //입력
	public void TestRegister() throws Exception {
		SimpleDateFormat sdate = new SimpleDateFormat("HH:mm");
		Date dateO1 = sdate.parse("10:00");
		Date dateC1 = sdate.parse("22:00");
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/rest/restRegister")
																  .param("r_licnum", "1000000011")
																  .param("u_id", "bs11")
																  .param("r_lname", "한솥 서면3호점")
																  .param("r_addr", "부산광역시 부산진구")
																  .param("r_dtad", "부전동 111-15")
																  .param("r_bname", "한솥")
																  .param("r_tel", "0703355221")
																  .param("f_code", "1")
																  .param("r_intro", "adsf")
																  .param("r_minprice", "15000")
																  .param("r_img", "r15.png")
//																  .param("roDTOList[0].r_id", "16")
//																  .param("roDTOList[0].w_code", "1")
//																  .param("roDTOList[0].r_opent", "dateO1")
//																  .param("roDTOList[0].r_closet", "dateC1")
//																  .param("roDTOList[1].r_id", "16")
//																  .param("roDTOList[1].w_code", "2")
//																  .param("roDTOList[1].r_opent", "dateO1")
//																  .param("roDTOList[1].r_closet", "dateC1")
//																  .param("roDTOList[2].r_id", "16")
//																  .param("roDTOList[2].w_code", "3")
//																  .param("roDTOList[2].r_opent", "dateO1")
//																  .param("roDTOList[2].r_closet", "dateC1")
//																  .param("roDTOList[3].r_id", "16")
//																  .param("roDTOList[3].w_code", "4")
//																  .param("roDTOList[3].r_opent", "dateO1")
//																  .param("roDTOList[3].r_closet", "dateC1")
//																  .param("roDTOList[4].r_id", "16")
//																  .param("roDTOList[4].w_code", "5")
//																  .param("roDTOList[4].r_opent", "dateO1")
//																  .param("roDTOList[4].r_closet", "dateC1")
//																  .param("roDTOList[5].r_id", "16")
//																  .param("roDTOList[5].w_code", "6")
//																  .param("roDTOList[5].r_opent", "dateO1")
//																  .param("roDTOList[5].r_closet", "dateC1")
																  .param("rcDTOList[0].r_id", "15")
																  .param("rcDTOList[0].c_code", "10")
																  .param("rcDTOList[1].r_id", "15")
																  .param("rcDTOList[1].c_code", "22")
																  .param("mDTOList[0].p_code", "0")
																  .param("mDTOList[0].r_id", "15")
																  .param("mDTOList[1].p_code", "1")
																  .param("mDTOList[1].r_id", "15")
																  .param("mDTOList[2].p_code", "2")
																  .param("mDTOList[2].r_id", "15")
																  )
				.andReturn()
				.getModelAndView()
				.getViewName();
		log.info(resultPage);
	}
	
//	@Test //c_code 가 ? 인 매장들 조회
	public void testGetList() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/rest/restList").param("c_code", "22"))
								.andReturn().getModelAndView().getModelMap()
				);
	}
	
//	@Test // 매장아이디가 ? 인 매장정보조회
	public void testGet() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/rest/restGet").param("r_id", "15"))
				.andReturn().getModelAndView().getModelMap()
				);
	}
	
//	@Test // 매장 아이디가 ? 인 매장정보수정
	public void testModify() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders
																  .post("/rest/restModify")
																  .param("r_id", "15")
																  .param("r_licnum", "1000000011")
																  .param("u_id", "bs11")
																  .param("r_lname", "한솥 서면3호점")
																  .param("r_addr", "부산광역시 부산진구")
																  .param("r_dtad", "부전동 111-15")
																  .param("r_bname", "한솥")
																  .param("r_tel", "0703355221")
																  .param("f_code", "1")
																  .param("r_intro", "adsf")
																  .param("r_minprice", "16000")
																  .param("r_img", "r015.png")
																  )
													  .andReturn()
													  .getModelAndView()
											     	  .getViewName();
		log.info(resultPage);
	}
	
//	@Test // 삭제테스트
	public void testRemove() throws Exception {
		
		String resultPage = mockMvc.perform(MockMvcRequestBuilders
															.post("/rest/restRemove")
															.param("r_id", "15"))
											.andReturn()
											.getModelAndView()
											.getViewName();
	log.info(resultPage);
	}
}
