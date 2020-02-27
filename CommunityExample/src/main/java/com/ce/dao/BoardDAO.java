package com.ce.dao;

import java.util.List;
import java.util.Map;

import com.ce.component.PageHelper;
import com.ce.dto.BoardCategoryDTO;
import com.ce.dto.BoardCommentDTO;
import com.ce.dto.BoardDTO;
import com.ce.dto.BoardFileDTO;
import com.ce.dto.BoardTypeDTO;
import com.ce.dto.BookmarkArticleDTO;
import com.ce.dto.BookmarkBoardDTO;
import com.ce.dto.ReportArticleDTO;
import com.ce.dto.VoteArticleDTO;
import com.ce.dto.VoteCommentDTO;

public interface BoardDAO {
	
	public int getTotalRowReportList();
	public List<BoardDTO> reportList(PageHelper pageHelper);//blind가 false인 글들중 report개수가 n개 이상인 글들을 page를 이용해 최신순 20개 select //TODO 모든게시판을 탐색해야 하는 문제->union
	public int createBoard(BoardTypeDTO boardTypeDto);
	public int blind(BoardDTO boardDto);
	public BoardTypeDTO getBoardType(BoardTypeDTO boardTypeDto);
	public BoardTypeDTO getBoardType(BoardDTO boardDto);
	public BoardTypeDTO getBoardType(String bId);
	public String changeBoardTypeKorToEng(String boardTypeKor);
	public String getbType(String bId);//
	public List<String> getBoardTypeList(); 
	public List<String> getBoardTypeListKor();
	public List<String> getBoardIdList();
	public List<BoardDTO> list(BoardDTO boardDto); 
	public BoardDTO content(BoardDTO boardDto); 
	public List<BoardFileDTO> contentFile(BoardDTO boardDto);
	public int increaseHit(BoardDTO boardDto);
	public int write(BoardDTO boardDto); 
	public int getLatestIndex(BoardDTO boardDto);
	public int writeInfo(BoardDTO boardDto);
	public int bookmarkBoard(BookmarkBoardDTO bookmarkBoardDto);
	public int unBookmarkBoard(BookmarkBoardDTO bookmarkBoardDto);
	public List<String> getBoardCategory(String bId);
	public int modify(BoardDTO boardDto);
	public int modifyFile(BoardDTO boardDto);
	public int delete(BoardDTO boardDto);
	public int deleteFile(BoardDTO boardDto);	
	public int bookmarkArticle(BookmarkArticleDTO bookmarkArticleDto);
	public int unBookmarkArticle(BookmarkArticleDTO bookmarkArticleDto);
	public int checkVoteArticleAlready(VoteArticleDTO voteArticleDto);
	public int thumbsUpContent(VoteArticleDTO voteArticleDto);
	public int thumbsDownContent(VoteArticleDTO voteArticleDto);
	public int writeVoteArticle(VoteArticleDTO voteArticleDto);
	public int checkReportAlready(ReportArticleDTO reportArticleDto);
	public int increaseReport(ReportArticleDTO reportArticleDto);
	public int writeReportArticle(ReportArticleDTO reportArticleDto);
	public int getTotalRow(BoardDTO boardDto);
	public int getBestTotalRow(List<String> boardTypeList);
	public int goBest(VoteArticleDTO voteArticleDto);
	public List<String> getBoardIdKorList();
	public String changeBoardIdKorToEng(String bIdKor);
	public int addCategory(BoardCategoryDTO boardCategoryDto);
	public int insertBoardFile(BoardFileDTO boardFileDto);
	public int increaseCommentNum(BoardCommentDTO boardCommentDto);
	public int getUpvoteNum(VoteArticleDTO voteArticleDto);
	public int subtractTwoVotes(VoteArticleDTO voteArticleDto);
	public int getDownvoteNum(VoteArticleDTO voteArticleDto);
	public int checkBookmarkArticleAlready(BookmarkArticleDTO bookmarkArticleDto);	
	public int isBookmarkedBoard(BookmarkBoardDTO bookmarkBoardDto);
	public int isBookmarkedArticle(BookmarkArticleDTO bookmarkArticleDto);
	public List<BoardDTO> best(PageHelper pageHelper);	
	public List<String> getBoardIdListByType(String bType);
	public List<BoardDTO> bestMain();
	public List<BoardDTO> otherMain(BoardDTO boardDto);
	public String getStoredFileName(BoardFileDTO boardFileDto);
}
