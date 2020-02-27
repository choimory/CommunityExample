package com.ce.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	private static final Logger log = LoggerFactory.getLogger(DmController.class);
	private final int SUCCESS = 1;
	private final int FAIL = -1;

	public void setDmService(DmService dmService) {
		this.dmService = dmService;
	}

	@RequestMapping(value = { "", "/", "/list" })
	public String list(Model model, String mId, HttpSession session, PageHelper pageHelper, SearchHelper searchHelper) {		
		String view = "Dm/list";
		Map<String,Object> resultMap=null;
		MemberDTO memberDto = (MemberDTO) session.getAttribute("memberDto");
		
		log.debug("list();");
		log.debug(pageHelper.toString());
		log.debug(searchHelper.toString());
		resultMap = dmService.list(memberDto, pageHelper, searchHelper);
		

		model.addAttribute("title", memberDto.getmNickname() + "님의 쪽지목록");
		model.addAttribute("dmDtoList", resultMap.get("dmDtoList"));
		model.addAttribute("pageHelper", resultMap.get("pageHelper"));
		model.addAttribute("searchHelper", searchHelper);
		return view;
	}

	@RequestMapping(value = "/{dmIdx}")
	public String content(Model model, @PathVariable("dmIdx") String stringDmIdx, PageHelper pageHelper, SearchHelper searchHelper) {
		String view = "Dm/content";
		Map<String, Object> resultMap = null;
		DmDTO dmDto = null;
		List<DmDTO> dmDtoList = null;

		log.debug("content();");
		resultMap = dmService.content(stringDmIdx, pageHelper,searchHelper);
		if (resultMap == null) {
			return "redirect:/dm/list";
		} else {
			dmDto = (DmDTO) resultMap.get("dmDto");
			dmDtoList = (List<DmDTO>) resultMap.get("dmDtoList");
		}

		model.addAttribute("title", dmDto.getDmTitle());
		model.addAttribute("dmDto", dmDto);
		model.addAttribute("dmDtoList", dmDtoList);
		model.addAttribute("pageHelper", resultMap.get("pageHelper"));
		model.addAttribute("searchHelper", searchHelper);
		return view;
	}
	@RequestMapping(value= {"/download"})
	public void download(HttpServletResponse res, String fOriginalName,String fStoredName) {
		FileInputStream input =null;
		OutputStream output=null;
		
		log.debug("download();");
		log.debug("변경전 파일명: "+fOriginalName);
		log.debug("변경후 파일명: "+fStoredName);		
		input=dmService.download(fStoredName);
		if(input!=null) {
			res.setHeader("Cache-Control", "no-cache");
			res.addHeader("Content-disposition", "attachment; fileName="+fOriginalName);
			byte[] buffer = new byte[1024 * 8];
			try {
				output=res.getOutputStream();
				while(input.read(buffer)!=-1) {
					output.write(buffer);
				}
				input.close();
				output.close();
			} catch (IOException e) {
				e.printStackTrace();				
			}
		}
		
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeForm(Model model) {
		String view = "Dm/write";

		model.addAttribute("title", "쪽지 보내기");
		return view;
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(Model model, DmDTO dmDto, MultipartHttpServletRequest fileReq) {
		String view = "redirect:/dm/list";
		int result = 0;
		List<MultipartFile> files = fileReq.getFiles("file");

		result = dmService.write(dmDto, files);
		if (result != SUCCESS) {
			result = FAIL;
		}

		model.addAttribute("result", result);
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
