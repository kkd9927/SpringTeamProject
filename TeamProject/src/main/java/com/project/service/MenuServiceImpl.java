package com.project.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.project.domain.MenuAddDTO;
import com.project.domain.MenuDTO;
import com.project.mapper.MenuMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MenuServiceImpl implements MenuService{
	
	private MenuMapper mapper;
	
	@Override
//	public void register(MenuDTO menu, ArrayList<MenuAddDTO> maDTOList) {
	public void register(MenuDTO menu) {
		log.info("register......" + menu + menu.getMaDTOList());
		int m_id = mapper.insertMid();
		menu.setM_id(m_id);
		mapper.insertM(menu);
		for(MenuAddDTO data : menu.getMaDTOList()){
			data.setM_id(m_id);
			mapper.insertAdd(data);
		}
	}

	@Override
	public MenuDTO get(Long m_id) {
		log.info("get......" + m_id);
		return mapper.read(m_id);
	}

	@Override
	public MenuAddDTO getAdd(Long a_id) {
		log.info("get......" + a_id);
		return mapper.readAdd(a_id);
	}
	
	@Override
	public ArrayList<MenuAddDTO> getAddListM(Long m_id) {
		log.info("getAddList......" + m_id);
		return mapper.getAddListM(m_id);
	}
	@Override
	public ArrayList<MenuAddDTO> getAddListR(Long r_id) {
		log.info("getAddList......" + r_id);
		return mapper.getAddListR(r_id);
	}

	@Override
	public ArrayList<MenuDTO> getList(Long r_id) {
		log.info("getList......");
		return mapper.getList(r_id);
	}

	@Override
	public boolean modify(MenuDTO menu) {
		log.info("modify......."+menu);
		
		try {
			mapper.update(menu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			for(MenuAddDTO data : menu.getMaDTOList()) {
				mapper.updateAdd(data);
			}
		}catch (Exception e) {
				e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean remove(Long m_id) {
		log.info("remove......"+m_id);
		
		try {
			mapper.deleteAdd(m_id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			mapper.delete(m_id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public ArrayList<MenuDTO> getCatList(Long r_id) {
		log.info("getCatList......");
		return mapper.getCatList(r_id);
	}

}
