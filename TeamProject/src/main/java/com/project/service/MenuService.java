package com.project.service;

import java.util.ArrayList;

import com.project.domain.MenuAddDTO;
import com.project.domain.MenuDTO;

public interface MenuService {
//	public void register (MenuDTO menu, ArrayList<MenuAddDTO> maDTOList);
	public void register (MenuDTO menu);
	
	public MenuDTO get(Long m_id);

	public MenuAddDTO getAdd(Long a_id);
	
	public ArrayList<MenuAddDTO> getAddList(Long m_id);
	
	public ArrayList<MenuDTO> getList(Long r_id);

	public ArrayList<MenuDTO> getCatList(Long r_id);
	
	public boolean modify (MenuDTO menu);
	
	public boolean remove (Long m_id);
}
