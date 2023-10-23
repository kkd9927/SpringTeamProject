package com.project.mapper;

import java.util.ArrayList;

import com.project.domain.MethodDTO;
import com.project.domain.RestCatDTO;
import com.project.domain.RestDTO;
import com.project.domain.RestOpenDTO;

public interface RestMapper {
	
	public void insert(RestDTO rest);

	public void insertOpen(RestOpenDTO restOpen);
	
	public void insertCat (RestCatDTO restCat);

	public void insertMethod (MethodDTO method);
	
	public ArrayList<RestDTO> getList(Long c_code);
	
	public RestDTO read(Long r_id);
	
	public RestOpenDTO readOpen(Long r_id, Long w_code);
	
	public ArrayList<RestOpenDTO> getOpenList(Long r_id);

	public ArrayList<RestCatDTO> getCatList(Long r_id);

	public ArrayList<MethodDTO> getMethodList(Long r_id);
	
	public int update(RestDTO rest);

	public int updateOpen(RestOpenDTO restOpen);

//	public int updateCat(RestCatDTO restCat); 추가 삭제만 필요

//	public int updateMethod(MethodDTO method); 추가 삭제만 필요
	
	public int delete(Long r_id);
	
	public int deleteOpen(Long r_id);

	public int deleteCat(Long r_id);

	public int deleteMethod(Long r_id);
	
	
}
