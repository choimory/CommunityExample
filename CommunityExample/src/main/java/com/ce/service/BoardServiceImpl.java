package com.ce.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.ce.component.PageHelper;
import com.ce.component.SearchHelper;
import com.ce.dao.BoardCommentDAO;
import com.ce.dao.BoardDAO;
import com.ce.dao.MemberDAO;
import com.ce.dto.BoardCommentDTO;
import com.ce.dto.BoardCommentInfoDTO;
import com.ce.dto.BoardDTO;
import com.ce.dto.BoardFileDTO;
import com.ce.dto.BoardInfoDTO;
import com.ce.dto.BoardTypeDTO;
import com.ce.dto.BookmarkArticleDTO;
import com.ce.dto.BookmarkBoardDTO;
import com.ce.dto.MemberDTO;
import com.ce.dto.ReportArticleDTO;
import com.ce.dto.VoteArticleDTO;
import com.ce.dto.VoteCommentDTO;

public class BoardServiceImpl implements BoardService {
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	private BoardDAO boardDao;
	private BoardCommentDAO boardCommentDao;
	@Autowired
	private MemberDAO memberDao;
	private final int SUCCESS = 1;
	private final int FAIL = -1;

	public void setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

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

	private int fileUpload(List<MultipartFile> files, int bIdx, String bType) {
		int result = 0;
		BufferedOutputStream bufferdOutputStream = null;
		BoardFileDTO boardFileDto = null;
		BoardTypeDTO boardTypeDto = new BoardTypeDTO();
		String filePath = "C:\\choimory_IDE\\Java\\Workspace\\choimory_workspace-CommunityExample\\file repository\\" + bType + "\\";
		String fOriginalName = null;
		String fStoredName = null;
		byte[] fileBytes = null;

		if (!files.isEmpty()) {
			boardTypeDto = new BoardTypeDTO();
			boardTypeDto.setbType(bType);
			for (MultipartFile file : files) {
				try {
					fOriginalName = file.getOriginalFilename();
					fStoredName = bIdx + "_" + file.getOriginalFilename();
					fileBytes = file.getBytes();

					bufferdOutputStream = new BufferedOutputStream(new FileOutputStream(new File(filePath, fStoredName)));
					bufferdOutputStream.write(fileBytes);
					bufferdOutputStream.close();

					boardFileDto = new BoardFileDTO(bIdx, fOriginalName, fStoredName, file.getSize());
					boardFileDto.setBoardTypeDto(boardTypeDto);
					boardDao.insertBoardFile(boardFileDto);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					result = -1;
				} catch (IOException e) {
					e.printStackTrace();
					result = -1;
				}
			}
		}

		return result;
	}

	@Override
	public Map<String, Object> best(PageHelper pageHelper, SearchHelper searchHelper, MemberDTO memberDto) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<String> boardTypeList = null;
		List<BoardDTO> boardDtoList = null;
		BoardTypeDTO boardTypeDto = null;
		pageHelper.setSearchHelper(searchHelper);
		int isBookmarkedBoard = 0;

		log.debug("best();");
		// 페이징작업(총 글수 필요) 및 글가져오기
		boardTypeList = boardDao.getBoardTypeList();
		pageHelper.paging(boardDao.getBestTotalRow(boardTypeList));
		boardDtoList = boardDao.best(pageHelper);
		log.debug(boardDtoList.toString());
		// boardType가져오기
		boardTypeDto = boardDao.getBoardType("best");
		// 해당게시판이 북마크된 게시판인지 확인
		if (memberDto != null) {
			BookmarkBoardDTO bookmarkBoardDto = new BookmarkBoardDTO();
			bookmarkBoardDto.setmId(memberDto.getmId());
			bookmarkBoardDto.setbId("best");
			isBookmarkedBoard = boardDao.isBookmarkedBoard(bookmarkBoardDto);
		}

		resultMap.put("pageHelper", pageHelper);
		resultMap.put("boardTypeDto", boardTypeDto);
		resultMap.put("boardDtoList", boardDtoList);
		resultMap.put("isBookmarkedBoard", isBookmarkedBoard);
		return resultMap;
	}

	@Override
	public Map<String, Object> list(String bId, PageHelper pageHelper, SearchHelper searchHelper, MemberDTO memberDto) {
		Map<String, Object> resultMap = null;
		BoardTypeDTO boardTypeDto = null;
		List<String> boardCategoryList = null;
		List<BoardDTO> boardDtoList = null;
		BoardDTO boardDto = null;
		int isBookmarkedBoard = 0;

		// 1.받은 게시판Id가 시스템에 존재하는 게시판id인지 확인
		if (isBoardIdExists(bId)) {
			resultMap = new HashMap<String, Object>();
			boardDto = new BoardDTO(bId, pageHelper);
			// 2.해당 bId에 맞는 bType얻기
			boardTypeDto = boardDao.getBoardType(bId);
			boardDto.setBoardTypeDto(boardTypeDto);
			// 3. bType에 해당되는 테이블에서 page를 이용해서 BoardDTO 20개 가져오기
			pageHelper.paging(boardDao.getTotalRow(boardDto));
			boardDto.setPageHelper(pageHelper);
			boardDto.setSearchHelper(searchHelper);
			boardDtoList = boardDao.list(boardDto);
			// 4.해당게시판의 bCategory모음 가져오기
			boardCategoryList = boardDao.getBoardCategory(boardDto.getbId());
			// 5.해당게시판이 북마크된 게시판인지 확인
			if (memberDto != null) {
				BookmarkBoardDTO bookmarkBoardDto = new BookmarkBoardDTO();
				bookmarkBoardDto.setmId(memberDto.getmId());
				bookmarkBoardDto.setbId(bId);
				isBookmarkedBoard = boardDao.isBookmarkedBoard(bookmarkBoardDto);
			}

			// 6.put
			resultMap.put("boardTypeDto", boardTypeDto);
			resultMap.put("boardCategoryList", boardCategoryList);
			resultMap.put("boardDtoList", boardDtoList);
			resultMap.put("pageHelper", pageHelper);
			resultMap.put("isBookmarkedBoard", isBookmarkedBoard);
		}

		return resultMap;
	}

	@Override
	public Map<String, Object> bestContent(String bId, String stringIdx, PageHelper pageHelper, SearchHelper searchHelper, MemberDTO memberDto) {
		Map<String, Object> resultMap = null;
		int result = 0;
		BoardTypeDTO bestTypeDto = null;
		BoardTypeDTO boardTypeDto = null;
		int bIdx = 0;
		BoardDTO boardDto = null;
		List<BoardFileDTO> boardFileDtoList = null;
		List<BoardCommentDTO> boardCommentDtoList = null;
		List<String> boardTypeList = null;
		List<BoardDTO> boardDtoList = null;
		int isBookmarkedBoard = 0;
		int isBookmarkedArticle = 0;

		log.debug("bestContent();");
		if (isBoardIdExists(bId)) {
			if (stringIdxToInteger(stringIdx) != FAIL) {
				bIdx = stringIdxToInteger(stringIdx);
				// best게시판의 boardTypeDto가져오기
				bestTypeDto = boardDao.getBoardType("best");
				// 원글의 게시판에 해당하는 boardtypedto가져오기
				boardTypeDto = boardDao.getBoardType(bId);
				// boardDto 세팅
				boardDto = new BoardDTO(bId, bIdx);
				boardDto.setBoardTypeDto(boardTypeDto);
				// 조회수 증가
				result = boardDao.increaseHit(boardDto);
				// boarddto가져오기
				boardDto = boardDao.content(boardDto);
				boardDto.setBoardTypeDto(boardTypeDto);
				boardFileDtoList = boardDao.contentFile(boardDto);
				boardDto.setBoardFileDtoList(boardFileDtoList);
				// 해당글의 댓글 가져오기
				PageHelper commentPageHelper = new PageHelper();
				commentPageHelper.setDisplayNum(40);
				commentPageHelper.setPage(999, boardCommentDao.getTotalRow(boardDto));
				commentPageHelper.paging(boardCommentDao.getTotalRow(boardDto));
				boardDto.setPageHelper(commentPageHelper);
				boardCommentDtoList = boardCommentDao.comment(boardDto);
				// best게시판 글목록 가져오기
				boardTypeList = boardDao.getBoardTypeList();
				pageHelper.paging(boardDao.getBestTotalRow(boardTypeList));
				pageHelper.setSearchHelper(searchHelper);
				boardDtoList = boardDao.best(pageHelper);

				// 회원일경우 북마크여부 확인하기
				if (memberDto != null) {
					// bookmarkBoardDto, bookmarkArticleDto 세팅
					BookmarkBoardDTO bookmarkBoardDto = new BookmarkBoardDTO();
					bookmarkBoardDto.setmId(memberDto.getmId());
					bookmarkBoardDto.setbId("best");
					BookmarkArticleDTO bookmarkArticleDto = new BookmarkArticleDTO();
					bookmarkArticleDto.setmId(memberDto.getmId());
					bookmarkArticleDto.setbId(bId);
					bookmarkArticleDto.setbIdx(bIdx);
					// 해당게시판 북마크여부
					isBookmarkedBoard = boardDao.isBookmarkedBoard(bookmarkBoardDto);
					// 해당게시물 북마크여부
					isBookmarkedArticle = boardDao.isBookmarkedArticle(bookmarkArticleDto);
				}

				resultMap = new HashMap<String, Object>();
				resultMap.put("boardTypeDto", bestTypeDto);
				resultMap.put("boardDto", boardDto);
				resultMap.put("boardCommentDtoList", boardCommentDtoList);
				resultMap.put("commentPageHelper", commentPageHelper);
				resultMap.put("boardDtoList", boardDtoList);
				resultMap.put("pageHelper", pageHelper);
				resultMap.put("isBookmarkedBoard", isBookmarkedBoard);
				resultMap.put("isBookmarkedArticle", isBookmarkedArticle);
			}
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> content(String bId, String stringBoardIdx, PageHelper pageHelper, SearchHelper searchHelper, MemberDTO memberDto) {
		Map<String, Object> resultMap = null;
		List<String> boardCategoryList = null;
		BoardDTO boardDto = null;
		List<BoardFileDTO> boardFileDtoList = null;
		List<BoardCommentDTO> boardCommentDtoList = null;
		List<BoardDTO> boardDtoList = null;
		BoardTypeDTO boardTypeDto = null;
		int bIdx = 0;
		int isBookmarkedBoard = 0;
		int isBookmarkedArticle = 0;

		if (isBoardIdExists(bId)) {
			// 1.bIdx가 숫자인지 문자열인지 확인
			if (stringIdxToInteger(stringBoardIdx) != FAIL) {
				bIdx = stringIdxToInteger(stringBoardIdx);
				boardDto = new BoardDTO(bId, bIdx);

				// 2.받은 게시판Id가 시스템에 존재하는 게시판id인지 확인
				if (isBoardIdExists(bId)) {
					// boardTypeDto가져오기
					boardTypeDto = boardDao.getBoardType(bId);
					boardDto.setBoardTypeDto(boardTypeDto);

					// HIT증가
					boardDao.increaseHit(boardDto);

					// 해당 bIdx의 boardDto 가져오기
					boardDto = boardDao.content(boardDto);
					boardDto.setBoardTypeDto(boardTypeDto);
					boardFileDtoList = boardDao.contentFile(boardDto);
					boardDto.setBoardFileDtoList(boardFileDtoList);

					// 해당 bIdx의 boardCommentDtoList가져오기
					PageHelper commentPageHelper = new PageHelper();
					commentPageHelper.setDisplayNum(40);
					commentPageHelper.setPage(999, boardCommentDao.getTotalRow(boardDto));
					commentPageHelper.paging(boardCommentDao.getTotalRow(boardDto));
					boardDto.setPageHelper(commentPageHelper);
					boardCommentDtoList = boardCommentDao.comment(boardDto);

					// 4.해당게시판의 bCategory모음 가져오기
					boardCategoryList = boardDao.getBoardCategory(boardDto.getbId());

					// 5.글목록 가져오기
					pageHelper.paging(boardDao.getTotalRow(boardDto));
					boardDto.setPageHelper(pageHelper);
					boardDto.setSearchHelper(searchHelper);
					boardDtoList = boardDao.list(boardDto);

					if (memberDto != null) {
						// 5.해당게시판이 북마크된 게시판인지 확인
						BookmarkBoardDTO bookmarkBoardDto = new BookmarkBoardDTO();
						bookmarkBoardDto.setmId(memberDto.getmId());
						bookmarkBoardDto.setbId(bId);
						isBookmarkedBoard = boardDao.isBookmarkedBoard(bookmarkBoardDto);
						// 6.해당게시물이 북마크된 게시물인지 확인
						BookmarkArticleDTO bookmarkArticleDto = new BookmarkArticleDTO();
						bookmarkArticleDto.setmId(memberDto.getmId());
						bookmarkArticleDto.setbId(bId);
						bookmarkArticleDto.setbIdx(bIdx);
						isBookmarkedArticle = boardDao.isBookmarkedArticle(bookmarkArticleDto);
					}

					// 7.put
					resultMap = new HashMap<String, Object>();
					resultMap.put("boardTypeDto", boardTypeDto);
					resultMap.put("boardDto", boardDto);
					resultMap.put("boardCommentDtoList", boardCommentDtoList);
					resultMap.put("commentPageHelper", commentPageHelper);
					resultMap.put("boardCategoryList", boardCategoryList);
					resultMap.put("boardDtoList", boardDtoList);
					resultMap.put("pageHelper", pageHelper);
					resultMap.put("isBookmarkedBoard", isBookmarkedBoard);
					resultMap.put("isBookmarkedArticle", isBookmarkedArticle);
				}
			}
		}

		return resultMap;
	}

	@Override
	public Map<String, Object> writeForm(String bId) {
		Map<String, Object> resultMap = null;
		List<String> boardCategoryList = null;
		BoardTypeDTO boardTypeDto = null;

		if (isBoardIdExists(bId)) {
			resultMap = new HashMap<String, Object>();
			boardTypeDto = boardDao.getBoardType(bId);
			boardCategoryList = boardDao.getBoardCategory(bId);
			resultMap.put("boardTypeDto", boardTypeDto);
			resultMap.put("boardCategoryList", boardCategoryList);
		}

		return resultMap;
	}

	@Override
	public BoardDTO write(BoardDTO boardDto, BoardInfoDTO boardInfoDto, List<MultipartFile> files) {
		boardDto.setBoardInfoDto(boardInfoDto);
		int result = 0;

		// bid check
		if (isBoardIdExists(boardDto.getbId())) {
			// getbType
			boardDto.setBoardTypeDto(boardDao.getBoardType(boardDto));
			// insert
			result = boardDao.write(boardDto);
			if (result == SUCCESS) {
				boardDto.setbIdx(boardDao.getLatestIndex(boardDto));
				result = boardDao.writeInfo(boardDto);
				if (files.get(0).getSize() != 0) {
					fileUpload(files, boardDto.getbIdx(), boardDto.getBoardTypeDto().getbType());
				}
			}
		} else {
			boardDto = null;
		}

		return boardDto;
	}

	@Override
	public FileInputStream download(String bId, String stringBoardIdx, String stringFileIdx) {
		String filePath = "C:\\choimory_IDE\\Java\\Workspace\\choimory_workspace-CommunityExample\\file repository\\";
		String fileName = null;
		BoardTypeDTO boardTypeDto = null;
		BoardFileDTO boardFileDto = null;
		File file = null;
		FileInputStream input = null;

		if (isBoardIdExists(bId)) {
			if (stringIdxToInteger(stringBoardIdx) != FAIL) {
				boardFileDto = new BoardFileDTO();

				// bId로 bType가져오기
				boardTypeDto = boardDao.getBoardType(bId);
				// 파일경로 생성
				filePath = filePath + boardTypeDto.getbType() + "\\";
				// boardFileDto 세팅
				boardFileDto.setBoardTypeDto(boardTypeDto);
				if (stringIdxToInteger(stringFileIdx) != FAIL) {
					boardFileDto.setfIdx(stringIdxToInteger(stringFileIdx));
				}
				// fidx,boardType으로 storedFileName 가져오기
				fileName = boardDao.getStoredFileName(boardFileDto);
				// filePath+sotredFileName으로 file객체 생성
				file = new File(filePath + fileName);
				// FileInputStream(file)생성
				try {
					input = new FileInputStream(file);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					input = null;
				}
			}
		}

		return input;
	}

	@Override
	public Map<String, Object> modifyForm(BoardDTO boardDto) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		BoardTypeDTO boardTypeDto = null;
		List<String> boardCategoryList = null;

		// bId check
		if (isBoardIdExists(boardDto.getbId())) {
			// get bType
			boardTypeDto = boardDao.getBoardType(boardDto);
			boardDto.setBoardTypeDto(boardTypeDto);

			// select bdto
			boardDto = boardDao.content(boardDto);
			boardCategoryList = boardDao.getBoardCategory(boardDto.getbId());
			boardDao.getBoardType(boardDto.getbId());

			resultMap.put("boardDto", boardDto);
			resultMap.put("boardCategoryList", boardCategoryList);
			resultMap.put("boardTypeDto", boardTypeDto);
		} else {
			resultMap = null;
		}

		return resultMap;
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
//				result = boardDao.modifyFile(boardDto);
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
			// delete board
			result = boardDao.delete(boardDto);
			if (result == SUCCESS) {
//				result = boardDao.deleteFile(boardDto);
			}
		}

		return result;
	}

	@Override
	public Map<String, Object> comment(String bId, int bIdx, PageHelper commentPageHelper) {
		Map<String, Object> resultMap = null;
		List<BoardCommentDTO> boardCommentDtoList = null;
		BoardTypeDTO boardTypeDto = null;
		BoardCommentDTO boardCommentDto = null;

		// bId check
		if (isBoardIdExists(bId)) {
			resultMap = new HashMap<String, Object>();
			boardCommentDto = new BoardCommentDTO();

			// boardCommentDto 세팅
			boardTypeDto = boardDao.getBoardType(bId);
			boardCommentDto.setbIdx(bIdx);
			boardCommentDto.setBoardTypeDto(boardTypeDto);
			// set Paging
			commentPageHelper.setDisplayNum(40);
			commentPageHelper.paging(boardCommentDao.getTotalRow(boardCommentDto));
			boardCommentDto.setPageHelper(commentPageHelper);
			// page를 이용해서 댓글 30개 가져오기
			boardCommentDtoList = boardCommentDao.comment(boardCommentDto);

			resultMap.put("boardCommentDtoList", boardCommentDtoList);
			resultMap.put("commentPageHelper", commentPageHelper);
		}

		return resultMap;
	}

	@Override
	public int writeComment(BoardTypeDTO boardTypeDto, BoardCommentDTO boardCommentDto, BoardCommentInfoDTO boardCommentInfoDto) {
		int result = 0;

		// bId check
		if (isBoardIdExists(boardTypeDto.getbId())) {
			// set boardTypeDto, set boardCommentInfoDto
			boardCommentDto.setBoardTypeDto(boardDao.getBoardType(boardTypeDto.getbId()));
			boardCommentDto.setBoardCommentInfoDto(boardCommentInfoDto);
			// 해당 댓글테이블에 insert
			result = boardCommentDao.writeComment(boardCommentDto);
			// group값 조정 (독자적인 댓글일시 나의 comment_index가 나의 bcGroup값)
			boardCommentDto.setBcIdx(boardCommentDao.getLatestIndex(boardCommentDto));
			result = boardCommentDao.commentGrouping(boardCommentDto);
			if (result == SUCCESS) {
				boardCommentDto.setBcIdx(boardCommentDao.getLatestIndex(boardCommentDto));
				result = boardCommentDao.writeCommentInfo(boardCommentDto);
				if (result == SUCCESS) {
					result = boardDao.increaseCommentNum(boardCommentDto);
				}
			}
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
			// TODO 대댓글의 group step indent를 조정
			// 조정해야될것
			// bcGroup : 독자적인 댓글일경우 index를, 대댓글일시 bcGroup=대댓글대상의 bcGroup
			// bcStep : 대댓글대상의 bcStep+1을 가진 후, 나랑 같은 step인 대댓글들의 bcStep을 1씩 증가시킬것. 즉 나는 +1,
			// 다른대댓글들은 +2인셈
			// bcIndent : 대댓글 대상보다 +1
			// insert
			result = boardCommentDao.writeComment(boardCommentDto);
			if (result == SUCCESS) {
				result = boardCommentDao.writeCommentInfo(boardCommentDto);
			}
		}

		return result;
	}

	@Override
	public Map<String, Object> bookmarkBoard(BookmarkBoardDTO bookmarkBoardDto) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<BookmarkBoardDTO> bookmarkBoardDtoList = null;
		int result = 0;

		// 중복검사
		result = boardDao.isBookmarkedBoard(bookmarkBoardDto);
		if (result == 0) {// 게시판 북마크 insert
			result = boardDao.bookmarkBoard(bookmarkBoardDto);
			bookmarkBoardDtoList = memberDao.bookmarkBoardList(bookmarkBoardDto.getmId());
			resultMap.put("bookmarkBoardDtoList", bookmarkBoardDtoList);
		} else if (result == 1) {
			result = -1;
		}

		resultMap.put("result", result);
		return resultMap;
	}

	@Override
	public Map<String, Object> unBookmarkBoard(BookmarkBoardDTO bookmarkBoardDto) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<BookmarkBoardDTO> bookmarkBoardDtoList = null;
		int result = 0;

		// 중복검사
		result = boardDao.isBookmarkedBoard(bookmarkBoardDto);
		if (result == 1) {// 게시판 북마크 delete
			result = boardDao.unBookmarkBoard(bookmarkBoardDto);
			bookmarkBoardDtoList = memberDao.bookmarkBoardList(bookmarkBoardDto.getmId());
			resultMap.put("bookmarkBoardDtoList", bookmarkBoardDtoList);
		} else if (result == 0) {
			result = -1;
		}

		resultMap.put("result", result);
		return resultMap;
	}

	@Override
	public int bookmarkContent(BookmarkArticleDTO bookmarkArticleDto) {
		int result = 0;

		// 북마크 되어있는 글인지 확인
		result = boardDao.checkBookmarkArticleAlready(bookmarkArticleDto);
		if (result == 0) {
			// btype을 얻어와서 dto에 세팅후
			bookmarkArticleDto.setbType(boardDao.getbType(bookmarkArticleDto.getbId()));
			// 글 북마크 insert
			result = boardDao.bookmarkArticle(bookmarkArticleDto);
			if (result != SUCCESS) {
				result = -1;
			}
		} else if (result == 1) {
			result = FAIL;
		}

		return result;
	}

	@Override
	public int unBookmarkContent(BookmarkArticleDTO bookmarkArticleDto) {
		int result = 0;

		// 북마크 되어있는 글인지 확인
		result = boardDao.checkBookmarkArticleAlready(bookmarkArticleDto);
		if (result == 1) {
			// 글 북마크 delete
			result = boardDao.unBookmarkArticle(bookmarkArticleDto);
			if (result != SUCCESS) {
				result = -1;
			}
		} else if (result == 0) {
			result = FAIL;
		}

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
				result = boardDao.thumbsUpContent(voteArticleDto);
				if (result == SUCCESS) {
					if (boardDao.subtractTwoVotes(voteArticleDto) == 50) {// 추천수가 일정이상이면 BEST등록
						boardDao.goBest(voteArticleDto);
					}
					// insert vote article
					result = boardDao.writeVoteArticle(voteArticleDto);
					// 해당 게시물의 추천수 가져오기
					result = boardDao.getUpvoteNum(voteArticleDto);
				}
			} else if (result == 1) {// 이미 추천이력이 있음
				result = -1;
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
					// 해당 게시물의 비추천수 가져오기
					result = boardDao.getDownvoteNum(voteArticleDto);
				}
			} else if (result == 1) {// 이미 추천이력이 있음
				result = -1;
			}
		}

		return result;
	}

	@Override
	public int reportContent(ReportArticleDTO reportArticleDto) {
		int result = 0;

		// bid check
		if (isBoardIdExists(reportArticleDto.getbId())) {
			// report article에 해당 게시물 신고 이력이 있는지
			result = boardDao.checkReportAlready(reportArticleDto);
			if (result == 0) {
				// insert report article
				result = boardDao.writeReportArticle(reportArticleDto);
				if (result == SUCCESS) {
					// update reportnum
					result = boardDao.increaseReport(reportArticleDto);
				}
			} else {
				result = -1;
			}
		}

		return result;
	}

	@Override
	public int thumbsUpComment(VoteCommentDTO voteCommentDto) {
		int result = 0;
		BoardCommentDTO boardCommentDto = null;

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
				if (boardCommentDao.subtractTwoVotes(voteCommentDto) == 25) {
					boardCommentDto = boardCommentDao.getBoardCommentDTO(voteCommentDto);
					if (boardCommentDao.countBestComments(boardCommentDto) < 3) {
						boardCommentDao.goBest(voteCommentDto);
					}
				}
				// insert vote comment
				result = boardCommentDao.writeVoteComment(voteCommentDto);
				result = boardCommentDao.getUpvoteNum(voteCommentDto);
			} else if (result == 1) { // 이미 추천이력이 있음
				result = -1;
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
				// update downvote
				result = boardCommentDao.thumbsDownComment(voteCommentDto);
				// insert vote comment
				result = boardCommentDao.writeVoteComment(voteCommentDto);
				result = boardCommentDao.getDownvoteNum(voteCommentDto);
			} else if (result == 1) { // 이미 추천이력이 있음
				result = -1;
			}
		}

		return result;
	}

}
