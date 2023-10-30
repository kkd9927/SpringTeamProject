package com.project.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.project.domain.CatcodeDTO;
import com.project.domain.MethodDTO;
import com.project.domain.RestCatDTO;
import com.project.domain.RestClosedDTO;
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
		log.info("register....." + rest  + rest.getRcaDTOList() + rest.getMDTOList());
		int r_id = mapper.insertRid();
		rest.setR_id(r_id);
		rest.getRestOpen().setR_id(r_id);
		rest.getRestClosed().setR_id(r_id);
		mapper.insertR(rest);
		mapper.insertOpen(rest.getRestOpen());
		mapper.insertClosed(rest.getRestClosed());

		for(RestCatDTO data : rest.getRcaDTOList()) {
			data.setR_id(r_id);
			if(data.getC_code() != 0) {
				mapper.insertCat(data);
			}
		}
		
		for(MethodDTO data : rest.getMDTOList()) {
			data.setR_id(r_id);
			if(data.getP_code() != 0) {
				mapper.insertMethod(data);
			}
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
	public RestOpenDTO getOpen(Long r_id) {
		log.info("getOpen....." + r_id);
		return mapper.readOpen(r_id);
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
		int r_id = rest.getR_id();
		rest.getRestOpen().setR_id(r_id);
		rest.getRestClosed().setR_id(r_id);
		try {
			mapper.update(rest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			mapper.updateOpen(rest.getRestOpen());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			mapper.updateClosed(rest.getRestClosed());
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
			mapper.deleteClosed(r_id);
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

	@Override
	public RestClosedDTO getClosed (Long r_id) {
		log.info("getClosedList....." + r_id);
		return mapper.readClosed(r_id);
	}

}
