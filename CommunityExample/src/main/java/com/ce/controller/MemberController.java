package com.ce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {

	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinForm(Model model) {
		String view=null;
		
		model.addAttribute("title", "회원가입");
		view="Member/join";
		return view;
	}
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(Model model) {
		String view=null;
		
		model.addAttribute("title", "");
		view="";
		return view;
	}
	
	@RequestMapping(value="/find_account", method=RequestMethod.GET)
	public String findAccountForm(Model model) {
		String view=null;
		
		model.addAttribute("title", "계정찾기");
		view="Member/find_account";
		return view;
	}

	@RequestMapping(value = "/find_account", method = RequestMethod.POST)
	public String findAccount(Model model) {
		String view=null;
		
		model.addAttribute("title", "");
		view="";
		return view;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm(Model model) {
		String view=null;
		
		model.addAttribute("title", "로그인");
		view="Member/login";
		return view;
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(Model model) {
		String view=null;
		
		model.addAttribute("title", "");
		view="";
		return view;
	}

	@RequestMapping(value="/member_info")
	public String memberInfo(Model model) {
		String view=null;
		
		model.addAttribute("title", "회원정보");
		view="Member/member_info";
		return view;
	}
	
	@RequestMapping(value="/modify_info", method = RequestMethod.GET)
	public String modifyInfoForm(Model model) {
		String view=null;
		
		model.addAttribute("title", "회원정보 수정");
		view="Member/modify_info";
		return view;
	}
	
	@RequestMapping(value="/modify_info", method = RequestMethod.POST)
	public String modifyInfo(Model model) {
		String view=null;
		
		model.addAttribute("title", "");
		view="";
		return view;
	}
	
	@RequestMapping(value="withdraw", method = RequestMethod.GET)
	public String withdrawForm(Model model) {
		String view=null;
		
		model.addAttribute("title", "회원탈퇴");
		view="Member/withdraw";
		return view;
	}
	
	@RequestMapping(value="withdraw", method = RequestMethod.POST)
	public String withdraw(Model model) {
		String view=null;
		
		model.addAttribute("title", "");
		view="";
		return view;
	}
}
