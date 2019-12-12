package com.ce.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ce.service.DmService;

@Controller
@RequestMapping("/dm")
public class DmController {
	private DmService dmService;

	public void setDmService(DmService dmService) {
		this.dmService = dmService;
	}

	
	
	@RequestMapping(value= {"", "/", "/list"})
	public String list(Model model) {
		String view=null;
		
		// TODO send컬럼에 해당 id와 page를 이용한 검색한 결과 가져오기
		
		view="Dm/list";
		model.addAttribute("title", "");
		return view;
	}
	
	
	@RequestMapping(value="/{dmidx}")
	public String content(Model model, @PathVariable("dmidx") int dmIdx) {
		String view=null;
		
		// TODO idx의 컬럼값들 가져와서 뿌리기, idx에 int가 아닌 값 들어올시 생기는 문제 수정할것
		
		view="Dm/content";
		model.addAttribute("title", "");
		return view;
	}
	
	
	@RequestMapping(value="/write", method = RequestMethod.GET)
	public String writeForm(Model model) {
		String view=null;
		
		view="Dm/write";
		model.addAttribute("title", "");
		return view;
	}
	
	
	@RequestMapping(value="",method = RequestMethod.POST)
	public String write(Model model) {
		String view=null;
		
		// TODO 입력된 값으로 row등록
		
		view="Dm/list";
		model.addAttribute("title", "");
		return view;
	}
	
	
	@RequestMapping(value="/search")
	public String search(Model model) {
		String view=null;
		
		// TODO query와 target과 page를 이용해 검색한 결과 뿌리기
		
		view="Dm/list";		// TODO 리다이렉트로 변경
		model.addAttribute("title", "");
		return view;
	}
	
	
	@RequestMapping(value="/delete")
	public String delete(Model model) {
		String view=null;
		
		// TODO 해당 idx의 row 지우기
		
		view="Dm/list";		// TODO 리다이렉트로 변경
		model.addAttribute("title", "");
		return view;
	}
}
