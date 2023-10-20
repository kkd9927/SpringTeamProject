package com.project.mapper;

import java.util.ArrayList;

import com.project.domain.MenuAddDTO;
import com.project.domain.MenuDTO;

public interface MenuMapper {

	public void insert(MenuDTO menu);

	public void insertAdd(MenuAddDTO menuAdd);

	public MenuDTO read(Long m_id);

	public MenuAddDTO readAdd(Long a_id);

	public ArrayList<MenuDTO> getList(Long r_id);

	public ArrayList<MenuAddDTO> getAddList(Long m_id);

	public int update(MenuDTO menu);

	public int updateAdd(MenuAddDTO menuAdd);

	public int delete(Long m_id);

	public int deleteAdd(Long m_id);
}
