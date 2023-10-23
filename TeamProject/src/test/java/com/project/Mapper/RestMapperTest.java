package com.project.Mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.domain.MenuAddDTO;
import com.project.domain.MethodDTO;
import com.project.domain.RestCatDTO;
import com.project.domain.RestDTO;
import com.project.domain.RestOpenDTO;
import com.project.mapper.RestMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.project.config.RootConfig.class})
@Log4j
public class RestMapperTest {
	
	@Setter(onMethod_ = @Autowired)
	private RestMapper mapper;
	
//	@Test
	public void testInsert() {
		RestDTO rest = new RestDTO();
		
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
		
		mapper.insert(rest);
		
		log.info(rest);
	}
	
//	@Test
	public void testInsertOpen() throws Exception {
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
		
//		restopen1.setR_id(12);
//		restopen1.setW_code(0);
//		restopen1.setR_opent(date0);
//		restopen1.setR_closet(date0);
//		roDTOList.add(restopen1);
		
		restopen2.setR_id(12);
		restopen2.setW_code(1);
		restopen2.setR_opent(dateO1);
		restopen2.setR_closet(dateC1);
		roDTOList.add(restopen2);
		
		restopen3.setR_id(12);
		restopen3.setW_code(2);
		restopen3.setR_opent(dateO1);
		restopen3.setR_closet(dateC1);
		roDTOList.add(restopen3);
		
		restopen4.setR_id(12);
		restopen4.setW_code(3);
		restopen4.setR_opent(dateO1);
		restopen4.setR_closet(dateC1);
		roDTOList.add(restopen4);
		
		restopen5.setR_id(12);
		restopen5.setW_code(4);
		restopen5.setR_opent(dateO1);
		restopen5.setR_closet(dateC1);
		roDTOList.add(restopen5);
		
		restopen6.setR_id(12);
		restopen6.setW_code(5);
		restopen6.setR_opent(dateO1);
		restopen6.setR_closet(dateC1);
		roDTOList.add(restopen6);
		
		restopen7.setR_id(12);
		restopen7.setW_code(6);
		restopen7.setR_opent(dateO1);
		restopen7.setR_closet(dateC1);
		roDTOList.add(restopen7);
		
		for(RestOpenDTO data : roDTOList){
			mapper.insertOpen(data);
		}
		
		log.info(roDTOList);
	}
	
//	@Test
	public void insertCat() {
		RestCatDTO restCat1 = new RestCatDTO();
		RestCatDTO restCat2 = new RestCatDTO();
		ArrayList<RestCatDTO> rcDTOList = new ArrayList<>();
		
		restCat1.setR_id(12);
		restCat1.setC_code(10);
		rcDTOList.add(restCat1);
		
		restCat2.setR_id(12);
		restCat2.setC_code(22);
		rcDTOList.add(restCat2);
		
		for(RestCatDTO data : rcDTOList){
			mapper.insertCat(data);
		}
		log.info(rcDTOList);
	}
	
//	@Test
	public void insertMethod() {
		MethodDTO method1 = new MethodDTO();
		MethodDTO method2 = new MethodDTO();
		MethodDTO method3 = new MethodDTO();
		ArrayList<MethodDTO> mDTOList = new ArrayList<>();
		
		method1.setP_code(0);
		method1.setR_id(12);
		mDTOList.add(method1);
		
		method2.setP_code(1);
		method2.setR_id(12);
		mDTOList.add(method2);
		
		method3.setP_code(2);
		method3.setR_id(12);
		mDTOList.add(method3);
		
		for(MethodDTO data : mDTOList){
			mapper.insertMethod(data);
		}
		log.info(mDTOList);
	}
	
//	@Test
	public void testGetList() {
		mapper.getList(22L).forEach(rest -> log.info(rest));
	}
	
//	@Test
	public void testRead() {
		RestDTO rest = mapper.read(12L);
		
		log.info(rest);
	}
	
	@Test
	public void testReadOpen() {
		RestOpenDTO restOpen = mapper.readOpen(14L, 1L);
		
		log.info(restOpen);
	}
	
//	@Test
	public void testGetOpenList() {
		mapper.getOpenList(12L).forEach(restOpen -> log.info(restOpen));
	}
	
//	@Test
	public void testGetCatList() {
		mapper.getCatList(12L).forEach(restCat -> log.info(restCat));
	}
	
//	@Test
	public void testGetMethodList() {
		mapper.getMethodList(12L).forEach(restMethod -> log.info(restMethod));
	}
	
//	@Test
	public void testUpdate() {
		RestDTO rest = new RestDTO();
		
		rest.setR_id(12);
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
		rest.setR_img("r12.png");
		
		int count = mapper.update(rest);
		log.info("update count: "+ count);
	}
	
//	@Test
	public void testUpdateOpen() throws Exception {
		
		SimpleDateFormat sdate = new SimpleDateFormat("HH:mm");
		Date dateO1 = sdate.parse("10:00");
		Date dateC1 = sdate.parse("22:00");
		RestOpenDTO restOpen = new RestOpenDTO();
		
		restOpen.setR_id(12);
		restOpen.setW_code(1);
		restOpen.setR_opent(dateO1);
		restOpen.setR_closet(dateC1);
		
		int count = mapper.updateOpen(restOpen);
		log.info("updateOpen count: " + count);
	}
	
//	@Test
	public void testDeleteMethod() {
		log.info("Delete count: " + mapper.deleteMethod(12L));
	}
	
//	@Test
	public void testDeleteCat() {
		log.info("Delete count: " + mapper.deleteCat(12L));
	}
	
//	@Test
	public void testDeleteOpen() {
		log.info("Delete count: " + mapper.deleteOpen(12L));
	}
	
//	@Test
	public void testDelete() {
		log.info("Delete count: " + mapper.delete(12L));
	}
}
