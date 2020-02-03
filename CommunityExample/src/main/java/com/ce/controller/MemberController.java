package com.ce.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ce.dto.MemberAuthDTO;
import com.ce.dto.MemberDTO;
import com.ce.service.MemberService;

@Controller
@EnableAsync
@SessionAttributes({"memberDto","bookmarkBoardDtoList","bookmarkArticleDtoList"})
public class MemberController {
	@Autowired
	private MemberService memberService;
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	private final int SUCCESS = 1;
	private final int FAIL = -1;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String joinForm(Model model, HttpServletRequest req) {
		String view = "Member/join";
		String beforeUrl=req.getHeader("referer");

		model.addAttribute("title", "회원가입");
		model.addAttribute("beforeUrl", beforeUrl);
		return view;
	}

	@RequestMapping(value = {"/id_check"}, method = RequestMethod.POST)
	@ResponseBody
	public int idCheck(Model model, @RequestBody String mId) {
		int result = 1;

		log.debug("idCheck() - mId : "+mId);
		result=memberService.idCheck(mId);
		
		return result;
	}	
	@RequestMapping(value = "/nickname_check")
	@ResponseBody
	public int nicknameCheck(Model model, @RequestBody String mNickname) {
		int result=0;
		
		log.debug("nicknameCheck() - mNickname : "+mNickname);
		result=memberService.emailCheck(mNickname);	
		
		return result;
	}

	@RequestMapping(value = "/email_check")
	@ResponseBody
	public int emailCheck(Model model, @RequestBody String mEmail) {
		int result=0;

		log.debug("emailCheck() - mEmail : "+mEmail);
		result=memberService.emailCheck(mEmail);	
		
		return result;
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(Model model, MemberDTO memberDto) {
		String view = "redirect:/main";

		memberDto=memberService.join(memberDto);		
//		if (memberDto == null) {
//			model.addAttribute("result", -1);
//			return "redirect:/join";			
//		}

		model.addAttribute("memberDto", memberDto);
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
		String view = "Member/find_account";
		int result=0;
		MemberDTO memberDto=null;

		memberDto=memberService.findAccount(mEmail);
		if(memberDto!=null) {
			result=memberService.sendMail(memberDto);
		}
		
		model.addAttribute("title", "계정찾기 결과");
		model.addAttribute("result", result);
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
		log.debug("loginPOST()");
		String view = "redirect:/main"; // TODO 이전에 접속중이던 페이지로 리다이렉트
		String beforeUrl = req.getHeader("referer");
		Map<String,Object> resultMap=null;
		
		resultMap=memberService.login(memberDto);
		if(resultMap==null) {			
		}
		
		model.addAttribute("memberDto", resultMap.get("memberDto"));
		model.addAttribute("bookmarkBoardDtoList", resultMap.get("bookmarkBoardDtoList"));
		return view;
	}

	@RequestMapping(value = "/member_info")
	public String memberInfo(Model model, HttpServletRequest req) {
		String view = "Member/member_info";
		MemberDTO memberDto = (MemberDTO) req.getSession().getAttribute("memberDto");
		Map<String, Object> resultMap = null;

		log.debug("memberInfo();");
		resultMap=memberService.memberInfo(memberDto.getmId());
		if(resultMap==null) {
			return "redirect:/main";
		}


		model.addAttribute("title", memberDto.getmNickname()+"님의 회원정보");
		model.addAttribute("resultMap", resultMap);
//		model.addAttribute("memberDto", resultMap.get("memberDto"));
//		model.addAttribute("bookmarkBoardDtoList", resultMap.get("bookmarkArticleDtoList"));
//		model.addAttribute("bookmarkArticleDtoList", resultMap.get("bookmarkArticleDtoList"));
//		model.addAttribute("memberItemDtoList", resultMap.get("memberItemDtoList"));
//		model.addAttribute("wishListDtoList", resultMap.get("wishListDtoList"));
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

		System.out.println(memberDto);
//		result=memberService.withdraw(memberDto);
//		if(result<SUCCESS) {
//		}

		model.addAttribute("title", "");
		return view;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.POST)
	public String logout(SessionStatus session) {
		String view="redirect:/main"; // TODO 추후 이전주소 리다이렉트로 변경
		
		session.setComplete();
		
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
