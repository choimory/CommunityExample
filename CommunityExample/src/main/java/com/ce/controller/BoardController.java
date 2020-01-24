package com.ce.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ce.component.PageHelper;
import com.ce.component.SearchHelper;
import com.ce.dto.BoardCommentDTO;
import com.ce.dto.BoardCommentInfoDTO;
import com.ce.dto.BoardDTO;
import com.ce.dto.BoardInfoDTO;
import com.ce.dto.BoardTypeDTO;
import com.ce.dto.BookmarkArticleDTO;
import com.ce.dto.VoteCommentDTO;
import com.ce.dto.VoteArticleDTO;
import com.ce.dto.BookmarkBoardDTO;
import com.ce.service.BoardService;

@Controller
@SessionAttributes({ "bookmarkBoardDtoList", "bookmarkArticleDtoList" })
public class BoardController {
	@Autowired
	private BoardService boardService;
	private final int SUCCESS = 1;
	private final int FAIL = -1;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping("/{bId}")
	public String list(Model model, @PathVariable("bId") String bId, PageHelper pageHelper, SearchHelper searchHelper, HttpServletRequest req) {
		String view = null;
		Map<String, Object> returnMap = null;
		BoardTypeDTO boardTypeDto = null;

		System.out.println("기본경로 :: "+req.getSession().getServletContext().getRealPath(""));
		returnMap = boardService.list(bId, pageHelper, searchHelper);
		if (returnMap == null) {
			return "redirect:main";
		} else {
			view = "Board/list";
			boardTypeDto = (BoardTypeDTO) returnMap.get("boardTypeDto");
		}

		model.addAttribute("title", boardTypeDto.getbIdKor() + " 게시판");
		model.addAttribute("boardTypeDto", boardTypeDto);
		model.addAttribute("boardCategoryList", returnMap.get("boardCategoryList"));
		model.addAttribute("boardDtoList", returnMap.get("boardDtoList"));
		model.addAttribute("searchHelper", searchHelper);
		model.addAttribute("pageHelper", pageHelper);
		return view;
	}

	@RequestMapping(value = "/{bId}/{bIdx}")
	public String content(Model model, @PathVariable("bId") String bId, @PathVariable("bIdx") String stringIdx,
			PageHelper pageHelper, SearchHelper searchHelper) {
		String view = null;
		BoardTypeDTO boardTypeDto = null;
		Map<String, Object> returnMap = null;

		returnMap = boardService.content(bId, stringIdx, pageHelper, searchHelper);
		if (returnMap == null) {
			return "redirect:main";
		} else {
			view = "Board/content";
			boardTypeDto = (BoardTypeDTO) returnMap.get("boardTypeDto");
		}

		model.addAttribute("title", boardTypeDto.getbIdKor() + " 게시판");
		model.addAttribute("boardTypeDto", boardTypeDto);
		model.addAttribute("boardDto", returnMap.get("boardDto"));
		model.addAttribute("boardCommentDtoList", returnMap.get("boardCommentDtoList"));
		model.addAttribute("commentPageHelper", returnMap.get("commentPageHelper"));
		model.addAttribute("boardCategoryList", returnMap.get("boardCategoryList"));
		model.addAttribute("boardDtoList", returnMap.get("boardDtoList"));
		model.addAttribute("searchHelper", searchHelper);
		model.addAttribute("pageHelper", returnMap.get("pageHelper"));
		return view;
	}

	@RequestMapping(value = "/{bId}/write", method = RequestMethod.GET)
	public String writeForm(Model model, @PathVariable("bId") String bId) {
		String view = null;
		Map<String, Object> returnMap = null;

		returnMap = boardService.writeForm(bId);
		if (returnMap == null) {
			return "redirect:main";
		} else {
			view = "Board/write";
		}

		model.addAttribute("title", "게시물 작성");
		model.addAttribute("boardTypeDto", returnMap.get("boardTypeDto"));
		model.addAttribute("boardCategoryList", returnMap.get("boardCategoryList"));
		return view;
	}

	@RequestMapping(value = "/{bId}/write", method = RequestMethod.POST)
	public String write(Model model, BoardDTO boardDto, BoardInfoDTO boardInfoDto) {
		String view = null;
		boardDto.setBoardInfoDto(boardInfoDto);

		boardDto = boardService.write(boardDto, boardInfoDto);
		if (boardDto == null) {
			return "redirect:main";
		}

		view = "redirect:" + boardDto.getbId() + boardDto.getbIdx();
		return view;
	}

	@RequestMapping(value = "/{bId}/modify", method = RequestMethod.GET)
	public String modifyForm(Model model, BoardDTO boardDto) {
		String view = "Board/modify";
		Map<String,Object> resultMap=null;
		
		resultMap=boardService.modifyForm(boardDto);
		if(resultMap==null) {
			view="redirect:main";
		}

		model.addAttribute("title", "작성글 수정");
		model.addAttribute("boardDto", resultMap.get("boardDto"));
		model.addAttribute("boardCategoryList", resultMap.get("boardCategoryList"));
		model.addAttribute("boardTypeDto", resultMap.get("boardTypeDto"));
		return view;
	}

	@RequestMapping(value = "/{bId}/modify", method = RequestMethod.POST)
	public String modify(Model model, BoardDTO boardDto, BoardInfoDTO boardInfoDto) {
		String view = null;

		boardDto=boardService.modify(boardDto,boardInfoDto);

		view = "redirect:/"+boardDto.getbId()+"/"+boardDto.getbIdx(); // TODO redirect로 변경
		return view;
	}

	@RequestMapping(value = "/{bId}/delete", method = RequestMethod.POST)
	public String delete(Model model, BoardDTO boardDto) {
		String view = null;
		int result = 0;

		result=boardService.delete(boardDto);

		view = "redirect:" + "/" + boardDto.getbId();
		return view;
	}

	@RequestMapping(value = "/{bId}/search")
	public String search(Model model, BoardDTO boardDto, PageHelper pageHelper, SearchHelper searchHelper) {
		String view;
		List<BoardDTO> boardDtoList = null;

//		boardDtoList=boardService.search(boardDto, searchHelper, pageHelper);

		view = "Board/list";
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/{bId}/{bIdx}/comment")
	public String comment(Model model, BoardCommentDTO boardCommentDto, BoardTypeDTO boardTypeDto,
			PageHelper pageHelper) {
		String view = null;
		List<BoardCommentDTO> boardCommentDtoList = null;

//		boardCommentDtoList=boardService.comment(boardCommentDto, boardTypeDto, pageHelper);

		view = "";// TODO ajax
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/comment/write", method = RequestMethod.POST)
	public String writeComment(Model model, BoardTypeDTO boardTypeDto, BoardCommentDTO boardCommentDto,
			BoardCommentInfoDTO boardCommentInfoDto) {
		String view = null;
		int result = 0;

		result = boardService.writeComment(boardTypeDto, boardCommentDto, boardCommentInfoDto);
		if (result == FAIL) {
		}

		view = "redirect:/" + boardTypeDto.getbId() + "/" + boardCommentDto.getbIdx();
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/{bId}/comment/modify", method = RequestMethod.POST)
	public String modifyComment(Model model, BoardCommentDTO boardCommentDto, BoardTypeDTO boardTypeDto) {
		String view = null;
		int result = 0;

//		result=boardService.modifyComment(boardCommentDto, boardTypeDto);

		view = "Board/content"; // TODO 리다이렉트로 변경
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/{bId}/comment/delete", method = RequestMethod.POST)
	public String deleteComment(Model model, BoardCommentDTO boardCommentDto, BoardTypeDTO boardTypeDto) {
		String view = null;
		int result = 0;

//		result=boardService.deleteComment(boardCommentDto, boardTypeDto);

		view = "Board/content"; // TODO 리다이렉트로 변경
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/{bId}/comment/reply")
	public String replyComment(Model model, BoardCommentDTO boardCommentDto, BoardTypeDTO boardTypeDto) {
		String view = null;
		int result = 0;

//		result=boardService.replyComment(boardCommentDto, boardTypeDto);

		// TODO 댓글 답글. 프론트에선 들여쓰기 최대 한칸만 적용

		view = "Board/content"; // TODO 리다이렉트로 변경
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/bookmarkBoard")
	public String bookmarkBoard(Model model, BookmarkBoardDTO bookmarkBoardDto) {
		String view = null;
		int result = 0;

//		result=boardService.bookmarkBoard(bookmarkBoardDto);		

		view = ""; // TODO ajax
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/bookmarkContent")
	public String bookmarkContent(Model model, BookmarkArticleDTO bookmarkArticleDto) {
		String view = null;
		int result = 0;

//		result=boardService.bookmarkContent(bookmarkArticleDto);

		view = ""; // TODO ajax
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/thumbsUpContent")
	public String thumbsUpContent(Model model, VoteArticleDTO voteArticleDto) {
		String view = null;
		int result = 0;

//		result=boardService.thumbsUpContent(voteArticleDto);		

		view = ""; // TODO ajax
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/thumbsDownContent")
	public String thumbsDownContent(Model model, VoteArticleDTO voteArticleDto) {
		String view = null;
		int result = 0;

//		result=boardService.thumbsDownContent(voteArticleDto);		

		view = ""; // TODO ajax
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/reportContent")
	public String reportContent(Model model, BoardDTO boardDto) {
		String view = null;
		int result = 0;

//		result=boardService.reportContent(boardDto);

		view = ""; // TODO ajax
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/thumbsUpComment")
	public String thumbsUpComment(Model model, VoteCommentDTO voteCommentDto) {
		String view = null;
		int result = 0;

//		result=boardService.thumbsUpComment(voteCommentDto);		

		view = ""; // TODO ajax
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/thumbsDownComment")
	public String thumbsDownComment(Model model, VoteCommentDTO voteCommentDto) {
		String view = null;
		int result = 0;

//		result=boardService.thumbsDownComment(voteCommentDto);

		view = ""; // TODO ajax
		model.addAttribute("title", "");
		return view;
	}
}
