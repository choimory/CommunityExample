package com.ce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ce.service.MemberService;

@Controller
public class MemberController {
	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String joinForm(Model model) {
		String view = null;

		model.addAttribute("title", "회원가입");
		view = "Member/join";
		return view;
	}

	@RequestMapping(value = "/idcheck")
	public String idCheck(Model model) {
		String view = null;

		// TODO 받은 id로 검색해서 데이터 유무 확인

		view = ""; // TODO ajax
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/emailcheck")
	public String emailCheck(Model model) {
		String view = null;

		// TODO 받은 email로 검색해서 데이터 유무 확인

		view = ""; // TODO ajax
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(Model model) {
		String view = null;

		// TODO 받은 데이터로 row 작성

		model.addAttribute("title", "");
		view = "";
		return view;
	}

	@RequestMapping(value = "/find_account", method = RequestMethod.GET)
	public String findAccountForm(Model model) {
		String view = null;

		model.addAttribute("title", "계정찾기");
		view = "Member/find_account";
		return view;
	}

	@RequestMapping(value = "/find_account", method = RequestMethod.POST)
	public String findAccount(Model model) {
		String view = null;

		// TODO 받은 email에 해당하는 회원 비밀번호 변경한뒤 id와 임시비밀번호 이메일전송

		model.addAttribute("title", "");
		view = ""; // TODO 결과안내 폼으로 변경
		return view;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(Model model) {
		String view = null;

		model.addAttribute("title", "로그인");
		view = "Member/login";
		return view;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model) {
		String view = null;

		// TODO 아이디로 검색한뒤 해당아이디의 비밀번호와 입력값 일치시 로그인, 아닐시 실패

		model.addAttribute("title", "");
		view = ""; // TODO 이전에 접속중이던 페이지로 리다이렉트
		return view;
	}

	@RequestMapping(value = "/member_info")
	public String memberInfo(Model model) {
		String view = null;

		// TODO 세션의 id에 해당하는 회원 정보들 가져오기

		model.addAttribute("title", "회원정보");
		view = "Member/member_info";
		return view;
	}

	@RequestMapping(value = "/modify_info", method = RequestMethod.GET)
	public String modifyInfoForm(Model model) {
		String view = null;

		model.addAttribute("title", "회원정보 수정");
		view = "Member/modify_info";
		return view;
	}

	@RequestMapping(value = "/modify_info", method = RequestMethod.POST)
	public String modifyInfo(Model model) {
		String view = null;

		// TODO 입력한 값으로 해당회원 정보수정

		model.addAttribute("title", "");
		view = "Member/member_info"; // TODO 리다이렉트로 변경할것
		return view;
	}

	@RequestMapping(value = "/withdraw", method = RequestMethod.GET)
	public String withdrawForm(Model model) {
		String view = null;

		model.addAttribute("title", "회원탈퇴");
		view = "Member/withdraw";
		return view;
	}

	@RequestMapping(value = "/withdraw", method = RequestMethod.POST)
	public String withdraw(Model model) {
		String view = null;

		// TODO 해당 회원에 관련된 기본정보 삭제

		model.addAttribute("title", "");
		view = "Main/main"; // TODO 리다이렉트로 변경할것
		return view;
	}

	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	public String authForm(Model model) {
		String view = null;

		view = "Member/auth";
		return view;
	}

	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public String auth(Model model) {
		String view = null;

		view = "";
		model.addAttribute("title", "");
		return view;
	}
}
