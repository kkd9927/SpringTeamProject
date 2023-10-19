package com.project.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.domain.MenuAddDTO;
import com.project.domain.MenuDTO;
import com.project.service.MenuService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/menu/*")
@AllArgsConstructor
public class MenuController {
	
	private MenuService service;
	
	@GetMapping("/list") // 메뉴 목록 조회
	public void list(@RequestParam("r_id") Long r_id, Model model) {
		log.info("list");
		model.addAttribute("list", service.getList(r_id));
	}
	
	@PostMapping("/register") //메뉴 입력
	public String register(MenuDTO menu, ArrayList<MenuAddDTO> maDTOList, RedirectAttributes rttr) {
		log.info("register: " + menu);
		service.register(menu,maDTOList);
		rttr.addFlashAttribute("result", menu.getM_id());
		return "redirect:/menu/list";
	}
	
	@GetMapping({"/get", "/modify"}) // 메뉴 1개 조회 (그리고 메뉴 1개 정보 수정창 출력)
	public void get(@RequestParam("m_id") Long m_id, Model model) {
		log.info("/get");
		model.addAttribute("menu", service.get(m_id));
		model.addAttribute("menuAdd", service.getAddList(m_id));
	}
	
	@PostMapping("/modify") // 메뉴 1개 수정
	public String modify (MenuDTO menu, ArrayList<MenuAddDTO> maDTOList, RedirectAttributes rttr) {
		log.info("modify: "+menu);
		if(service.modify(menu, maDTOList)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/menu/list";
	}
	@RequestMapping(value="/remove" , method= {RequestMethod.GET,RequestMethod.POST})
	public String remove(@RequestParam("m_id") Long m_id, RedirectAttributes rttr) {
		log.info("remove...."+m_id);
		if(service.remove(m_id)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/menu/list";
	}
}
