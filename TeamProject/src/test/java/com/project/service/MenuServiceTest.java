package com.project.service;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.domain.MenuAddDTO;
import com.project.domain.MenuDTO;
import com.project.service.MenuService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.project.config.RootConfig.class})
@Log4j
public class MenuServiceTest {

	@Setter (onMethod_ = {@Autowired})
	private MenuService service;
	
//	@Test
	public void testRegister() {
		MenuDTO menu = new MenuDTO();
		MenuAddDTO menuAdd1 = new MenuAddDTO();
		MenuAddDTO menuAdd2 = new MenuAddDTO();
		ArrayList<MenuAddDTO> maDTOList = new ArrayList<MenuAddDTO>();
		
		menu.setR_id(1);
		menu.setM_name("z");
		menu.setM_price(3500);
		menu.setM_cat("z메뉴류");
		menu.setM_intro("z메뉴소개");
		menu.setM_code(0);
		menu.setM_img("m022.png");
		
		menuAdd1.setM_id(16);
		menuAdd1.setA_name("사이드메뉴a추가");
		menuAdd1.setA_price(11000);
		maDTOList.add(menuAdd1);
		
		menuAdd2.setM_id(16);
		menuAdd2.setA_name("사이드메뉴b추가");
		menuAdd2.setA_price(12000);
		maDTOList.add(menuAdd2);
		
		menu.setMaDTOList(maDTOList);
		service.register(menu);
//		service.register(menu, maDTOList);
		
		log.info("생성된 메뉴 아이디 : " + menu.getM_id());
		log.info(maDTOList);
	}
	
//	@Test
	public void testGetList() {
		service.getList(1L).forEach(menu -> log.info(menu));
	}
	
//	@Test
	public void testGet() {
		log.info(service.get(16L));
	}
	
//	@Test
	public void testGetAdd() {
		log.info(service.getAdd(20L));
	}
	
//	@Test
	public void testGetAddList() {
		log.info(service.getAddListM(1L));
	}
	
//	@Test
	public void testDelete() {
		log.info("Remove Result: " + service.remove(15L));
	}
	
//	@Test
	public void testUpdate() {
		MenuDTO menu = service.get(16L);
		MenuAddDTO menuadd1 = service.getAdd(20L);
		MenuAddDTO menuadd2 = service.getAdd(21L);
		ArrayList<MenuAddDTO> maDTOList = service.getAddListM(16L);
		
		if(menu == null) {
			return;
		}
		
		menu.setM_name("l");
		menu.setM_cat("l메뉴류");
		menu.setM_intro("l메뉴소개");
		
		menuadd1.setA_name("c사이드메뉴추가");
		menuadd1.setA_price(13000);
		maDTOList.add(menuadd1);
		
		menuadd2.setA_name("d사이드메뉴추가");
		menuadd2.setA_price(14000);
		maDTOList.add(menuadd2);
		
		menu.setMaDTOList(maDTOList);
		
		log.info("Modify result: " + service.modify(menu));
	}
}
