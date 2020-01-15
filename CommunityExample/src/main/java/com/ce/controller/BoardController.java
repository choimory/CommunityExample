package com.ce.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ce.component.PageHelper;
import com.ce.component.SearchHelper;
import com.ce.dto.BoardCommentDTO;
import com.ce.dto.BoardDTO;
import com.ce.dto.BoardInfoDTO;
import com.ce.dto.BoardTypeDTO;
import com.ce.dto.BookmarkArticleDTO;
import com.ce.dto.VoteCommentDTO;
import com.ce.dto.VoteArticleDTO;
import com.ce.dto.BookmarkBoardDTO;
import com.ce.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping("/{bId}")
	public String list(Model model, @PathVariable("bId")String bId, PageHelper pageHelper) {
		String view = null;
		List<BoardDTO> boardDtoList=null;
		
//		boardDtoList=boardService.list(bId, pageHelper);
//		if(boardDtoList==null) {
//			return "redirect:main";
//		}else{
		view="Board/list";
//	}
			
		model.addAttribute("title", bId + " 게시판");
		model.addAttribute("board_id", bId);
		return view;
	}

	@RequestMapping(value = "/{bId}/{bIdx}")
	public String content(Model model, @PathVariable("bId")String bId,@PathVariable("bIdx")String stringIdx, PageHelper pageHelper) {
		String view = null;
		BoardDTO boardDto=null;
		Map<String,Object> contentMap=null;

//		contentMap=boardService.content(bId, stringBoardIdx, pageHelper);
//		if(contentMap==null) {
//			return "redirect:main";
//		}else {
			view="Board/content";
//		}
		
		model.addAttribute("title", bId + " 게시판");
		model.addAttribute("board_id", bId);
//		model.addAttribute("boardDto", boardDto);
//		model.addAttribute("boardCommentDto", boardCommentDto);
		return view;
	}

	@RequestMapping(value = "/{bId}/write", method = RequestMethod.GET)
	public String writeForm(Model model, @PathVariable("bId")String bId) {
		String view = null;

		view = "Board/write";
		model.addAttribute("title", "");
		model.addAttribute("bId", bId);
		return view;
	}

	@RequestMapping(value = "/{bId}/write", method = RequestMethod.POST)
	public String write(Model model, BoardDTO boardDto) {
		String view = null;

//		boardDto=boardService.write(boardDto);
//		if(boardDto==null) {
//			return	
//		}
		
		view = "redirect:"+boardDto.getbId()+boardDto.getbIdx();		// TODO 리다이렉트로 변경
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/{bId}/modify", method = RequestMethod.GET)
	public String modifyForm(Model model, BoardDTO boardDto) {
		String view = null;
		
//		boardDto=boardService.modifyForm(boardDto);
		
		view = "Board/modify";
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/{bId}/modify", method = RequestMethod.POST)
	public String modify(Model model, BoardDTO boardDto, BoardInfoDTO boardInfoDto) {
		String view = null;
		
//		boardDto=boardService.modify(boardDto,boardInfoDto);

		view = "Board/content";		// TODO redirect로 변경
		model.addAttribute("title", "");
		return view;
	}
	
	
	@RequestMapping(value="/{bId}/delete", method=RequestMethod.POST)
	public String delete(Model model, BoardDTO boardDto) {
		String view=null;
		int result=0;
		
//		result=boardService.delete(boardDto);
		
		view="redirect:"+"/"+boardDto.getbId();		// TODO 리다이렉트로 변경
		model.addAttribute("title", "");		
		return view;
	}
	
	
	@RequestMapping(value="/{bId}/search")
	public String search(Model model,BoardDTO boardDto,PageHelper pageHelper ,SearchHelper searchHelper) {
		String view;
		List<BoardDTO> boardDtoList=null;
		
//		boardDtoList=boardService.search(boardDto, searchHelper, pageHelper);
		
		view="Board/list";
		model.addAttribute("title", "");
		return view;
	}
	
	@RequestMapping(value="/{bId}/{bIdx}/comment")
	public String comment(Model model,BoardCommentDTO boardCommentDto, BoardTypeDTO boardTypeDto, PageHelper pageHelper) {
		String view=null;
		List<BoardCommentDTO> boardCommentDtoList=null;
		
//		boardCommentDtoList=boardService.comment(boardCommentDto, boardTypeDto, pageHelper);
		
		view="";//TODO ajax
		model.addAttribute("title", "");
		return view;
	}
	
	
	@RequestMapping(value="/{bId}/comment/write", method=RequestMethod.POST)
	public String writeComment(Model model, BoardCommentDTO boardCommentDto, BoardTypeDTO boardTypeDto) {
		String view=null;
		int result=0;
		
//		result=boardService.writeComment(boardCommentDto, boardTypeDto);
		
		view="Board/content";		// TODO 리다이렉트로 변경
		model.addAttribute("title", "");
		return view;
	}
	
	
	@RequestMapping(value="/{bId}/comment/modify", method=RequestMethod.POST)
	public String modifyComment(Model model, BoardCommentDTO boardCommentDto, BoardTypeDTO boardTypeDto) {
		String view=null;
		int result=0;
		
//		result=boardService.modifyComment(boardCommentDto, boardTypeDto);
		
		view="Board/content";		// TODO 리다이렉트로 변경
		model.addAttribute("title", "");
		return view;
	}
	
	
	@RequestMapping(value="/{bId}/comment/delete",method=RequestMethod.POST)
	public String deleteComment(Model model,BoardCommentDTO boardCommentDto,BoardTypeDTO boardTypeDto) {
		String view=null;
		int result=0;
		
//		result=boardService.deleteComment(boardCommentDto, boardTypeDto);
		
		view="Board/content";		// TODO 리다이렉트로 변경
		model.addAttribute("title", "");
		return view;
	}
	
	
	@RequestMapping(value="/{bId}/comment/reply")
	public String replyComment(Model model, BoardCommentDTO boardCommentDto,BoardTypeDTO boardTypeDto) {
		String view=null;
		int result=0;
		
//		result=boardService.replyComment(boardCommentDto, boardTypeDto);
		
		// TODO 댓글 답글. 프론트에선 들여쓰기 최대 한칸만 적용
		
		view="Board/content";		// TODO 리다이렉트로 변경
		model.addAttribute("title", "");
		return view;
	}
	
	
	@RequestMapping(value="/bookmarkBoard")
	public String bookmarkBoard(Model model, BookmarkBoardDTO bookmarkBoardDto) {
		String view=null;
		int result=0;
		
//		result=boardService.bookmarkBoard(bookmarkBoardDto);		
		
		view=""; 		// TODO ajax
		model.addAttribute("title", "");
		return view;
	}
	
	
	@RequestMapping(value="/bookmarkContent")
	public String bookmarkContent(Model model,BookmarkArticleDTO bookmarkArticleDto) {
		String view=null;
		int result=0;
		
//		result=boardService.bookmarkContent(bookmarkArticleDto);
		
		view="";		// TODO ajax
		model.addAttribute("title", "");
		return view;
	}
	
	
	@RequestMapping(value="/thumbsUpContent")
	public String thumbsUpContent(Model model, VoteArticleDTO voteArticleDto) {
		String view=null;
		int result=0;
		
//		result=boardService.thumbsUpContent(voteArticleDto);		
		
		view="";		// TODO ajax
		model.addAttribute("title", "");
		return view;
	}
	
	
	@RequestMapping(value="/thumbsDownContent")	
	public String thumbsDownContent(Model model, VoteArticleDTO voteArticleDto) {
		String view=null;
		int result=0;
		
//		result=boardService.thumbsDownContent(voteArticleDto);		
		
		view="";		// TODO ajax
		model.addAttribute("title", "");
		return view;
	}
	
	
	@RequestMapping(value="/reportContent")
	public String reportContent(Model model, BoardDTO boardDto) {
		String view=null;
		int result=0;
		
//		result=boardService.reportContent(boardDto);
		
		view="";		// TODO ajax
		model.addAttribute("title", "");
		return view;
	}
	
	
	@RequestMapping(value="/thumbsUpComment")
	public String thumbsUpComment(Model model,VoteCommentDTO voteCommentDto) {
		String view=null;
		int result=0;
		
//		result=boardService.thumbsUpComment(voteCommentDto);		
		
		view="";		// TODO ajax
		model.addAttribute("title", "");
		return view;
	}
	
	
	@RequestMapping(value="/thumbsDownComment")
	public String thumbsDownComment(Model model, VoteCommentDTO voteCommentDto) {
		String view=null;
		int result=0;
		
//		result=boardService.thumbsDownComment(voteCommentDto);
		
		view="";		// TODO ajax
		model.addAttribute("title", "");
		return view;
	}
}
