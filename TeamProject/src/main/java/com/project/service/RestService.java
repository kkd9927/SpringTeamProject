package com.project.service;

import java.util.ArrayList;

import com.project.domain.MethodDTO;
import com.project.domain.RestCatDTO;
import com.project.domain.RestDTO;
import com.project.domain.RestOpenDTO;

public interface RestService {

	public void register (RestDTO rest);
	
	public ArrayList<RestDTO> getList(Long c_code);
	
	public RestDTO get(Long r_id);
	
	public RestOpenDTO getOpen(Long r_id, Long w_code);
	
	public ArrayList<RestOpenDTO> getOpenList (Long r_id);

	public ArrayList<RestCatDTO> getCatList (Long r_id);

	public ArrayList<MethodDTO> getMethodList (Long r_id);
	
	public boolean modify (RestDTO rest);
	
	public boolean remove (Long r_id);
}
