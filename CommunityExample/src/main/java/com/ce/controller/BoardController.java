package com.ce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ce.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private BoardService boardService;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("/")
	public String boardList(Model model) {
		String view=null;
		String boardName=null;
		
		boardName="abc";
		model.addAttribute("title", boardName+" 게시판");
		view="Board/list";
		return view;
	}	
}
