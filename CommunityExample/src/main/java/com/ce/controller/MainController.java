package com.ce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping({"/", "/main"})
	public String main(Model model) {
		String view=null;
		
		model.addAttribute("title", "메인화면");
		view="Main/main";
		return view;
	}
	
}
