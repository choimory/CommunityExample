package com.ce.controller;

import java.util.List;

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
	private DmService dmService;

	public void setDmService(DmService dmService) {
		this.dmService = dmService;
	}

	@RequestMapping(value = { "", "/", "/list" })
	public String list(Model model, String mId, String mNickname, PageHelper pageHelper) {
		String view = "Dm/list";
		List<DmDTO> dmDtoList = null;

//		dmDtoList=dmService.list(mId, dmDto, pageHelper);

		model.addAttribute("title", mNickname + "님의 쪽지목록");
		model.addAttribute("dmDtoList", dmDtoList);
		return view;
	}

	@RequestMapping(value = "/{dmIdx}")
	public String content(Model model, @PathVariable("dmIdx") String stringDmIdx) {
		String view = "Dm/content";
		DmDTO dmDto = null;

//		dmDto=dmService.content(dmIdx);
//		if(dmDto==null) {
//			view="redirect:/dm/list";
//		}

//		model.addAttribute("title", dmDto.getDmTitle());
		model.addAttribute("dmDto", dmDto);
		return view;
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeForm(Model model) {
		String view = "Dm/write";

		model.addAttribute("title", "쪽지 보내기");
		return view;
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(Model model, MemberDTO memberDto, DmDTO dmDto) {
		String view = "redirect:/dm/list";
		int result = 0;

//		result=dmService.write(dmDto);

		model.addAttribute("result", result);
		return view;
	}

	@RequestMapping(value = "/search")
	public String search(Model model, String mId, DmDTO dmDto, SearchHelper searchHelper, PageHelper pageHelper) {
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
