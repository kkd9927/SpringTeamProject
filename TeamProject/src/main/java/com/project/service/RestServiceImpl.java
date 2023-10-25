package com.project.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.project.domain.CatcodeDTO;
import com.project.domain.MethodDTO;
import com.project.domain.RestCatDTO;
import com.project.domain.RestDTO;
import com.project.domain.RestOpenDTO;
import com.project.mapper.RestMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class RestServiceImpl implements RestService{
	private RestMapper mapper;
	
	@Override
	public void register(RestDTO rest) {
		log.info("register....." + rest + rest.getRoDTOList() + rest.getRcDTOList() + rest.getMDTOList());
		mapper.insert(rest);
		for(RestOpenDTO data : rest.getRoDTOList()) {
			mapper.insertOpen(data);
		}
		
		for(RestCatDTO data : rest.getRcDTOList()) {
			mapper.insertCat(data);
		}
		
		for(MethodDTO data : rest.getMDTOList()) {
			mapper.insertMethod(data);
		}
		
	}

	@Override
	public ArrayList<RestDTO> getList(Long c_code) {
		log.info("getList......");
		return mapper.getList(c_code);
	}

	@Override
	public RestDTO get(Long r_id) {
		log.info("get......" + r_id);
		return mapper.read(r_id);
	}

	@Override
	public RestOpenDTO getOpen(Long r_id, Long w_code) {
		log.info("getOpen......" + r_id + w_code);
		return mapper.readOpen(r_id, w_code);
	}
	
	@Override
	public ArrayList<RestOpenDTO> getOpenList(Long r_id) {
		log.info("getOpenList....." + r_id);
		return mapper.getOpenList(r_id);
	}

	@Override
	public ArrayList<RestCatDTO> getCatList(Long r_id) {
		log.info("getCatList....." + r_id);
		return mapper.getCatList(r_id);
	}

	@Override
	public ArrayList<MethodDTO> getMethodList(Long r_id) {
		log.info("getMethodList....." + r_id);
		return mapper.getMethodList(r_id);
	}

	@Override
	public boolean modify(RestDTO rest) {
		log.info("modify....."+rest);
		
		try {
			mapper.update(rest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			for(RestOpenDTO data : rest.getRoDTOList()) {
				mapper.updateOpen(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean remove(Long r_id) {
		log.info("remove ......." + r_id);
		
		try {
			mapper.deleteMethod(r_id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			mapper.deleteCat(r_id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			mapper.deleteOpen(r_id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			mapper.delete(r_id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public ArrayList<CatcodeDTO> getCodeList() {
		log.info("getCodeList......");
		return mapper.getCodeList();
	}

}
