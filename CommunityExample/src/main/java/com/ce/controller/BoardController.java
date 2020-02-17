package com.ce.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
import com.ce.dto.MemberDTO;
import com.ce.dto.ReportArticleDTO;
import com.ce.service.BoardService;

@Controller
@SessionAttributes({ "bookmarkBoardDtoList", "bookmarkArticleDtoList" })
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private BoardService boardService;
	private final int SUCCESS = 1;
	private final int FAIL = -1;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping(value = { "/best" }, method={RequestMethod.GET})
	public String best(Model model, PageHelper pageHelper, SearchHelper searchHelper, HttpServletRequest req) {
		String view = "Board/best_list";
		Map<String, Object> resultMap = null;
		MemberDTO memberDto = (MemberDTO) req.getSession().getAttribute("memberDto");

		logger.debug("best();");
		resultMap = boardService.best(pageHelper, searchHelper, memberDto);

		model.addAttribute("title", "BEST게시판");
		model.addAttribute("boardTypeDto", resultMap.get("boardTypeDto"));
		model.addAttribute("boardDtoList", resultMap.get("boardDtoList"));
		model.addAttribute("searchHelper", searchHelper);
		model.addAttribute("pageHelper", pageHelper);
		model.addAttribute("isBookmarkedBoard", resultMap.get("isBookmarkedBoard"));
		return view;
	}

	@RequestMapping(value = { "/{bId}" }, method={RequestMethod.GET})
	public String list(Model model, @PathVariable("bId") String bId, PageHelper pageHelper, SearchHelper searchHelper, HttpServletRequest req) {
		String view = null;
		Map<String, Object> returnMap = null;
		BoardTypeDTO boardTypeDto = null;
		MemberDTO memberDto = (MemberDTO) req.getSession().getAttribute("memberDto");

		logger.debug("list()");
		returnMap = boardService.list(bId, pageHelper, searchHelper, memberDto);
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
		model.addAttribute("isBookmarkedBoard", returnMap.get("isBookmarkedBoard"));
		return view;
	}

	@RequestMapping(value = { "/best/{bIdx}" }, method={RequestMethod.GET})
	public String bestContent(Model model, @PathVariable("bIdx") String stringIdx, String bId, PageHelper pageHelper, SearchHelper searchHelper,
			HttpServletRequest req) {
		String view = "Board/best_content";
		BoardTypeDTO boardTypeDto = null;
		MemberDTO memberDto = (MemberDTO) req.getSession().getAttribute("memberDto");
		Map<String, Object> resultMap = null;

		logger.debug("bestContent();");
		if (bId == null) {
			return "redirect:/main";
		}
		resultMap = boardService.bestContent(bId, stringIdx, pageHelper, searchHelper, memberDto);
		if (resultMap == null) {
			return "redirect:/main";
		} else {
			boardTypeDto = (BoardTypeDTO) resultMap.get("boardTypeDto");
		}

		model.addAttribute("title", boardTypeDto.getbIdKor());
		model.addAttribute("boardTypeDto", boardTypeDto);
		model.addAttribute("boardDto", resultMap.get("boardDto"));
		model.addAttribute("boardCommentDtoList", resultMap.get("boardCommentDtoList"));
		model.addAttribute("commentPageHelper", resultMap.get("commentPageHelper"));
		model.addAttribute("boardDtoList", resultMap.get("boardDtoList"));
		model.addAttribute("pageHelper", resultMap.get("pageHelper"));
		model.addAttribute("searchHelper", searchHelper);
		model.addAttribute("isBookmarkedBoard", resultMap.get("isBookmarkedBoard"));
		model.addAttribute("isBookmarkedArticle", resultMap.get("isBookmarkedArticle"));
		return view;
	}

	@RequestMapping(value = "/{bId}/{bIdx}", method={RequestMethod.GET})
	public String content(Model model, @PathVariable("bId") String bId, @PathVariable("bIdx") String stringIdx, PageHelper pageHelper,
			SearchHelper searchHelper, HttpServletRequest req) {
		String view = null;
		BoardTypeDTO boardTypeDto = null;
		Map<String, Object> returnMap = null;
		MemberDTO memberDto = (MemberDTO) req.getSession().getAttribute("memberDto");

		logger.debug("content()");
		returnMap = boardService.content(bId, stringIdx, pageHelper, searchHelper, memberDto);
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
		model.addAttribute("isBookmarkedBoard", returnMap.get("isBookmarkedBoard"));
		model.addAttribute("isBookmarkedArticle", returnMap.get("isBookmarkedArticle"));
		return view;
	}

	@RequestMapping(value = "/{bId}/write", method={RequestMethod.GET})
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

	@RequestMapping(value = "/{bId}", method={RequestMethod.POST})
	public String write(Model model, BoardDTO boardDto, BoardInfoDTO boardInfoDto, MultipartHttpServletRequest req,
			@RequestParam("file") List<MultipartFile> file) {
		String view = null;
		boardDto.setBoardInfoDto(boardInfoDto);

		logger.debug("write();");

		boardDto = boardService.write(boardDto, boardInfoDto, file);
		if (boardDto == null) {
			return "redirect:main";
		}

		view = "redirect:/" + boardDto.getbId() + "/" + boardDto.getbIdx();
		return view;
	}

	@RequestMapping(value = { "/{bId}/{bIdx}/download" }, method={RequestMethod.GET})
	public void download(@PathVariable("bId") String bId, @PathVariable("bIdx") String stringBoardIdx, String fIdx, String fName, HttpServletResponse res) {
		FileInputStream input = null;

		logger.debug("download();");
		input = boardService.download(bId, stringBoardIdx, fIdx);
		if (input != null) {
			res.setHeader("Cache-Control", "no-cache");
			res.addHeader("Content-disposition", "attachment; fileName="+fName);
			byte[] buffer = new byte[1024 * 8];
			try {
				OutputStream output = res.getOutputStream();
				while (input.read(buffer) != -1) {
					output.write(buffer);
				}
				input.close();
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@RequestMapping(value = "/{bId}/{bIdx}/modify", method={RequestMethod.GET})
	public String modifyForm(Model model, BoardDTO boardDto) {
		String view = "Board/modify";
		Map<String, Object> resultMap = null;

		logger.debug("modify get()");
		resultMap = boardService.modifyForm(boardDto);
		if (resultMap == null) {
			logger.debug(boardDto.toString());
			logger.debug("resultmap = null");
			view = "redirect:main";
		}

		model.addAttribute("title", "작성글 수정");
		model.addAttribute("boardDto", resultMap.get("boardDto"));
		model.addAttribute("boardCategoryList", resultMap.get("boardCategoryList"));
		model.addAttribute("boardTypeDto", resultMap.get("boardTypeDto"));
		return view;
	}

	@RequestMapping(value = "/{bId}/{bIdx}", method={RequestMethod.PUT})
	public String modify(Model model, BoardDTO boardDto, BoardInfoDTO boardInfoDto) {
		String view = null;

		boardDto = boardService.modify(boardDto, boardInfoDto);

		view = "redirect:/" + boardDto.getbId() + "/" + boardDto.getbIdx();
		return view;
	}

	@RequestMapping(value = "/{bId}/{bIdx}",method= {RequestMethod.DELETE})
	public String delete(Model model, BoardDTO boardDto) {
		String view = null;
		int result = 0;

		result = boardService.delete(boardDto);
		if (result == FAIL) {
		}

		view = "redirect:/" + boardDto.getbId();
		return view;
	}

	@RequestMapping(value = "/{bId}/{bIdx}/comment", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> comment(@PathVariable("bId") String bId, @PathVariable("bIdx") int bIdx,
			@RequestBody PageHelper commentPageHelper) {
		Map<String, Object> resultMap = null;

		logger.debug("comment();");
		resultMap = boardService.comment(bId, bIdx, commentPageHelper);
		if (resultMap == null) {
		}

		return resultMap;
	}

	@RequestMapping(value = "/comment/write", method = RequestMethod.POST)
	public String writeComment(Model model, BoardTypeDTO boardTypeDto, BoardCommentDTO boardCommentDto, BoardCommentInfoDTO boardCommentInfoDto) {
		String view = null;
		int result = 0;

		logger.debug("writeComment()");
		logger.debug(boardCommentDto.toString());
		logger.debug(boardTypeDto.toString());
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

	//여기에서 WARN : org.springframework.web.servlet.PageNotFound - Request method 'GET' not supported 문제를 발생시킴. 아마 ReqMapping의 문제. 아마 요청주소의 모든것이 pathVariable이라서?
//	@RequestMapping(value = {"/{bId}/{bIdx}/{bcIdx}"}, method = {RequestMethod.DELETE})
//	public String deleteComment(Model model, BoardCommentDTO boardCommentDto, BoardTypeDTO boardTypeDto) {
//		String view = null;
//		int result = 0;
//
//		logger.debug("deleteComment();");
//		logger.debug(boardCommentDto.toString());
//		logger.debug(boardTypeDto.toString());
////		result=boardService.deleteComment(boardCommentDto, boardTypeDto);
//
//		view = "redirect:/"+boardTypeDto.getbId()+"/"+boardCommentDto.getbIdx();
//		model.addAttribute("title", "");
//		return view;
//	}

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

	@RequestMapping(value = "/bookmarkBoard", method = RequestMethod.POST)
	public @ResponseBody int bookmarkBoard(Model model, @RequestBody BookmarkBoardDTO bookmarkBoardDto) {
		Map<String, Object> resultMap = null;
		int result = 0;

		logger.debug("bookmarkBoard()");
		logger.debug(bookmarkBoardDto.toString());
		resultMap = boardService.bookmarkBoard(bookmarkBoardDto);

		if (resultMap.get("bookmarkBoardDtoList") != null) {
			model.addAttribute("bookmarkBoardDtoList", resultMap.get("bookmarkBoardDtoList"));
		}
		result = (Integer) resultMap.get("result");
		return result;
	}

	@RequestMapping(value = "/unBookmarkBoard", method = RequestMethod.POST)
	public @ResponseBody int unBookmarkBoard(Model model, @RequestBody BookmarkBoardDTO bookmarkBoardDto) {
		Map<String, Object> resultMap = null;
		int result = 0;

		logger.debug("unBookmarkBoard()");
		logger.debug(bookmarkBoardDto.toString());
		resultMap = boardService.unBookmarkBoard(bookmarkBoardDto);

		if (resultMap.get("bookmarkBoardDtoList") != null) {
			model.addAttribute("bookmarkBoardDtoList", resultMap.get("bookmarkBoardDtoList"));
		}
		result = (Integer) resultMap.get("result");
		return result;
	}

	@RequestMapping(value = "/bookmarkContent", method = RequestMethod.POST)
	public @ResponseBody int bookmarkContent(Model model, @RequestBody BookmarkArticleDTO bookmarkArticleDto) {
		int result = 0;

		logger.debug("bookmarkContent())");
		logger.debug(bookmarkArticleDto.toString());
		result = boardService.bookmarkContent(bookmarkArticleDto);

		return result;
	}

	@RequestMapping(value = "/unBookmarkContent", method = RequestMethod.POST)
	public @ResponseBody int unBookmarkContent(Model model, @RequestBody BookmarkArticleDTO bookmarkArticleDto) {
		int result = 0;

		logger.debug("unBookmarkContent()");
		logger.debug(bookmarkArticleDto.toString());
		result = boardService.unBookmarkContent(bookmarkArticleDto);

		return result;
	}

	@RequestMapping(value = "/thumbsUpContent", method = RequestMethod.POST)
	public @ResponseBody int thumbsUpContent(Model model, @RequestBody VoteArticleDTO voteArticleDto) {
		int result = 0;

		logger.debug(voteArticleDto.toString());
		result = boardService.thumbsUpContent(voteArticleDto);

		return result;
	}

	@RequestMapping(value = "/thumbsDownContent", method = RequestMethod.POST)
	public @ResponseBody int thumbsDownContent(Model model, @RequestBody VoteArticleDTO voteArticleDto) {
		int result = 0;

		result = boardService.thumbsDownContent(voteArticleDto);

		return result;
	}

	@RequestMapping(value = "/reportContent")
	public @ResponseBody int reportContent(Model model, @RequestBody ReportArticleDTO reportArticleDto) {
		int result = 0;

		logger.debug("reportContent()");
		logger.debug(reportArticleDto.toString());
		result = boardService.reportContent(reportArticleDto);

		return result;
	}

	@RequestMapping(value = "/thumbsUpComment")
	public @ResponseBody int thumbsUpComment(Model model, @RequestBody VoteCommentDTO voteCommentDto) {
		int result = 0;

		logger.debug("thumbsUpComment()");
		logger.debug(voteCommentDto.toString());
		result = boardService.thumbsUpComment(voteCommentDto);

		return result;
	}

	@RequestMapping(value = "/thumbsDownComment")
	public @ResponseBody int thumbsDownComment(Model model, @RequestBody VoteCommentDTO voteCommentDto) {
		int result = 0;

		logger.debug("thumbsDownComment()");
		logger.debug(voteCommentDto.toString());
		result = boardService.thumbsDownComment(voteCommentDto);

		return result;
	}
}
