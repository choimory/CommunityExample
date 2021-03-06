package com.ce.controller;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ce.service.MainService;

@Controller
public class MainController {
	@Autowired
	private MainService mainService;
	private static final Logger log = LoggerFactory.getLogger(MainController.class);

	public void setMainService(MainService mainService) {
		this.mainService = mainService;
	}

	@RequestMapping(value = { "/", "/main" })
	public String main(Model model) {
		String view = "Main/main";
		Map<String, Object> resultMap = null;

		log.debug("main();");
		resultMap = mainService.main();
		if (resultMap == null || resultMap.get("bestMap") == null || resultMap.get("otherMap") == null) {
		}

		model.addAttribute("title", "환영합니다");
		model.addAttribute("bestMap", resultMap.get("bestMap"));
		model.addAttribute("otherMap", resultMap.get("otherMap"));
		return view;
	}

	@RequestMapping(value = { "/mainSearch" })
	public String search() {
		String view = "";

		return view;
	}

	@RequestMapping(value = "/wbs")
	public String wbs(Model model) {
		String view;
		view = "Main/wbs";
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/document")
	public String document(Model model) {
		String view;
		view = "Main/document";
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/skill")
	public String skill(Model model) {
		String view;
		view = "Main/skill";
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/architecture")
	public String architecture(Model model) {
		String view;
		view = "Main/architecture";
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/member_data")
	public String memberData(Model model) {
		String view;
		view = "Main/member_data";
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/rule")
	public String rule(Model model) {
		String view;
		view = "Main/rule";
		model.addAttribute("title", "");
		return view;
	}

}
