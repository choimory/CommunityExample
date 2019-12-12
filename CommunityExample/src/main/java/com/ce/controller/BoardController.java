package com.ce.controller;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ce.service.BoardService;

@Controller
public class BoardController {

	private BoardService boardService;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping("/{bid}")
	public String list(Model model, @PathVariable("bid") String bId) {
		String view = null;
		boolean boardExist = false;
		ArrayList<String> boardLineup = null;

		// TODO BOARD_TYPE 테이블에서 게시판명들 다 가져와서 boardId와 foreach로 대조해보고 맞는게 있을시 boardExist를 true로 돌리는 작업필요
		// TODO 해당게시판에서 page로 계산해 20개의 글을 가져와 뿌림
		
//		for (String tmp : boardLineup) {
//			if (bId.equals(tmp)) {
//				boardExist = true;
//			}
//		}
//		if (boardExist) {
			view = "Board/list";
//		} else {
//			view = "Main/main";
//		}
			
		model.addAttribute("title", bId + " 게시판");
		model.addAttribute("board_id", bId);
		return view;
	}

	@RequestMapping(value = "/{bid}/{bidx}")
	public String content(Model model, @PathVariable("bid") String bId,
			@PathVariable("bidx") int boardIdx) {
		String view = null;
		boolean boardExist = false;
		ArrayList<String> boardLineup = null;

		// TODO 게시판명들 다 가져와서 board_id와 foreach로 대조해보고 맞는게 있을시 boardExist를 true로 돌리는 작업필요
		// TODO + boardId는 true이지만 boardIdx는 false일때 해당 게시판 list로 되돌아가는 작업 필요(redirect:/boardId?page=)
		// TODO {board_idx}에 int값이 아닌 값이 들어왔을때 생기는 http status 400문제 해결

//		for (String tmp : boardLineup) {
//			if (bId.equals(tmp)) {
//				boardExist = true;
//			}
//		}
//		if (boardExist) {
			view = "Board/content";
//		} else {
//			view = "Main/main";
//		}
			
		model.addAttribute("title", bId + " 게시판");
		model.addAttribute("board_id", bId);
		return view;
	}

	@RequestMapping(value = "/{bid}/write", method = RequestMethod.GET)
	public String writeForm(Model model) {
		String view = null;

		view = "Board/write";
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/{bid}/write", method = RequestMethod.POST)
	public String write(Model model, @PathVariable("bid")String bId) {
		String view = null;
		
		// TODO 해당게시판 테이블에 글 작성
		
		view = "Board/content";		// TODO 리다이렉트로 변경
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/{bid}/modify", method = RequestMethod.GET)
	public String modifyForm(Model model) {
		String view = null;

		// TODO 해당글의 값을 가져와 폼에 전달해서 input value값이 채워질수 있도록 할것
		
		view = "Board/modify";
		model.addAttribute("title", "");
		return view;
	}

	@RequestMapping(value = "/{bid}/modify", method = RequestMethod.POST)
	public String modify(Model model, @PathVariable("bid") String bId) {
		String view = null;
		
		// TODO 해당글의 컬럼값 변경

		view = "Board/content";		// TODO redirect로 변경
		model.addAttribute("title", "");
		return view;
	}
	
	
	@RequestMapping(value="/{bid}/delete", method=RequestMethod.POST)
	public String delete(Model model, @PathVariable("bid")String bId) {
		String view=null;
		
		// TODO 해당 row 삭제
		
		view="redirect:"+"/"+bId;		// TODO 리다이렉트로 변경
		model.addAttribute("title", "");		
		return view;
	}
	
	
	@RequestMapping(value="/{bid}/search")
	public String search(Model model, @PathVariable("bid")String bId, String query, String target) {
		String view;
		
		// TODO 해당 게시판에서 query와 target을 적용한 검색결과를 뿌리기
		
		view="Board/list";
		model.addAttribute("title", "");
		return view;
	}
	
	@RequestMapping(value="/{bid}/{bidx}/comment", method = RequestMethod.POST)
	public String commentList(Model model, @PathVariable("bid") String bId, @PathVariable("bidx") int bidx) {
		String view=null;
		
		// TODO 댓글창의 페이지네이션을 사용했을시 bId와 bidx 그리고 page를 이용해 해당글의 댓글 가져오기
		
		view="";//TODO ajax
		model.addAttribute("title", "");
		return view;
	}
	
	
	@RequestMapping(value="/{bid}/comment/write", method=RequestMethod.POST)
	public String writeComment(Model model) {
		String view=null;
		
		// TODO 댓글테이블에 해당글의 idx와 함께 댓글작성
		
		view="Board/content";		// TODO 리다이렉트로 변경
		model.addAttribute("title", "");
		return view;
	}
	
	
	@RequestMapping(value="/{bid}/comment/modify", method=RequestMethod.POST)
	public String modifyComment(Model model) {
		String view=null;
		
		// TODO 댓글수정, 수정된 댓글일시 꼬릿말로 [댓글수정일자 : yyyy-mm-dd]가 붙게
		
		view="Board/content";		// TODO 리다이렉트로 변경
		model.addAttribute("title", "");
		return view;
	}
	
	
	@RequestMapping(value="/{bid}/comment/delete",method=RequestMethod.POST)
	public String deleteComment(Model model) {
		String view=null;
		
		// TODO 댓글삭제, 삭제된 댓글은 row에서 지우지 말고 댓글내용을 [~~에 의해 삭제된 댓글입니다]로 변경
		
		view="Board/content";		// TODO 리다이렉트로 변경
		model.addAttribute("title", "");
		return view;
	}
	
	
	@RequestMapping(value="/{bid}/comment/reply")
	public String replyComment(Model model) {
		String view=null;
		
		// TODO 댓글 답글. 프론트에선 들여쓰기 최대 한칸만 적용
		
		view="Board/content";		// TODO 리다이렉트로 변경
		model.addAttribute("title", "");
		return view;
	}
	
	
	@RequestMapping(value="/bookmarkBoard")
	public String bookmarkBoard(Model model) {
		String view=null;
		
		// TODO 테이블에 북마크값이 있을시엔 로우 삭제, 없을시엔 로우 추가
		
		view=""; 		// TODO ajax
		model.addAttribute("title", "");
		return view;
	}
	
	
	@RequestMapping(value="/bookmarkContent")
	public String bookmarkContent(Model model) {
		String view=null;
		
		// TODO 테이블에 북마크값이 있을시엔 로우 삭제, 없을시엔 로우 추가
		
		view="";		// TODO ajax
		model.addAttribute("title", "");
		return view;
	}
	
	
	@RequestMapping(value="/thumbsUpContent")
	public String thumbsUpContent(Model model) {
		String view=null;
		
		// TODO 테이블에 추천값이 있을시엔 로우 삭제, 없을시엔 추가
		
		view="";		// TODO ajax
		model.addAttribute("title", "");
		return view;
	}
	
	
	@RequestMapping(value="/thumbsDownContent")	
	public String thumbsDownContent(Model model) {
		String view=null;
		
		// TODO 테이블에 추천값이 있을시엔 로우 삭제, 없을시엔 추가
		
		view="";		// TODO ajax
		model.addAttribute("title", "");
		return view;
	}
	
	
	@RequestMapping(value="/reportContent")
	public String reportContent(Model model) {
		String view=null;
		
		// TODO 리포트 컬럼값을 번경
		
		view="";		// TODO ajax
		model.addAttribute("title", "");
		return view;
	}
	
	
	@RequestMapping(value="/thumbsUpComment")
	public String thumbsUpComment(Model model) {
		String view=null;
		
		// TODO 테이블에 로우가 있을시엔 삭제, 없을시엔 추가
		
		view="";		// TODO ajax
		model.addAttribute("title", "");
		return view;
	}
	
	
	@RequestMapping(value="/thumbsDownComment")
	public String thumbsDownComment(Model model) {
		String view=null;
		
		// TODO 테이블에 로우가 있을시엔 삭제, 없을시엔 추가
		
		view="";		// TODO ajax
		model.addAttribute("title", "");
		return view;
	}
}
