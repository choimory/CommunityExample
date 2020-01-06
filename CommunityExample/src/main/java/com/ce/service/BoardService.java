package com.ce.service;

import java.util.List;
import java.util.Map;

import com.ce.component.PageHelper;
import com.ce.component.SearchHelper;
import com.ce.dto.BoardCommentDTO;
import com.ce.dto.BoardDTO;
import com.ce.dto.BoardInfoDTO;
import com.ce.dto.BoardTypeDTO;
import com.ce.dto.BookmarkBoardDTO;
import com.ce.dto.BookmarkArticleDTO;
import com.ce.dto.VoteCommentDTO;
import com.ce.dto.VoteArticleDTO;

public interface BoardService {
	 public Map<String,Object> list(String bId, PageHelper pageHelper);
	//1. BOARD_TYPE테이블에서 게시판명들 다 가져온다음 bid와 foreach로 대조해보고 일치하는게 있을시 boardExist는 true 아니면 false 
	//2. bid와 page를 이용해 해당 테이블의 글들 select
	
	  public Map<String,Object> content(String bId, String stringBoardIdx); 
	//1. BOARD_TYPE테이블에서 게시판명들 다 가져온다음 bid와 foreach로 대조해보고 일치하는게 있을시 boardExist는 true 아니면 false 
	//2. bid와 page를 이용해 해당 테이블의 글들 select
	
	  public BoardDTO write(BoardDTO boardDto); //bid를 이용해 알맞은 테이블 검색 후 해당 테이블에 insert
	  public BoardDTO modifyForm(BoardDTO boardDto); //input value를 채우기 위해 bid를 이용해 알맞은 테이블 검색 후 bidx의 해당 글을 가져오기
	  public BoardDTO modify(BoardDTO boardDto, BoardInfoDTO boardInfoDto); //bid를 이용해 알맞은 테이블 검색 후 bidx의 해당row 컬럼값 변경
	  public int delete(BoardDTO boardDto); //bid를 이용해 알맞은 테이블 검색 후 bidx의 해당 row 삭제 
	  public List<BoardDTO> search(BoardDTO boardDto, SearchHelper searchHelper, PageHelper pageHelper);//bid를 이용해 알맞은 테이블 검색 후 query와 target과 page를 이용해 select 
	  public List<BoardCommentDTO> comment(BoardCommentDTO boardCommentDto, BoardTypeDTO boardTypeDto, PageHelper pageHelper); //bid를 이용해 알맞은 테이블 검색 후 bidx와 page를 이용해 해당글의 댓글 가져오기
	  public int writeComment(BoardCommentDTO boardCommentDto, BoardTypeDTO boardTypeDto); //bid를 이용해 알맞은 테이블 검색 후  row insert
	  public int modifyComment(BoardCommentDTO boardCommentDto, BoardTypeDTO boardTypeDto); //bid를 이용해 알맞은 테이블 검색 후 해당 row 수정 , 수정된 댓글은 [댓글수정일자 : yyyy-mm-dd]가 꼬릿말로 붙도록 할것
	  public int deleteComment(BoardCommentDTO boardCommentDto,BoardTypeDTO boardTypeDto); //bid를 이용해 알맞은 테이블 검색 후 해당 row 수정 혹은 삭제, 수정으로 할거면 댓글내용을 [~~에 의해 삭제된 댓글입니다]로 내용을 변경
	  public int replyComment(BoardCommentDTO boardCommentDto,BoardTypeDTO boardTypeDto); //bid를 이용해 알맞은 테이블 검색후 bcidx와 연계한 답글row insert
	  
	  public int bookmarkBoard(BookmarkBoardDTO bookmarkBoardDto); //mid와 bid를 이용해 테이블에 북마크값이 있을시엔 로우 삭제, 없을시엔 로우 추가
	  public int bookmarkContent(BookmarkArticleDTO bookmarkArticleDto); //mid와 bid와 bidx를 이용해 테이블에 북마크값이 있을시엔 로우 삭제, 없을시엔 로우 추가
	  public int thumbsUpContent(VoteArticleDTO voteArticleDto); //mid와 bid와  bidx를 이용해 테이블에 추천값이 있을시엔 로우 삭제, 없을시엔 추가
	  public int thumbsDownContent(VoteArticleDTO voteArticleDto); //mid와 bid와 bidx를 이용해 테이블에 추천값이 있을시엔 로우 삭제, 없을시엔 추가
	  public int reportContent(BoardDTO boardDto); //mid와 bid와 bidx를 이용해 리포트 컬럼값을 번경
	  public int thumbsUpComment(VoteCommentDTO voteCommentDto); //mid와 bid와 bcidx를 이용해 테이블에 로우가 있을시엔 삭제, 없을시엔 추가
	  public int thumbsDownComment(VoteCommentDTO voteCommentDto); //mid와 bid와 bcidx를 이용해 테이블에 로우가 있을시엔 삭제, 없을시엔 추가
}
