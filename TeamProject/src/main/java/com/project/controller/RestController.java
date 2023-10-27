package com.project.controller;

import java.io.File;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.domain.RestDTO;
import com.project.domain.RestOpenDTO;
import com.project.service.MenuService;
import com.project.service.RestService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/rest/*")
@AllArgsConstructor
public class RestController {

	private RestService service;
	private MenuService service2;
	
	@GetMapping("/restRegister")
	public void register() {
		
	}
	@GetMapping("restList") // 가게 목록 조회
	public void list(@RequestParam("c_code") Long c_code, Model model) {
		log.info("list");
		model.addAttribute("list", service.getList(c_code));
		model.addAttribute("category", service.getCodeList());
	}
	
	@PostMapping("/restRegister") // 가게 정보 입력
	public String register(RestDTO rest, RedirectAttributes rttr) {
		log.info("register: " + rest);
//		String path = "/resources/upload";
//		files.forEach(file -> {
//			log.info("---------------------");
//			log.info("upload file name : " + file.getOriginalFilename());
//			log.info("upload file size : " + file.getSize());
//			
//			File savefile = new File(path, file.getOriginalFilename()); 
//			try {
//				file.transferTo(savefile);
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		});
		service.register(rest);
		rttr.addFlashAttribute("result", rest.getR_id());
		return "redirect:/rest/restList?c_code=0";
	}
	
	@GetMapping({"/restGet", "/restModify", "/restManage"}) // 가게 1개조회 (가게 정보수정창 출력)
	public void get(@RequestParam("r_id") Long r_id, Model model) {
		log.info("get");
		model.addAttribute("rest", service.get(r_id));
		model.addAttribute("restOpen", service.getOpen(r_id));
		model.addAttribute("restClosed", service.getClosed(r_id));
		model.addAttribute("restCat", service.getCatList(r_id));
		model.addAttribute("restMethod", service.getMethodList(r_id));
		model.addAttribute("menuList", service2.getList(r_id));
		model.addAttribute("menuCatList", service2.getCatList(r_id));
	}
	
	@PostMapping("/restModify") // 가게정보 수정
	public String modify (RestDTO rest, RedirectAttributes rttr) {
		log.info("modify: " + rest);
		if(service.modify(rest)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/rest/restList?c_code=0";
	}
	
	@RequestMapping(value="/restRemove" , method = {RequestMethod.GET, RequestMethod.POST})
	public String remove(@RequestParam("r_id") Long r_id, RedirectAttributes rttr) {
		log.info("remove...." + r_id);
		if(service.remove(r_id)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/rest/restList?c_code=0";
	}
}
