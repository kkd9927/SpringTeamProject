package com.project.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.domain.MethodDTO;
import com.project.domain.RestCatDTO;
import com.project.domain.RestDTO;
import com.project.domain.RestOpenDTO;
import com.project.service.RestService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.project.config.RootConfig.class})
@Log4j
public class RestServiceTest {

	@Setter (onMethod_ = {@Autowired})
	private RestService service;
	
//	@Test
	public void testRegister() throws Exception {
		RestDTO rest = new RestDTO();
		SimpleDateFormat sdate = new SimpleDateFormat("HH:mm");
		Date dateO1 = sdate.parse("09:00");
		Date dateC1 = sdate.parse("22:00");
//		RestOpenDTO restopen1 = new RestOpenDTO();
		RestOpenDTO restopen2 = new RestOpenDTO();
		RestOpenDTO restopen3 = new RestOpenDTO();
		RestOpenDTO restopen4 = new RestOpenDTO();
		RestOpenDTO restopen5 = new RestOpenDTO();
		RestOpenDTO restopen6 = new RestOpenDTO();
		RestOpenDTO restopen7 = new RestOpenDTO();
		ArrayList<RestOpenDTO> roDTOList = new ArrayList<>();
		RestCatDTO restCat1 = new RestCatDTO();
		RestCatDTO restCat2 = new RestCatDTO();
		ArrayList<RestCatDTO> rcaDTOList = new ArrayList<>();
		MethodDTO method1 = new MethodDTO();
		MethodDTO method2 = new MethodDTO();
		MethodDTO method3 = new MethodDTO();
		ArrayList<MethodDTO> mDTOList = new ArrayList<>();
		
		rest.setR_licnum("1000000011");
		rest.setU_id("bs11");
		rest.setR_lname("한솥 서면점");
		rest.setR_addr("부산광역시 부산진구");
		rest.setR_dtad("부전동 111-12");
		rest.setR_bname("한솥");
		rest.setR_tel("0701100010");
		rest.setF_code(1);
		rest.setR_intro("11가게소개");
		rest.setR_minprice(15000);
		rest.setR_img("r11.png");
		
//		restopen1.setR_id(12);
//		restopen1.setW_code(0);
//		restopen1.setR_opent(date0);
//		restopen1.setR_closet(date0);
//		roDTOList.add(restopen1);
		
		restopen2.setR_id(14);
		restopen2.setR_opent(dateO1);
		restopen2.setR_closet(dateC1);
		roDTOList.add(restopen2);
		
		restopen3.setR_id(14);
		restopen3.setR_opent(dateO1);
		restopen3.setR_closet(dateC1);
		roDTOList.add(restopen3);
		
		restopen4.setR_id(14);
		restopen4.setR_opent(dateO1);
		restopen4.setR_closet(dateC1);
		roDTOList.add(restopen4);
		
		restopen5.setR_id(14);
		restopen5.setR_opent(dateO1);
		restopen5.setR_closet(dateC1);
		roDTOList.add(restopen5);
		
		restopen6.setR_id(14);
		restopen6.setR_opent(dateO1);
		restopen6.setR_closet(dateC1);
		roDTOList.add(restopen6);
		
		restopen7.setR_id(14);
		restopen7.setR_opent(dateO1);
		restopen7.setR_closet(dateC1);
		roDTOList.add(restopen7);
		
//		rest.setRoDTOList(roDTOList);
		
		restCat1.setR_id(14);
		restCat1.setC_code(10);
		rcaDTOList.add(restCat1);
		
		restCat2.setR_id(14);
		restCat2.setC_code(22);
		rcaDTOList.add(restCat2);
		
		rest.setRcaDTOList(rcaDTOList);
		
		method1.setP_code(0);
		method1.setR_id(14);
		mDTOList.add(method1);
		
		method2.setP_code(1);
		method2.setR_id(14);
		mDTOList.add(method2);
		
		method3.setP_code(2);
		method3.setR_id(14);
		mDTOList.add(method3);
		
		rest.setMDTOList(mDTOList);
		
		service.register(rest);
		
		log.info(rest.getR_id());
//		log.info(rest.getRoDTOList());
		log.info(rest.getRcaDTOList());
		log.info(rest.getMDTOList());
	}
	
//	@Test
	public void testGetList() {
		service.getList(22L).forEach(rest -> log.info(rest));
	}
	
//	@Test
	public void testGet() {
		log.info(service.get(14L));
	}
	
//	@Test
	public void testGetOpen() {
		log.info(service.getOpen(1L));
	}
	
////	@Test
//	public void testGetOpenList() {
//		log.info(service.getOpenList(14L));
//	}
	
//	@Test
	public void testGetCatList() {
		log.info(service.getCatList(14L));
	}
	
//	@Test
	public void testGetMethodList() {
		log.info(service.getMethodList(14L));
	}
	
//	@Test
	public void testUpdate() throws Exception {
		RestDTO rest = service.get(14L);
		SimpleDateFormat sdate = new SimpleDateFormat("HH:mm");
		Date dateO1 = sdate.parse("10:00");
		Date dateC1 = sdate.parse("22:00");
		RestOpenDTO restOpen1 = service.getOpen(1L);
		RestOpenDTO restOpen2 = service.getOpen(2L);
		ArrayList<RestOpenDTO> roDTOList = new ArrayList<>();
		
		rest.setR_licnum("1000000011");
		rest.setU_id("bs11");
		rest.setR_lname("한솥 서면2호점");
		rest.setR_addr("부산광역시 부산진구");
		rest.setR_dtad("부전동 111-12");
		rest.setR_bname("한솥");
		rest.setR_tel("0701231231");
		rest.setF_code(1);
		rest.setR_intro("adsf");
		rest.setR_minprice(16000);
		rest.setR_img("r14.png");
		
		restOpen1.setR_opent(dateO1);
		restOpen1.setR_closet(dateC1);
		roDTOList.add(restOpen1);
		restOpen2.setR_opent(dateO1);
		restOpen2.setR_closet(dateC1);
		roDTOList.add(restOpen2);
//		rest.setRoDTOList(roDTOList);
		
		log.info("Modify result: " + service.modify(rest));
	}
	
//	@Test
	public void testDelete() {
		log.info("Remove Result: " + service.remove(14L));
	}
}
