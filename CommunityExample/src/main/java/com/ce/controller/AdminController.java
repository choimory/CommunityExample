package com.ce.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ce.component.PageHelper;
import com.ce.component.SearchHelper;
import com.ce.dto.BoardDTO;
import com.ce.dto.BoardInfoDTO;
import com.ce.dto.BoardTypeDTO;
import com.ce.dto.MemberBanDTO;
import com.ce.dto.MemberDTO;
import com.ce.dto.MemberInfoDTO;
import com.ce.dto.ShopDTO;
import com.ce.dto.ShopInfoDTO;
import com.ce.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	private final int SUCCESS = 1;
	private final int FAIL = -1;

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	@RequestMapping(value = { "", "/", "/main}" })
	public String main(Model model) {
		String view = "Admin/main";
		Map<String, Object> dtoListMap = null;

//		dtoListMap=adminService.main();
//		if(dtoListMap==null) {
//		}

		model.addAttribute("title", "운영메뉴");
		model.addAttribute("dtoListMap", dtoListMap);
		return view;
	}

	@RequestMapping(value = "/ban", method = RequestMethod.GET)
	public String banForm(Model model, String mId) {
		String view = "Admin/ban";

		model.addAttribute("mId", mId);
		model.addAttribute("title", "회원 이용정지");
		return view;
	}

	@RequestMapping(value = "/ban", method = RequestMethod.POST)
	public String ban(Model model, MemberBanDTO memberBanDto) {
		String view = "Admin/ban";
		int result = 0;

		result = adminService.ban(memberBanDto);
		if (result != SUCCESS) {
			result = FAIL;
		}

		model.addAttribute("title", "회원 이용정지");
		model.addAttribute("result", result);
		return view;
	}

	@RequestMapping(value = "/check_report", method = RequestMethod.GET)
	public String checkReport(Model model, PageHelper pageHelper, SearchHelper searchHelper) {
		String view = "Admin/check_report";
		List<BoardDTO> boardDtoList = null;

		boardDtoList = adminService.checkReport(pageHelper);
//		if(boardDtoList==null) {			
//		}

		model.addAttribute("title", "신고검토");
		model.addAttribute("boardDtoList", boardDtoList);
		model.addAttribute("pageHelper", pageHelper);
		return view;
	}

	@RequestMapping(value = "/check_item", method = RequestMethod.GET)
	public String checkItem(Model model, PageHelper pageHelper, SearchHelper searchHelper) {
		String view = "Admin/check_item";
		List<ShopDTO> shopDtoList = null;

		shopDtoList = adminService.checkItem(pageHelper);
//		if(shopDtoList==null) {
//		}

		model.addAttribute("title", "판매검토");
		model.addAttribute("shopDtoList", shopDtoList);
		model.addAttribute("pageHelper", pageHelper);
		return view;
	}

	@RequestMapping(value = "/permission", method = RequestMethod.POST)
	public String permissionItem(Model model, int sIdx, int sPermission, PageHelper pageHelper,
			SearchHelper searchHelper) {
		String view = "redirect:/admin/check_item?page=" + pageHelper.getPage();
		int result = 0;

//		result=adminService.permissionItem(sIdx, sPermission);		

		model.addAttribute("result", result);
		model.addAttribute("pageHelper", pageHelper);
		return view;
	}

	@RequestMapping(value = "/create_board", method = RequestMethod.GET)
	public String createBoardForm(Model model) {
		String view = "Admin/create_board";
		List<String> boardTypeKorList = null;

		boardTypeKorList = adminService.createBoardGet();

		model.addAttribute("title", "게시판 생성");
		model.addAttribute("boardTypeKorList", boardTypeKorList);
		return view;
	}

	@RequestMapping(value = "/create_board", method = RequestMethod.POST)
	public String createBoard(Model model, BoardTypeDTO boardTypeDto) {
		String view = "Admin/create_board";
		int result = 0;

		result = adminService.createBoardPost(boardTypeDto);

		model.addAttribute("title", "게시판 생성");
		model.addAttribute("result", result);
		return view;
	}

	@RequestMapping(value = "/blind", method = RequestMethod.POST)
	public String blind(Model model, BoardDTO boardDto, PageHelper pageHelper, HttpServletRequest req,
			SearchHelper searchHelper) {
		String view = "redirect:/admin/check_report?page=" + pageHelper.getPage(); // TODO 나중에 신고검토 게시판 외에서도 블라인드 기능
																					// 넣을시엔 req로 이전주소 알아내서 해당주소로 돌아갈수
																					// 있도록 변경
		String beforeUrl = req.getHeader("referer");
		int result = 0;

//		result=adminService.blind(boardDto);

		model.addAttribute("result", result);
		model.addAttribute("pageHelper", pageHelper);
		return view;
	}

	@RequestMapping(value = "/create_board_type", method = RequestMethod.GET)
	public String createBoardTypeGet(Model model) {
		String view = "Admin/create_board_type";
		
		model.addAttribute("title", "게시판 분류 신설");
		return view;
	}

	@RequestMapping(value = "/create_board_type", method = RequestMethod.POST)
	public String createBoardTypePost() {
		String view = "Admin/create_board_type";
		
		return view;
	}

	@RequestMapping(value = "/add_board_category", method = RequestMethod.GET)
	public String addBoardCategoryGet(Model model) {
		String view = "Admin/add_board_category";
		List<String> bIdKorList=null;
		
		bIdKorList=adminService.addBoardCategoryGet();
		
		model.addAttribute("title", "게시판 카테고리 추가");
		model.addAttribute("bIdKorList", bIdKorList);
		return view;
	}

	@RequestMapping(value = "/add_board_category", method = RequestMethod.POST)
	public String addBoardCategoryPost(Model model, String bIdKor, String bCategory) {
		String view = "Admin/add_board_category";
		int result=0;
		
		result=adminService.addBoardCategoryPost(bIdKor, bCategory);
		
		model.addAttribute("title", "게시판 카테고리 추가");
		model.addAttribute("result", result);
		return view;
	}
}
