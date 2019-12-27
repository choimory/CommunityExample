package com.ce.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ce.dto.MemberAuthDTO;
import com.ce.dto.MemberDTO;
import com.ce.service.MemberService;

@Controller
//@SessionAttributes({"memberDto"})
public class MemberController {
	private MemberService memberService;
	private final int SUCCESS = 1;
	private final int FAIL = -1;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String joinForm(Model model) {
		String view = "Member/join";

		model.addAttribute("title", "회원가입");
		return view;
	}

	@RequestMapping(value = "/idcheck")
	public String idCheck(Model model, String mId) {
		String view = ""; // TODO ajax
		int result = 0;

//		result=memberService.idCheck(mId);
//		if(result<SUCCESS) {
//		}
		
		model.addAttribute("title", "");
		model.addAttribute("result", result);
		return view;
	}

	@RequestMapping(value = "/emailcheck")
	public String emailCheck(Model model, String mEmail) {
		String view = ""; // TODO ajax
		int result = 0;

//		result=memberService.emailCheck(mEmail);		
//		if(result<SUCCESS) {
//		}

		
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(Model model, MemberDTO memberDto) {
		String view = "redirect:/main";
		int result = 0;

//		memberDto=memberService.join(memberDto);		
		if (memberDto == null) {

		}

//		model.addAttribute("memberDto", memberDto);
		return view;
	}

	@RequestMapping(value = "/find_account", method = RequestMethod.GET)
	public String findAccountForm(Model model) {
		String view = "Member/find_account";

		model.addAttribute("title", "계정찾기");
		return view;
	}

	@RequestMapping(value = "/find_account", method = RequestMethod.POST)
	public String findAccount(Model model, String mEmail) {
		String view = ""; // TODO 결과안내 폼으로 변경
		int result = 0;

//		result=memberService.findAccount(mEmail);
//		if(result<SUCCESS) {
//		}

		
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(Model model) {
		String view = "Member/login";

		model.addAttribute("title", "로그인");
		return view;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, MemberDTO memberDto, HttpServletRequest req) {
		String view = "redirect:/"; // TODO 이전에 접속중이던 페이지로 리다이렉트
		String beforeUrl = req.getHeader("referer");

//		memberDto=memberService.login(memberDto);

		model.addAttribute("title", "");
		model.addAttribute("memberDto", memberDto);
		return view;
	}

	@RequestMapping(value = "/member_info")
	public String memberInfo(Model model, HttpServletRequest req) {
		String view = "Member/member_info";
		MemberDTO memberDto = (MemberDTO) req.getAttribute("memberDto");
		Map<String, Object> memberInfoMap = null;

//		memberInfoMap=memberService.memberInfo(memberDto.getmId());
//		if(result<SUCCESS) {
//		}


		model.addAttribute("title", "회원정보");
		model.addAttribute("memberInfoMap", memberInfoMap);
		return view;
	}

	@RequestMapping(value = "/modify_info", method = RequestMethod.GET)
	public String modifyInfoForm(Model model) {
		String view = "Member/modify_info";

		model.addAttribute("title", "회원정보 수정");
		return view;
	}

	@RequestMapping(value = "/modify_info", method = RequestMethod.POST)
	public String modifyInfo(Model model, MemberDTO memberDto) {
		String view = "redirect:/member_info"; 
		int result = 0;

//		result=memberService.modifyInfo(memberDto);
//		if(result<SUCCESS) {
//		}

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
	public String withdraw(Model model, MemberDTO memberDto) {
		String view = "redirect:/main"; //"Member/auth";  
		int result = 0;

//		result=memberService.withdraw(memberDto);
//		if(result<SUCCESS) {
//		}

		model.addAttribute("title", "");
		return view;
	}
	/*
	 * @RequestMapping(value = "/auth", method = RequestMethod.GET) public String
	 * authForm(Model model) { String view = null;
	 * 
	 * view = "Member/auth"; return view; }
	 * 
	 * @RequestMapping(value = "/auth", method = RequestMethod.POST) public String
	 * auth(Model model, MemberAuthDTO memberAuthDto) { String view = null;
	 * 
	 * view = ""; model.addAttribute("title", ""); return view; }
	 */
}
