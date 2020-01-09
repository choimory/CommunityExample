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

	@Override
	public Map<String, Object> list(String bId, PageHelper pageHelper) {
		Map<String, Object> listMap = null;
		BoardTypeDTO boardTypeDto = null;
		List<String> boardCategoryList=null;
		List<BoardDTO> boardDtoList = null;
		BoardDTO boardDto = null;

		// 1.받은 게시판Id가 시스템에 존재하는 게시판id인지 확인
		if (isBoardIdExists(bId)) {
			boardDto = new BoardDTO(bId, pageHelper);
			// 2.해당 bId에 맞는 bType얻기
			boardTypeDto = boardDao.getBoardType(bId);
			boardDto.setBoardTypeDto(boardTypeDto);
			// 3. bType에 해당되는 테이블에서 page를 이용해서 BoardDTO 20개 가져오기
			boardDtoList = boardDao.list(boardDto);
			// 4.해당게시판의 bCategory모음 가져오기
			boardCategoryList = boardDao.getBoardCategories(boardDto);
			// 5.해당게시판이 북마크된 게시판인지 확인
			// 6.put
			listMap = new HashMap<String, Object>();
			listMap.put("boardDtoList", boardDtoList);
			listMap.put("boardCategoryList", boardCategoryList);
		}

		return listMap;
	}

	@Override
	public Map<String, Object> content(String bId, String stringBoardIdx) {
		Map<String, Object> contentMap = null;
		List<String> boardCategoryList=null;
		BoardDTO boardDto = null;
		List<BoardCommentDTO> boardCommentDtoList = null;
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
				boardCommentDtoList = boardCommentDao.commentList(boardDto);
				// 4.해당게시판의 bCategory모음 가져오기
				boardCategoryList = boardDao.getBoardCategories(boardDto);
				// 5.해당게시판이 북마크된 게시판인지 확인
				// 6.해당게시물이 북마크된 게시물인지 확인
				// 7.put
				contentMap = new HashMap<String, Object>();
				contentMap.put("boardDto", boardDto);
				contentMap.put("boardCommentDtoList", boardCommentDtoList);
				contentMap.put("boardCategoryList", boardCategoryList);
			}
		}

		return contentMap;
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
			result = boardDao.modifyBoard(boardDto);
			if (result == SUCCESS) {
				// update board info
				result = boardDao.modifyBoardInfo(boardDto);
				if (result == SUCCESS) {
					// update board file
					result = boardDao.modifyBoardFile(boardDto);
				}
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
				result = boardDao.deleteBoard(boardDto);
				if (result == SUCCESS) {
					// delete board info
					result = boardDao.deleteBoardInfo(boardDto);
					if (result == SUCCESS) {
						// delete board file
						result = boardDao.deleteBoardFile(boardDto);
					}
				}
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
			// select BoardDTO with query, target and page
			boardDtoList = boardDao.search(boardDto);
		}

		return boardDtoList;
	}

	@Override
	public List<BoardCommentDTO> comment(BoardCommentDTO boardCommentDto, BoardTypeDTO boardTypeDto, PageHelper pageHelper) {
		List<BoardCommentDTO> boardCommentDtoList = null;

		// bId check
		if (isBoardIdExists(boardTypeDto.getbId())) {
			// get bType
			boardTypeDto = boardDao.getBoardType(boardTypeDto.getbId());
			boardCommentDto.setBoardTypeDto(boardTypeDto);
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
			if (result == SUCCESS) {
				result = boardCommentDao.modifyCommentInfo(boardCommentDto);
			}
			// 수정된 댓글은 [댓글수정일자 : yyyy-mm-dd]가 꼬릿말로 붙도록 할것
			// 이게 가능하려면 db에 수정여부를 저장한뒤 jstl을 이용해 프론트에서 조정해야?..
		}

		return result;
	}

	@Override
	public int deleteComment(BoardCommentDTO boardCommentDto,BoardTypeDTO boardTypeDto) {
		int result = 0;

		// bId check
		if (isBoardIdExists(boardTypeDto.getbId())) {
			// get bType
			boardCommentDto.setBoardTypeDto(boardDao.getBoardType(boardCommentDto));
			// delete bcIdx
			result = boardCommentDao.deleteComment(boardCommentDto);
			if (result == SUCCESS) {
				boardCommentDao.deleteCommentInfo(boardCommentDto);
			}

		}

		return result;
	}

	@Override
	public int replyComment(BoardCommentDTO boardCommentDto,BoardTypeDTO boardTypeDto) {
		int result = 0;

		// bId check
		if (isBoardIdExists(boardTypeDto.getbId())) {
			// get bType
			boardCommentDto.setBoardTypeDto(boardDao.getBoardType(boardCommentDto));
			// insert
			result = boardCommentDao.replyComment(boardCommentDto);
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
		// insert
		result = boardDao.bookmarkBoard(bookmarkBoardDto);

		return result;
	}

	@Override
	public int bookmarkContent(BookmarkArticleDTO bookmarkArticleDto) {
		int result = 0;

		// btype을 얻어와서 dto에 세팅후
		bookmarkArticleDto.setbType(boardDao.getbType(bookmarkArticleDto.getbId()));
		// insert
		result = boardDao.bookmarkArticle(bookmarkArticleDto);

		return result;
	}

	@Override
	public int thumbsUpContent(VoteArticleDTO voteArticleDto) {
		int result = 0;

		// bid check
		if (isBoardIdExists(voteArticleDto.getbId())) {
			// get btype
			voteArticleDto.setbType(boardDao.getbType(voteArticleDto.getbId()));
			// vote article에 해당 게시물 추천 이력이 있는지 확인
			result = boardDao.checkVoteArticleAlready(voteArticleDto);
			if (result < 1) {
				// update upvote
				result = boardDao.updateVoteNum(voteArticleDto);
				if (result == SUCCESS) {
					// insert vote article
					result = boardDao.writeVoteInfo(voteArticleDto);
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
				result = boardDao.updateVoteNum(voteArticleDto);
				if (result == SUCCESS) {
					// insert vote article
					result = boardDao.writeVoteInfo(voteArticleDto);
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
			// report article에 해당 게시물 추천 이력이 있는지
			result = boardDao.checkReportAlready(boardDto);
			if (result < 1) {
				// update reportnum
				result = boardDao.updateReportNum(boardDto);
				if (result == SUCCESS) {
					// insert report article
					result = boardDao.writeReportArticle(boardDto);
				}
			}
		}

		return result;
	}

	@Override
	public int thumbsUpComment(VoteCommentDTO voteCommentDto) {
		int result = 0;

		// bid check
		if (isBoardIdExists(voteCommentDto.getbId())) {
			// get btype
			voteCommentDto.setbType(boardDao.getbType(voteCommentDto.getbId()));
			// vote comment에 해당 게시물의 해당댓글에 대한 추천 이력이 있는지
			result = boardCommentDao.checkVoteCommentAlready(voteCommentDto);
			if (result < 1) {
				// update upvote
				result = boardCommentDao.updateCommentVoteNum(voteCommentDto);
				// insert vote comment
				result = boardCommentDao.writeVoteCommentInfo(voteCommentDto);
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
				result=boardCommentDao.updateCommentVoteNum(voteCommentDto);
				if(result==SUCCESS) {
					// insert vote comment
					result=boardCommentDao.writeVoteCommentInfo(voteCommentDto);
				}
			}
		}
		return result;
	}

}
