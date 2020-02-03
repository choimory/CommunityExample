package com.ce.service;

import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.ce.component.PageHelper;
import com.ce.component.SearchHelper;
import com.ce.dto.BoardCommentDTO;
import com.ce.dto.BoardCommentInfoDTO;
import com.ce.dto.BoardDTO;
import com.ce.dto.BoardInfoDTO;
import com.ce.dto.BoardTypeDTO;
import com.ce.dto.BookmarkBoardDTO;
import com.ce.dto.MemberDTO;
import com.ce.dto.ReportArticleDTO;
import com.ce.dto.BookmarkArticleDTO;
import com.ce.dto.VoteCommentDTO;
import com.ce.dto.VoteArticleDTO;

public interface BoardService {
	public Map<String,Object> best(PageHelper pageHelper, SearchHelper searchHelper, MemberDTO memberDto);
	public Map<String,Object> bestContent(String bId, String stringIdx, PageHelper pageHelper, SearchHelper searchHelper, MemberDTO memberDto);
	  public Map<String,Object> list(String bId, PageHelper pageHelper, SearchHelper searchHelper,MemberDTO memberDto);	
	  public Map<String,Object> content(String bId, String stringBoardIdx, PageHelper pageHelper, SearchHelper searchHelper,MemberDTO memberDto); 	
	  public Map<String,Object> writeForm(String bId);
	  public BoardDTO write(BoardDTO boardDto, BoardInfoDTO boardInfoDto, List<MultipartFile> files); 
	  public FileInputStream download(String bId, String stringBoardIdx,String stringFileIdx);
	  public Map<String,Object> modifyForm(BoardDTO boardDto); 
	  public BoardDTO modify(BoardDTO boardDto, BoardInfoDTO boardInfoDto); 
	  public int delete(BoardDTO boardDto);   
	  public Map<String,Object> comment(String bId, int bIdx, PageHelper pageHelper);
	  public int writeComment(BoardTypeDTO boardTypeDto, BoardCommentDTO boardCommentDto,BoardCommentInfoDTO boardCommentInfoDto); 
	  public int modifyComment(BoardCommentDTO boardCommentDto, BoardTypeDTO boardTypeDto);
	  public int deleteComment(BoardCommentDTO boardCommentDto,BoardTypeDTO boardTypeDto);
	  public int replyComment(BoardCommentDTO boardCommentDto,BoardTypeDTO boardTypeDto);
	  public Map<String,Object> bookmarkBoard(BookmarkBoardDTO bookmarkBoardDto); 
	  public Map<String,Object> unBookmarkBoard(BookmarkBoardDTO bookmarkBoardDto);
	  public int bookmarkContent(BookmarkArticleDTO bookmarkArticleDto); 
	  public int thumbsUpContent(VoteArticleDTO voteArticleDto); 
	  public int thumbsDownContent(VoteArticleDTO voteArticleDto); 
	  public int reportContent(ReportArticleDTO reportArticleDto); 
	  public int thumbsUpComment(VoteCommentDTO voteCommentDto); 
	  public int thumbsDownComment(VoteCommentDTO voteCommentDto); 
	  public int unBookmarkContent(BookmarkArticleDTO bookmarkArticleDto); 
}
