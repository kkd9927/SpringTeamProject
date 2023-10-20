package com.project.Mapper;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.domain.MenuAddDTO;
import com.project.domain.MenuDTO;
import com.project.mapper.MenuMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.project.config.RootConfig.class})
@Log4j
public class MenuMapperTest {
	
	@Setter(onMethod_ = @Autowired)
	private MenuMapper mapper;
	
//	@Test
	public void testInsert() {
		MenuDTO menu = new MenuDTO();

		menu.setR_id(1);
		menu.setM_name("h");
		menu.setM_price(3500);
		menu.setM_cat("h메뉴류");
		menu.setM_intro("h메뉴소개");
		menu.setM_code(0);
		menu.setM_img("m14.png");
		
		mapper.insert(menu);
		
		log.info(menu);
	}

//	@Test
	public void testInsertAdd() {
		MenuAddDTO menuAdd1 = new MenuAddDTO();
		MenuAddDTO menuAdd2 = new MenuAddDTO();
		ArrayList<MenuAddDTO> maDTOList = new ArrayList<MenuAddDTO>();// = {{11,"사이드추가", 5000},{11,"음료추가", 2000}};
		menuAdd1.setM_id(14);
		menuAdd1.setA_name("사이드메뉴a추가");
		menuAdd1.setA_price(11000);
		maDTOList.add(menuAdd1);
		
		menuAdd2.setM_id(14);
		menuAdd2.setA_name("사이드메뉴b추가");
		menuAdd2.setA_price(12000);
		maDTOList.add(menuAdd2);
		
		for(MenuAddDTO data : maDTOList){
			mapper.insertAdd(data);
		}
		
		log.info(maDTOList);
	}
	
//	@Test
	public void testGetList() {
		mapper.getList(1L).forEach(menu -> log.info(menu));
	}
	
//	@Test
	public void testRead() {
		MenuDTO menu = mapper.read(1L);
		
		log.info(menu);
	}
	
//	@Test
	public void testReadAdd() {
		MenuAddDTO menu = mapper.readAdd(20L);
		
		log.info(menu);
	}
	
//	@Test
	public void testGetAddList() {
		mapper.getAddList(12L).forEach(menuAdd -> log.info(menuAdd));
	}
	
//	@Test
	public void testUpdate() {
		MenuDTO menu = new MenuDTO();
		menu.setM_id(14);
		menu.setM_name("i");
		menu.setM_price(4000);
		menu.setM_cat("i메뉴류");
		menu.setM_intro("i메뉴류소개");
		menu.setM_code(0);
		menu.setM_img("m014.png");
		
		int count = mapper.update(menu);
		log.info("update count: " + count);
	}

//	@Test
	public void testUpdateAdd() {
		MenuAddDTO menuadd = new MenuAddDTO();
		menuadd.setA_id(16);
		menuadd.setA_name("사이드메뉴i추가");
		menuadd.setA_price(4000);
		
		int count = mapper.updateAdd(menuadd);
		log.info("updateAdd count: " + count);
	}
	
//	@Test
	public void testDeleteAdd() {
		log.info("Delete count : " + mapper.deleteAdd(12L));
	}
//	@Test
	public void testDelete() {
		log.info("Delete count : " + mapper.delete(11L));
	}
}
