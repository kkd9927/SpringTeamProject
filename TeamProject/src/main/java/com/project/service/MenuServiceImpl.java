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
	public void register(MenuDTO menu, ArrayList<MenuAddDTO> maDTOList) {
		log.info("register......" + menu + maDTOList);
		mapper.insert(menu);
		for(MenuAddDTO data : maDTOList){
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
	public ArrayList<MenuAddDTO> getAddList(Long m_id) {
		log.info("getAddList......" + m_id);
		return mapper.getAddList(m_id);
	}

	@Override
	public ArrayList<MenuDTO> getList(Long r_id) {
		log.info("getAddList......");
		return mapper.getList(r_id);
	}

	@Override
	public boolean modify(MenuDTO menu, ArrayList<MenuAddDTO> maDTOList) {
		log.info("modify......."+menu);
		
		try {
			mapper.update(menu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			for(MenuAddDTO data : maDTOList) {
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

}
