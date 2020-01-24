package com.ce.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ce.component.PageHelper;
import com.ce.component.SearchHelper;
import com.ce.dto.DmDTO;
import com.ce.dto.MemberDTO;
import com.ce.service.DmService;

@Controller
@RequestMapping("/dm")
public class DmController {
	@Autowired
	private DmService dmService;
	private final int SUCCESS=1;
	private final int FAIL=-1;

	public void setDmService(DmService dmService) {
		this.dmService = dmService;
	}

	@RequestMapping(value = { "", "/", "/list" })
	public String list(Model model, String mId, HttpSession session, PageHelper pageHelper,
			SearchHelper searchHelper) {
		String view = "Dm/list";
		MemberDTO memberDto = (MemberDTO)session.getAttribute("memberDto");
		List<DmDTO> dmDtoList = null;

		if (memberDto != null) {
			dmDtoList=dmService.list(memberDto, pageHelper, searchHelper);
		} else if(memberDto==null) {
			view="redirect:main";
		}

		model.addAttribute("title", memberDto.getmNickname() + "님의 쪽지목록");
		model.addAttribute("dmDtoList", dmDtoList);
		return view;
	}

	@RequestMapping(value = "/{dmIdx}")
	public String content(Model model, @PathVariable("dmIdx") String stringDmIdx, PageHelper pageHelper) {
		String view = "Dm/content";
		Map<String,Object> resultMap=null;
		DmDTO dmDto=null;
		List<DmDTO> dmDtoList=null;
		
		resultMap=dmService.content(stringDmIdx, pageHelper);
		if(resultMap==null) {
			return "redirect:/dm/list";
		}else {
			dmDto=(DmDTO)resultMap.get("dmDto");
			dmDtoList=(List<DmDTO>)resultMap.get("dmDtoList");
		}

		model.addAttribute("title", dmDto.getDmTitle());
		model.addAttribute("dmDto", dmDto);
		model.addAttribute("dmDtoList", dmDtoList);
		return view;
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeForm(Model model) {
		String view = "Dm/write";

		model.addAttribute("title", "쪽지 보내기");
		return view;
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(Model model, DmDTO dmDto) {
		String view = "redirect:/dm/list";
		int result = 0;

		result=dmService.write(dmDto);
		if(result!=SUCCESS) {
			result=FAIL;
		}
		
		model.addAttribute("result", result);
		return view;
	}

	@RequestMapping(value = "/search")
	public String search(Model model, DmDTO dmDto, SearchHelper searchHelper, PageHelper pageHelper) {
		String view = "Dm/list";
		List<DmDTO> dmDtoList = null;

//		dmDtoList=dmService.search(dmDto, searchHelper, pageHelper);

		model.addAttribute("title", "검색결과");
		model.addAttribute("dmDtoList", dmDtoList);
		return view;
	}

	@RequestMapping(value = "/delete")
	public String delete(Model model, int dmIdx) {
		String view = "redirect:/dm/list";
		int result = 0;

//		result=dmService.delete(dmIdx);

		model.addAttribute("title", "");
		model.addAttribute("result", result);
		return view;
	}
}
