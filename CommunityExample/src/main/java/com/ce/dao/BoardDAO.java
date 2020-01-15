package com.ce.dao;

import java.util.List;
import java.util.Map;

import com.ce.component.PageHelper;
import com.ce.dto.BoardCommentDTO;
import com.ce.dto.BoardDTO;
import com.ce.dto.BoardTypeDTO;
import com.ce.dto.BookmarkArticleDTO;
import com.ce.dto.BookmarkBoardDTO;
import com.ce.dto.ReportArticleDTO;
import com.ce.dto.VoteArticleDTO;
import com.ce.dto.VoteCommentDTO;

public interface BoardDAO {
	
//	TODO
//	게시판타입후 해당타입의 테이블을 분류하여 찾아들어가는 문제 해결해야함. 
//  jdbcTemplate를 사용해 클래스에서 동적으로 query를 날릴것인가 -> 1안
//	mybatis를 사용해 DynamicSQL로 query를 날릴것인가(모든 파라미터가 map으로 바뀌던가 DTO에 bType들어가야함) -> 2안
//	DAO를 테이블별 DAO로 나누어 DAOImpl의 해당 메소드들만 오버라이드한뒤 if문으로 해당DAO메소드를 호출할것이냐(DAO클래스가 많아짐, 서비스에 DAO멤버변수가 많아짐, 장문의 if문 때문에 코드가 지저분해짐) -> 3안
//	BoardDAO에 테이블별 DAO메소드을 쓸것이냐(메소드가 많아짐, 유지보수 떨어짐) -> 4안
	
	
	public List<BoardDTO> reportList(PageHelper pageHelper);//blind가 false인 글들중 report개수가 n개 이상인 글들을 page를 이용해 최신순 20개 select //TODO 모든게시판을 탐색해야 하는 문제->union
	public int createBoard(BoardTypeDTO boardTypeDto);
	public int blind(BoardDTO boardDto);//해당 테이블의 bIdx글의 blind를 기존과 다르게 변경 
	public BoardTypeDTO getBoardType(BoardTypeDTO boardTypeDto);//bId로 bType 탐색하여 어느테이블을 가야할지를 탐색
	public BoardTypeDTO getBoardType(BoardDTO boardDto);//bId로 bType 탐색하여 어느테이블을 가야할지를 탐색
	public BoardTypeDTO getBoardType(String bId);//bId로 bType 탐색하여 어느테이블을 가야할지를 탐색
	public String getbType(String bId);//
	public List<String> getBoardTypeList(); // SELECT distinct btype from boardType
	public Map<String, List<String>> getBoardIdListByType(List<String> boardTypeList);
	public Map<String,List<BoardDTO>> main(Map<String,Object> paramMap); // BEST게시판 9글, 나머지게시판 5글씩 최신순으로 가져오기
	public List<BoardDTO> bestMain(List<String> boardTypeList);
	public Map<String, List<BoardDTO>> otherMain(Map<String,List<String>> paramMap);
	public List<List<BoardDTO>> humorMain(List<String> boardIdList);
	public List<List<BoardDTO>> sportsMain(List<String> boardIdList);
	public List<List<BoardDTO>> gameMain(List<String> boardIdList);
	public List<List<BoardDTO>> entertainmentMain(List<String> boardIdList);
	public List<String> getBoardIdList(); // select bId from BoardType
	public List<BoardDTO> list(BoardDTO boardDto); //	
	public BoardDTO content(BoardDTO boardDto); //select all from btypeBoard join btypeBoardinfo where bIdx 
	public int increaseHit(BoardDTO boardDto); //update board_hit
	public int write(BoardDTO boardDto); // insert
	public int writeInfo(BoardDTO boardDto); //insert
	public int bookmarkBoard(BookmarkBoardDTO bookmarkBoardDto); // insert
	public int unBookmarkBoard(BookmarkBoardDTO bookmarkBoardDto); // delete
	public List<String> getBoardCategories(BoardDTO boardDto); // select bCategory where bId
	public int modify(BoardDTO boardDto);//update board
	public int modifyFile(BoardDTO boardDto);//update boardfile
	public int delete(BoardDTO boardDto);//delete board
	public int deleteFile(BoardDTO boardDto);//delete boardfile
	public List<BoardDTO> search(BoardDTO boardDto);//select all from btypeboard where query target and page
	
	public int bookmarkArticle(BookmarkArticleDTO bookmarkArticleDto);//insert
	public int unBookmarkArticle(BookmarkArticleDTO bookmarkArticleDto);//delete
	public int checkVoteArticleAlready(VoteArticleDTO voteArticleDto); // count where mId, bId, bIdx
	public int thumbsUpContent(VoteArticleDTO voteArticleDto); //update vote(+1 or -1) where bIdx
	public int thumbsDownContent(VoteArticleDTO voteArticleDto); //update vote(+1 or -1) where bIdx
	public int writeVoteArticle(VoteArticleDTO voteArticleDto);//insert
	public int checkReportAlready(BoardDTO boardDto); //count where mId, bId, bIdx
	public int increaseReport(BoardDTO boardDto); // update reportnum +_1
	public int writeReportArticle(BoardDTO boardDto);//insert
	
	public int getTotalRow(BoardDTO boardDto); // select count(*) from [btypeboard] where bid
	public int goBest(VoteArticleDTO voteArticleDto); // update set board_best=1 where bidx
}
