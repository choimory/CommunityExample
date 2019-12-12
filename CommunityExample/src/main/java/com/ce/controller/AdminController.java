package com.ce.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ce.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private AdminService adminService;

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	@RequestMapping(value = "/ban", method = RequestMethod.GET)
	public String banForm(Model model) {
		String view = null;

		view = "Admin/ban";
		
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/ban", method = RequestMethod.POST)
	public String ban(Model model, @RequestParam Map<String,Object>paramMap) {
		String view = null;

		// TODO 입력받은 id를 대상으로 해당회원의 ban컬럼값을 전환

		view = "Admin/ban";
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/check_report")
	public String reportList(Model model) {
		String view = null;

		// TODO report갯수가 높은 글들을 가져오기

		view = "Admin/check_report";
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/check_item")
	public String checkItem(Model model) {
		String view = null;

		// TODO 판매허가 대기중인 shop글들을 가져오기

		view = "Admin/check_item";
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/permission", method = RequestMethod.POST)
	public String permissionItem(Model model, @RequestParam Map<String,Object>paramMap) {
		String view = null;

		// TODO idx에 해당하는 아이템의 판매허가컬럼의 값을 변경

		view = "";
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/create_board", method = RequestMethod.GET)
	public String createBoardForm(Model model) {
		String view = null;

		view = "Admin/create_board";
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/create_board", method = RequestMethod.POST)
	public String createBoard(Model model, @RequestParam Map<String,Object>paramMap) {
		String view = null;

		// TODO 게시판 카테고리/게시판명/글분류 값을 받아서 카테고리에 해당되는 테이블의 BOARD_ID컬럼에 게시판명을 입력하고 글분류를 입력

		view = "Admin/create_board";
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/blind")
	public String blind(Model model) {
		String view = null;

		// TODO 글idx값을 받아 해당 idx의 글의 blind컬럼값을 변경

		view = "Admin/report";
		model.addAttribute("title", "");
		return view;
	}
	
	@RequestMapping(value="/main")
	public String main(Model model) {
		String view=null;
		
		view="Admin/main";
		model.addAttribute("title", "");
		return view;
	}

}
