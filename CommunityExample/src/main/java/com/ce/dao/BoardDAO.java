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
//	DynamicSQL을 쓸것이냐(모든 파라미터가 map으로 바뀌던가 DTO에 bType들어가야함) -> 1안
//	BoardDAO에 테이블별 DAO메소드을 쓸것이냐(메소드가 많아짐, 유지보수 떨어짐) -> 3안
//	DAO를 테이블별 DAO로 나누어 DAOImpl의 해당 메소드들만 오버라이드한뒤 if문으로 해당DAO메소드를 호출할것이냐(DAO클래스가 많아짐, 서비스에 DAO멤버변수가 많아짐, 장문의 if문 때문에 코드가 지저분해짐) -> 2안
	
	
	public List<BoardDTO> reportList(); // report n개 이상인글 최신순 다섯개정도 가져오기 TODO 모든게시판에서 가져와야 하는 문제
	public List<BoardDTO> reportList(PageHelper pageHelper);//blind가 false인 글들중 report개수가 n개 이상인 글들을 page를 이용해 최신순 20개 select //TODO 모든게시판을 탐색해야 하는 문제->union
	public List<BoardDTO> reportList(Map<String,Object> paramMap); // pagehelper와 minimumReportNum을 이용해 기준 신고수를 유동적으로 조절
	public int createBoard(BoardTypeDTO boardTypeDto);
	public int blind(BoardDTO boardDto);//해당 테이블의 bIdx글의 blind를 기존과 다르게 변경 
	public BoardTypeDTO getBoardType(BoardTypeDTO boardTypeDto);//bId로 bType 탐색하여 어느테이블을 가야할지를 탐색
	public BoardTypeDTO getBoardType(BoardDTO boardDto);//bId로 bType 탐색하여 어느테이블을 가야할지를 탐색
	public BoardTypeDTO getBoardType(BoardCommentDTO boardCommentDto); //
	public BoardTypeDTO getBoardType(String bId);//bId로 bType 탐색하여 어느테이블을 가야할지를 탐색
	public String getbType(String bId);//
	public Map<String,List<BoardDTO>> main(); // BEST게시판 9글, 나머지게시판 5글씩 최신순으로 가져오기
	public List<BoardDTO> list(BoardDTO boardDto); //
	public List<String> getBoardIdList(); // select bId from BoardType
	public BoardDTO content(BoardDTO boardDto); //select all from btypeBoard join btypeBoardinfo where bIdx 
	public List<BoardCommentDTO> commentList(BoardDTO boardDto); // select all from BoardTypeComment where bIdx
	public int write(BoardDTO boardDto); // insert
	public int writeInfo(BoardDTO boardDto); //insert
	public int bookmarkBoard(BookmarkBoardDTO bookmarkBoardDto); // insert
	public BoardTypeDTO getBoardCategorys(BoardDTO boardDto); // select bCategory where bId
	public int modifyBoard(BoardDTO boardDto);//update board
	public int modifyBoardInfo(BoardDTO boardDto); // update board info
	public int modifyBoardFile(BoardDTO boardDto);//update boardfile
	public int deleteBoard(BoardDTO boardDto);//delete board
	public int deleteBoardInfo(BoardDTO boardDto);//delete boardinfo
	public int deleteBoardFile(BoardDTO boardDto);//delete boardfile
	public List<BoardDTO> search(BoardDTO boardDto);//select all from btypeboard where query target and page
	public List<BoardCommentDTO> comment(BoardCommentDTO boardCommentDto); //select all from bcomment where page
	public int writeComment(BoardCommentDTO boardCommentDto); //insert comment
	public int writeCommentInfo(BoardCommentDTO boardCommentDto); // insert comment info
	public int modifyComment(BoardCommentDTO boardCommentDto); //update comment
	public int modifyCommentInfo(BoardCommentDTO boardCommentDto); // update comment info
	public int deleteComment(BoardCommentDTO boardCommentDto); // delete comment where bcidx
	public int deleteCommentInfo(BoardCommentDTO boardCommentDto); // delete comment info where bcidx
	public int replyComment(BoardCommentDTO boardCommentDto); // insert comment
	public int bookmarkArticle(BookmarkArticleDTO bookmarkArticleDto);//insert
	public int checkVoteArticleAlready(VoteArticleDTO voteArticleDto); // count where mId, bId, bIdx
	public int updateVoteNum(VoteArticleDTO voteArticleDto); //update vote(+1 or -1) where bIdx
	public int writeVoteInfo(VoteArticleDTO voteArticleDto);//insert
	public int checkReportAlready(BoardDTO boardDto); //count where mId, bId, bIdx
	public int updateReportNum(BoardDTO boardDto); // update reportnum +_1
	public int writeReportArticle(BoardDTO boardDto);//insert
	public int checkVoteCommentAlready(VoteCommentDTO voteCommentDto);//count where mId, bId, bcIdx
	public int updateCommentVoteNum(VoteCommentDTO voteCommentDto); // update vote +_1 where bcIdx
	public int writeVoteCommentInfo(VoteCommentDTO voteCommentDto); //insert
	
	
	
}
