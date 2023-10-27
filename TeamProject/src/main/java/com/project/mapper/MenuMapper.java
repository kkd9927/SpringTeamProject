package com.project.mapper;

import java.util.ArrayList;

import com.project.domain.MenuAddDTO;
import com.project.domain.MenuDTO;

public interface MenuMapper {

	public void insertM(MenuDTO menu);

	public void insertAdd(MenuAddDTO menuAdd);

	public MenuDTO read(Long m_id);

	public MenuAddDTO readAdd(Long a_id);

	public ArrayList<MenuDTO> getList(Long r_id);

	public ArrayList<MenuDTO> getCatList(Long r_id);

	public ArrayList<MenuAddDTO> getAddListM(Long m_id);

	public ArrayList<MenuAddDTO> getAddListR(Long r_id);

	public int update(MenuDTO menu);

	public int updateAdd(MenuAddDTO menuAdd);

	public int delete(Long m_id);

	public int deleteAdd(Long m_id);
}
