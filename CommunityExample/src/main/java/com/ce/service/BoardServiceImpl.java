package com.ce.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ce.component.PageHelper;
import com.ce.component.SearchHelper;
import com.ce.dao.BoardCommentDAO;
import com.ce.dao.BoardDAO;
import com.ce.dto.BoardCommentDTO;
import com.ce.dto.BoardDTO;
import com.ce.dto.BoardInfoDTO;
import com.ce.dto.BoardTypeDTO;
import com.ce.dto.BookmarkArticleDTO;
import com.ce.dto.BookmarkBoardDTO;
import com.ce.dto.VoteArticleDTO;
import com.ce.dto.VoteCommentDTO;

public class BoardServiceImpl implements BoardService {
	private BoardDAO boardDao;
	private BoardCommentDAO boardCommentDao;
	private final int SUCCESS = 1;
	private final int FAIL = -1;

	public void setBoardDao(BoardDAO boardDao) {
		this.boardDao = boardDao;
	}

	public BoardCommentDAO getBoardCommentDao() {
		return boardCommentDao;
	}

	public void setBoardCommentDao(BoardCommentDAO boardCommentDao) {
		this.boardCommentDao = boardCommentDao;
	}

	private boolean isBoardIdExists(String bId) {
		boolean result = false;
		List<String> boardIdList = null;

		// 받은 게시판Id가 시스템에 존재하는 게시판id인지 확인
		// bId와 bIdList를 foreach로 비교해서 true값이 하나도 안나올시 null 리턴, 하나라도 나올시 작업수행
		boardIdList = boardDao.getBoardIdList();
		for (String tmp : boardIdList) {
			if (tmp.equals(bId)) {
				result = true;
			}
		}
		return result;
	}

	private int stringIdxToInteger(String index) {
		int result = 0;
		try {
			result = Integer.parseInt(index);
		} catch (NumberFormatException ne) {
			result = -1;
		}
		return result;
	}

	private void paging(PageHelper pageHelper, int totalRow) {
		pageHelper.list();
		pageHelper.pagination2(totalRow);
	}

	@Override
	public Map<String, Object> list(String bId, PageHelper pageHelper) {
		Map<String, Object> returnMap = null;
		BoardTypeDTO boardTypeDto = null;
		List<String> boardCategoryList = null;
		List<BoardDTO> boardDtoList = null;
		BoardDTO boardDto = null;

		// 1.받은 게시판Id가 시스템에 존재하는 게시판id인지 확인
		if (isBoardIdExists(bId)) {
			boardDto = new BoardDTO(bId, pageHelper);
			// 2.해당 bId에 맞는 bType얻기
			boardTypeDto = boardDao.getBoardType(bId);
			boardDto.setBoardTypeDto(boardTypeDto);
			// 3. bType에 해당되는 테이블에서 page를 이용해서 BoardDTO 20개 가져오기
			paging(pageHelper, boardDao.getTotalRow(boardDto));
			boardDto.setPageHelper(pageHelper);
			boardDtoList = boardDao.list(boardDto);
			// 4.해당게시판의 bCategory모음 가져오기
			boardCategoryList = boardDao.getBoardCategories(boardDto);
			// TODO 5.해당게시판이 북마크된 게시판인지 확인
			// 6.put
			returnMap = new HashMap<String, Object>();
			;
			returnMap.put("boardDtoList", boardDtoList);
			returnMap.put("boardCategoryList", boardCategoryList);
			returnMap.put("pageHelper", pageHelper);
		}

		return returnMap;
	}

	@Override
	public Map<String, Object> content(String bId, String stringBoardIdx, PageHelper pageHelper) {
		Map<String, Object> returnMap = null;
		List<String> boardCategoryList = null;
		BoardDTO boardDto = null;
		List<BoardCommentDTO> boardCommentDtoList = null;
		List<BoardDTO> boardDtoList = null;
		BoardTypeDTO boardTypeDto = null;
		int bIdx = 0;

		// 1.bIdx가 숫자인지 문자열인지 확인
		if (stringIdxToInteger(stringBoardIdx) != FAIL) {
			bIdx = stringIdxToInteger(stringBoardIdx);
			boardDto = new BoardDTO(bId, bIdx);
			// 2.받은 게시판Id가 시스템에 존재하는 게시판id인지 확인
			if (isBoardIdExists(bId)) {
				// 2.해당 bIdx의 boardDto 가져오기
				boardDto = boardDao.content(boardDto);
				// 3.해당 bIdx의 boardCommentDtoList가져오기
				// TODO 오래된순으로 SELECT한뒤 가장 마지막 페이지를 대상으로 가져오는 페이징 작업 필요
				pageHelper.list();
				boardDto.setPageHelper(pageHelper);
				boardCommentDtoList = boardCommentDao.comment(boardDto);
				// 4.해당게시판의 bCategory모음 가져오기
				boardCategoryList = boardDao.getBoardCategories(boardDto);
				// 5.글목록 가져오기
				paging(pageHelper, boardDao.getTotalRow(boardDto));
				boardDto.setPageHelper(pageHelper);
				boardDtoList = boardDao.list(boardDto);
				// TODO 5.해당게시판이 북마크된 게시판인지 확인
				// TODO 6.해당게시물이 북마크된 게시물인지 확인
				// HIT증가
				boardDao.increaseHit(boardDto);
				// 7.put
				returnMap = new HashMap<String, Object>();
				returnMap.put("boardDto", boardDto);
				returnMap.put("boardCommentDtoList", boardCommentDtoList);
				returnMap.put("boardCategoryList", boardCategoryList);
				returnMap.put("boardDtoList", boardDtoList);
				returnMap.put("pageHelper", pageHelper);
			}
		}

		return returnMap;
	}

	@Override
	public BoardDTO write(BoardDTO boardDto) {
		int result = 0;

		// bid check
		if (isBoardIdExists(boardDto.getbId())) {
			// getbType
			boardDto.setBoardTypeDto(boardDao.getBoardType(boardDto));
			// insert
			result = boardDao.write(boardDto);
			if (result == SUCCESS) {
				result = boardDao.writeInfo(boardDto);
			}
		} else {
			boardDto = null;
		}

		return boardDto;
	}

	@Override
	public BoardDTO modifyForm(BoardDTO boardDto) {
		BoardTypeDTO boardTypeDto = null;

		// bId check
		if (isBoardIdExists(boardDto.getbId())) {
			// get bType
			boardTypeDto = boardDao.getBoardType(boardDto);
			boardDto.setBoardTypeDto(boardTypeDto);
			// select bdto
			boardDto = boardDao.content(boardDto);
		} else {
			boardDto = null;
		}

		return boardDto;
	}

	@Override
	public BoardDTO modify(BoardDTO boardDto, BoardInfoDTO boardInfoDto) {
		BoardTypeDTO boardTypeDto = null;
		int result = 0;

		// bId check
		if (isBoardIdExists(boardDto.getbId())) {
			// get bType
			boardTypeDto = boardDao.getBoardType(boardDto);
			boardDto.setBoardTypeDto(boardTypeDto);
			// update board
			result = boardDao.modify(boardDto);
			if (result == SUCCESS) {
				result = boardDao.modifyFile(boardDto);
			}
		} else {
			boardDto = null;
		}

		return boardDto;
	}

	@Override
	public int delete(BoardDTO boardDto) {
		int result = 0;
		BoardTypeDTO boardTypeDto = null;

		// bId check
		if (isBoardIdExists(boardDto.getbId())) {
			// get bType
			boardTypeDto = boardDao.getBoardType(boardDto);
			boardDto.setBoardTypeDto(boardTypeDto);
			if (result == SUCCESS) {
				// delete board
				result = boardDao.delete(boardDto);
				result = boardDao.deleteFile(boardDto);
			}
		}

		return result;
	}

	@Override
	public List<BoardDTO> search(BoardDTO boardDto, SearchHelper searchHelper, PageHelper pageHelper) {
		List<BoardDTO> boardDtoList = null;
		BoardTypeDTO boardTypeDto = null;

		// bId check
		if (isBoardIdExists(boardDto.getbId())) {
			// get bType
			boardTypeDto = boardDao.getBoardType(boardDto);
			boardDto.setBoardTypeDto(boardTypeDto);
			// TODO select BoardDTO with query, target and page
			boardDtoList = boardDao.search(boardDto);
		}

		return boardDtoList;
	}

	@Override
	public List<BoardCommentDTO> comment(BoardCommentDTO boardCommentDto, BoardTypeDTO boardTypeDto,
			PageHelper pageHelper) {
		List<BoardCommentDTO> boardCommentDtoList = null;

		// bId check
		if (isBoardIdExists(boardTypeDto.getbId())) {
			// get bType
			boardTypeDto = boardDao.getBoardType(boardTypeDto.getbId());
			boardCommentDto.setBoardTypeDto(boardTypeDto);
			// set Paging
			pageHelper.list();
			pageHelper.pagination2(boardCommentDao.getTotalRow(boardCommentDto));
			boardCommentDto.setPageHelper(pageHelper);
			// page를 이용해서 댓글 30개 가져오기
			boardCommentDtoList = boardCommentDao.comment(boardCommentDto);
			// ajax
		}

		return boardCommentDtoList;
	}

	@Override
	public int writeComment(BoardCommentDTO boardCommentDto, BoardTypeDTO boardTypeDto) {
		int result = 0;

		// bId check
		if (isBoardIdExists(boardTypeDto.getbId())) {
			// get bType
			boardCommentDto.setBoardTypeDto(boardDao.getBoardType(boardTypeDto.getbId()));
			// bcdto의 bcgroup을 설정
			boardCommentDto.setBcGroup(boardCommentDao.commentGrouping(boardCommentDto));
			// 해당 댓글테이블에 insert
			result = boardCommentDao.writeComment(boardCommentDto);
			if (result == SUCCESS) {
				result = boardCommentDao.writeCommentInfo(boardCommentDto);
			}
			// ajax 혹은 redirect content
		}

		return result;
	}

	@Override
	public int modifyComment(BoardCommentDTO boardCommentDto, BoardTypeDTO boardTypeDto) {
		int result = 0;

		// bId check
		if (isBoardIdExists(boardTypeDto.getbId())) {
			// get bType
			boardCommentDto.setBoardTypeDto(boardDao.getBoardType(boardTypeDto.getbId()));
			// update
			result = boardCommentDao.modifyComment(boardCommentDto);
		}

		return result;
	}

	@Override
	public int deleteComment(BoardCommentDTO boardCommentDto, BoardTypeDTO boardTypeDto) {
		int result = 0;

		// bId check
		if (isBoardIdExists(boardTypeDto.getbId())) {
			// get bType
			boardCommentDto.setBoardTypeDto(boardDao.getBoardType(boardTypeDto));
			// delete bcIdx
			result = boardCommentDao.deleteComment(boardCommentDto);

		}

		return result;
	}

	@Override
	public int replyComment(BoardCommentDTO boardCommentDto, BoardTypeDTO boardTypeDto) {
		int result = 0;

		// bId check
		if (isBoardIdExists(boardTypeDto.getbId())) {
			// get bType
			boardCommentDto.setBoardTypeDto(boardDao.getBoardType(boardTypeDto));
			// TODO 서비스단에서 group step indent를 조정하던지 클라이언트단에서 자바스크립트로 조정해서 넘기던지
			// insert
			result = boardCommentDao.writeComment(boardCommentDto);
			if (result == SUCCESS) {
				result = boardCommentDao.writeCommentInfo(boardCommentDto);
			}
		}

		return result;
	}

	@Override
	public int bookmarkBoard(BookmarkBoardDTO bookmarkBoardDto) {
		int result = 0;

		// 받은 bid에 해당되는 btype을 가져와서 set
		bookmarkBoardDto.setbType(boardDao.getBoardType(bookmarkBoardDto.getbId()).getbType());
		// TODO 게시판 북마크 insert or delete
		result = boardDao.bookmarkBoard(bookmarkBoardDto);
		result = boardDao.unBookmarkBoard(bookmarkBoardDto);

		return result;
	}

	@Override
	public int bookmarkContent(BookmarkArticleDTO bookmarkArticleDto) {
		int result = 0;

		// btype을 얻어와서 dto에 세팅후
		bookmarkArticleDto.setbType(boardDao.getbType(bookmarkArticleDto.getbId()));
		// TODO 글 북마크 insert or delete
		result = boardDao.bookmarkArticle(bookmarkArticleDto);
		result = boardDao.unBookmarkArticle(bookmarkArticleDto);

		return result;
	}

	@Override
	public int thumbsUpContent(VoteArticleDTO voteArticleDto, int upvote, int downvote) {
		int result = 0;

		// bid check
		if (isBoardIdExists(voteArticleDto.getbId())) {
			// get btype
			voteArticleDto.setbType(boardDao.getbType(voteArticleDto.getbId()));
			// vote article에 해당 게시물 추천 이력이 있는지 확인
			result = boardDao.checkVoteArticleAlready(voteArticleDto);
			if (result < 1) {
				// update upvote
				result = boardDao.thumbsUpContent(voteArticleDto);
				// 추천수가 일정이상이면 BEST등록
				if (upvote - downvote == 50) {
					boardDao.goBest(voteArticleDto);
				}
				if (result == SUCCESS) {
					// insert vote article
					result = boardDao.writeVoteArticle(voteArticleDto);
				}
			}
		}

		return result;
	}

	@Override
	public int thumbsDownContent(VoteArticleDTO voteArticleDto) {
		int result = 0;

		// bid check
		if (isBoardIdExists(voteArticleDto.getbId())) {
			// get btype
			voteArticleDto.setbType(boardDao.getbType(voteArticleDto.getbId()));
			// vote article에 해당 게시물 추천 이력이 있는지
			result = boardDao.checkVoteArticleAlready(voteArticleDto);
			if (result < 1) {
				// update upvote
				result = boardDao.thumbsDownContent(voteArticleDto);
				if (result == SUCCESS) {
					// insert vote article
					result = boardDao.writeVoteArticle(voteArticleDto);
				}
			}
		}

		return result;
	}

	@Override
	public int reportContent(BoardDTO boardDto) {
		int result = 0;

		// bid check
		if (isBoardIdExists(boardDto.getbId())) {
			// get btype
			boardDto.setBoardTypeDto(boardDao.getBoardType(boardDto));
			// report article에 해당 게시물 신고 이력이 있는지
			result = boardDao.checkReportAlready(boardDto);
			if (result < 1) {
				// update reportnum
				result = boardDao.increaseReport(boardDto);
				if (result == SUCCESS) {
					// insert report article
					result = boardDao.writeReportArticle(boardDto);
				}
			}
		}

		return result;
	}

	@Override
	public int thumbsUpComment(VoteCommentDTO voteCommentDto, int upvote, int downvote) {
		int result = 0;

		// bid check
		if (isBoardIdExists(voteCommentDto.getbId())) {
			// get btype
			voteCommentDto.setbType(boardDao.getbType(voteCommentDto.getbId()));
			// vote comment에 해당 게시물의 해당댓글에 대한 추천 이력이 있는지
			result = boardCommentDao.checkVoteCommentAlready(voteCommentDto);
			if (result < 1) {
				// update upvote
				result = boardCommentDao.thumbsUpComment(voteCommentDto);
				// 추천수가 일정이상이면 BEST등록
				if (upvote - downvote == 50) {
					boardCommentDao.goBest(voteCommentDto);
				}
				// insert vote comment
				result = boardCommentDao.writeVoteComment(voteCommentDto);
			}
		}

		return result;
	}

	@Override
	public int thumbsDownComment(VoteCommentDTO voteCommentDto) {
		int result = 0;

		// bid check
		if (isBoardIdExists(voteCommentDto.getbId())) {
			// get btype
			voteCommentDto.setbType(boardDao.getbType(voteCommentDto.getbId()));
			// vote comment에 해당 게시물의 해당댓글에 대한 추천 이력이 있는지
			result = boardCommentDao.checkVoteCommentAlready(voteCommentDto);
			if (result < 1) {
				// update upvote
				result = boardCommentDao.thumbsDownComment(voteCommentDto);
				if (result == SUCCESS) {
					// insert vote comment
					result = boardCommentDao.writeVoteComment(voteCommentDto);
				}
			}
		}
		return result;
	}

}
