package com.ce.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ce.component.PageHelper;
import com.ce.dto.BoardDTO;
import com.ce.dto.BoardInfoDTO;
import com.ce.dto.BoardTypeDTO;
import com.ce.dto.MemberDTO;
import com.ce.dto.MemberInfoDTO;
import com.ce.dto.ShopDTO;
import com.ce.dto.ShopInfoDTO;
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
		String view = "Admin/ban";

		model.addAttribute("title", "회원 이용정지");
		return view;
	}

	@RequestMapping(value = "/ban", method = RequestMethod.POST)
	public String ban(Model model, MemberDTO memberDto, MemberInfoDTO memberInfoDto) {
		String view = "Admin/ban";
		int result = 0;

//		result=adminService.ban(memberDto, memberInfoDto);

//		model.addAttribute("title", "회원 이용정지");
		model.addAttribute("result", result);
		return view;
	}

	@RequestMapping(value = "/check_report")
	public String checkReport(Model model, PageHelper pageHelper) {
		String view = "Admin/check_report";
		List<BoardDTO> boardDtoList = null;

//		boardDtoList=adminService.checkReport(pageHelper);

		model.addAttribute("title", "신고검토");
		model.addAttribute("boardDtoList", boardDtoList);
		return view;
	}

	@RequestMapping(value = "/check_item")
	public String checkItem(Model model, PageHelper pageHelper) {
		String view = "Admin/check_item";
		List<ShopDTO> shopDtoList = null;

//		shopDtoList=adminService.checkItem(pageHelper);

		model.addAttribute("title", "판매검토");
		model.addAttribute("shopDtoList", shopDtoList);
		return view;
	}

	@RequestMapping(value = "/permission", method = RequestMethod.POST)
	public String permissionItem(Model model, int sIdx) {
		String view = "redirect:/admin/check_item";
		int result = 0;

//		result=adminService.permissionItem(sIdx);		

		model.addAttribute("result", result);
		return view;
	}

	@RequestMapping(value = "/create_board", method = RequestMethod.GET)
	public String createBoardForm(Model model) {
		String view = "Admin/create_board";

		model.addAttribute("title", "게시판/글 카테고리 생성");
		return view;
	}

	@RequestMapping(value = "/create_board", method = RequestMethod.POST)
	public String createBoard(Model model, BoardTypeDTO boardTypeDto) {
		String view = "Admin/create_board";
		int result = 0;

//		result=adminService.createBoard(boardTypeDto);

		model.addAttribute("title", "게시판/글 카테고리 생성");
		model.addAttribute("result", result);
		return view;
	}

	@RequestMapping(value = "/blind")
	public String blind(Model model, BoardDTO boardDto, HttpServletRequest req) {
		String view = "redirect:/admin/check_report"; // TODO 나중에 신고검토 게시판 외에서도 블라인드 기능 넣을시엔 req로 이전주소 알아내서 해당주소로 돌아갈수 있도록 변경
		String beforeUrl = req.getHeader("referer");
		int result = 0;

//		result=adminService.blind(boardDto);

		model.addAttribute("result", result);
		return view;
	}

	@RequestMapping(value = "/main")
	public String main(Model model) {
		String view = "Admin/main";
		Map<String, Object> dtoListMap = null;

//		dtoListMap=adminService.main();

		model.addAttribute("title", "운영메뉴");
		model.addAttribute("dtoListMap", dtoListMap);
		return view;
	}

}
