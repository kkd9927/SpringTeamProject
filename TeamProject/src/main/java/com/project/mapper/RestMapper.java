package com.project.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.project.domain.CatcodeDTO;
import com.project.domain.MethodDTO;
import com.project.domain.RestCatDTO;
import com.project.domain.RestClosedDTO;
import com.project.domain.RestDTO;
import com.project.domain.RestOpenDTO;

public interface RestMapper {
	
	public void insertR(RestDTO rest);

	public void insertOpen(RestOpenDTO restOpen);

	public void insertClosed(RestClosedDTO restClosed);
	
	public void insertCat (RestCatDTO restCat);

	public void insertMethod (MethodDTO method);
	
	public ArrayList<RestDTO> getList(Long c_code);
	
	public ArrayList<CatcodeDTO> getCodeList();
	
	public RestDTO read(Long r_id);
	
	public RestOpenDTO readOpen(@Param("r_id") Long r_id,@Param("w_code") Long w_code);
	
	public ArrayList<RestOpenDTO> getOpenList(Long r_id);

	public ArrayList<RestClosedDTO> getClosedList(Long r_id);

	public ArrayList<RestCatDTO> getCatList(Long r_id);

	public ArrayList<MethodDTO> getMethodList(Long r_id);
	
	public int update(RestDTO rest);

	public int updateOpen(RestOpenDTO restOpen);

	public int updateClosed(RestClosedDTO restClosed);

//	public int updateCat(RestCatDTO restCat); 추가 삭제만 필요

//	public int updateMethod(MethodDTO method); 추가 삭제만 필요
	
	public int delete(Long r_id);
	
	public int deleteOpen(Long r_id);

	public int deleteClosed(Long r_id);

	public int deleteCat(Long r_id);

	public int deleteMethod(Long r_id);
	
	
}
