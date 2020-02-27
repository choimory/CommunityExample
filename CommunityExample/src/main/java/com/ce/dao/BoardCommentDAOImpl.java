package com.ce.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ce.component.BoardCommentRowMapper;
import com.ce.dto.BoardCommentDTO;
import com.ce.dto.BoardDTO;
import com.ce.dto.VoteArticleDTO;
import com.ce.dto.VoteCommentDTO;

public class BoardCommentDAOImpl implements BoardCommentDAO {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<BoardCommentDTO> comment(BoardDTO boardDto) {
		String boardType = boardDto.getBoardTypeDto().getbType();
		List<BoardCommentDTO> boardCommentDtoList = null;
		int listFirst=boardDto.getPageHelper().getListFirst();
		int listLast=boardDto.getPageHelper().getListLast();
		String sql = "SELECT * " 
				+ "FROM " + boardType + "_COMMENT " 
				+ "INNER JOIN " + boardType + "_COMMENT_INFO "
				+ "ON " + boardType + "_COMMENT.COMMENT_INDEX = " + boardType + "_COMMENT_INFO.COMMENT_INDEX " 
				+ "WHERE " + boardType + "_COMMENT.BOARD_INDEX=? " 
				+ "ORDER BY " + boardType + "_COMMENT.COMMENT_GROUP ASC, "	+ boardType + "_COMMENT.COMMENT_STEP ASC " 
				+ "LIMIT ?,?;";
		
		try {
			boardCommentDtoList=jdbcTemplate.query(sql, new Object[] {boardDto.getbIdx(),listFirst,listLast}, new BoardCommentRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
			boardCommentDtoList=null;
		}

		return boardCommentDtoList;
	}

	@Override
	public List<BoardCommentDTO> comment(BoardCommentDTO boardCommentDto) {
		String boardType = boardCommentDto.getBoardTypeDto().getbType();
		List<BoardCommentDTO> boardCommentDtoList = null;
		int listFirst=boardCommentDto.getPageHelper().getListFirst();
		int listLast=boardCommentDto.getPageHelper().getListLast();
		String sql = "SELECT * " 
				+ "FROM " + boardType + "_COMMENT " 
				+ "INNER JOIN " + boardType + "_COMMENT_INFO "
				+ "ON " + boardType + "_COMMENT.COMMENT_INDEX = " + boardType + "_COMMENT_INFO.COMMENT_INDEX " 
				+ "WHERE " + boardType + "_COMMENT.BOARD_INDEX=? " 
				+ "ORDER BY "+boardType+"_COMMENT_INFO.COMMENT_NOTICE DESC, "+boardType+"_COMMENT_INFO.COMMENT_BEST DESC, " + boardType + "_COMMENT.COMMENT_GROUP ASC, "	+ boardType + "_COMMENT.COMMENT_STEP ASC, "+boardType+"_COMMENT.COMMENT_REGDATE ASC " 
				+ "LIMIT ?,?";

		try {
			boardCommentDtoList=jdbcTemplate.query(sql, new Object[] {boardCommentDto.getbIdx(),listFirst,listLast}, new BoardCommentRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
			boardCommentDtoList=null;
		}
		
		return boardCommentDtoList;
	}

	@Override
	public int writeComment(BoardCommentDTO boardCommentDto) {
		String boardType = boardCommentDto.getBoardTypeDto().getbType();
		int result = 0;
		String sql = "INSERT " 
				+ "INTO " + boardType+ "_COMMENT (COMMENT_INDEX,BOARD_INDEX,ID,NICKNAME,COMMENT_CONTENT,COMMENT_REGDATE,COMMENT_GROUP,COMMENT_STEP,COMMENT_INDENT)"
				+ "VALUES (0,?,?,?,?,NOW(),?,?,?)";

		try {
			result=jdbcTemplate.update(sql, new Object[] {boardCommentDto.getbIdx(),boardCommentDto.getmId(),boardCommentDto.getmNickname(),boardCommentDto.getBcContent(),boardCommentDto.getBcGroup(),boardCommentDto.getBcStep(),boardCommentDto.getBcIndent()});
		} catch (DataAccessException e) {
			e.printStackTrace();
			result=-1;
		}

		return result;
	}

	@Override
	public int getLatestIndex(BoardCommentDTO boardCommentDto) {
		int result=0;
		String boardType=boardCommentDto.getBoardTypeDto().getbType();
		String sql="SELECT MAX(COMMENT_INDEX)"
				+ "FROM "+boardType+"_COMMENT "
				+ "WHERE ID=? AND NICKNAME=? AND COMMENT_CONTENT=?";
		
		try {
			result=jdbcTemplate.queryForObject(sql, new Object[] {boardCommentDto.getmId(), boardCommentDto.getmNickname(),boardCommentDto.getBcContent()}, Integer.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			result=-1;
		}
		
		return result;
	}

	@Override
	public int writeCommentInfo(BoardCommentDTO boardCommentDto) {
		String boardType = boardCommentDto.getBoardTypeDto().getbType();
		int result = 0;
		String sql = "INSERT " 
				+ "INTO " + boardType+ "_COMMENT_INFO (COMMENT_INDEX,COMMENT_UPVOTE,COMMENT_DOWNVOTE,COMMENT_REPORTNUM,COMMENT_BLIND,COMMENT_NOTICE,COMMENT_BEST) "
				+ "VALUES (?,0,0,0,0,?,0)";

		try {
			result=jdbcTemplate.update(sql, new Object[] {boardCommentDto.getBcIdx(),boardCommentDto.getBoardCommentInfoDto().getBcNotice()});
		} catch (DataAccessException e) {
			e.printStackTrace();
			result=-1;
		}

		return result;
	}

	@Override
	public int modifyComment(BoardCommentDTO boardCommentDto) {
		String boardType = boardCommentDto.getBoardTypeDto().getbType();
		int result = 0;
		String sql = "UPDATE " + boardType + "_COMMENT" 
				+ "SET COMMENT_CONTENT=?, COMMENT_REGDATE=NOW()"
				+ "WHERE COMMENT_INDEX=?";

		try {
			result=jdbcTemplate.update(sql, new Object[] {boardCommentDto.getBcContent(),boardCommentDto.getBcIdx()});
		} catch (DataAccessException e) {
			e.printStackTrace();
			result=-1;
		}

		return result;
	}

	@Override
	public int deleteComment(BoardCommentDTO boardCommentDto) {
		String boardType = boardCommentDto.getBoardTypeDto().getbType();
		int bcIdx = boardCommentDto.getBcIdx();
		int result = 0;
		String sql = "DELETE " 
				+ "FROM " + boardType + "_COMMENT " 
				+ "WHERE COMMENT_INDEX=?";

		try {
			result=jdbcTemplate.update(sql,new Object[] {bcIdx});
		} catch (DataAccessException e) {
			e.printStackTrace();
			result=-1;
		}

		return result;
	}

	@Override
	public int checkVoteCommentAlready(VoteCommentDTO voteCommentDto) {
		int result = 0;
		String sql = "SELECT COUNT(*) " 
				+ "FROM VOTE_COMMENT " 
				+ "WHERE ID=? AND BOARD_ID=? AND COMMENT_INDEX=?";

		try {
			result=jdbcTemplate.queryForObject(sql, new Object[] {voteCommentDto.getmId(),voteCommentDto.getbId(),voteCommentDto.getBcIdx()}, Integer.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			result=-1;
		}

		return result;
	}

	@Override
	public int thumbsUpComment(VoteCommentDTO voteCommentDto) {
		String boardType = voteCommentDto.getbType();
		int result = 0;
		String sql = "UPDATE " + boardType + "_COMMENT_INFO " 
				+ "SET COMMENT_UPVOTE=COMMENT_UPVOTE+1 " 
				+ "WHERE COMMENT_INDEX=?";

		try {
			result=jdbcTemplate.update(sql, new Object[] {voteCommentDto.getBcIdx()});
		} catch (DataAccessException e) {
			e.printStackTrace();
			result=-1;
		}

		return result;
	}

	@Override
	public int thumbsDownComment(VoteCommentDTO voteCommentDto) {
		String boardType = voteCommentDto.getbType();
		int result = 0;
		String sql = "UPDATE " + boardType + "_COMMENT_INFO " 
				+ "SET COMMENT_DOWNVOTE=COMMENT_DOWNVOTE+1 " 
				+ "WHERE COMMENT_INDEX=?";

		try {
			result=jdbcTemplate.update(sql, new Object[] {voteCommentDto.getBcIdx()});
		} catch (DataAccessException e) {
			e.printStackTrace();
			result=-1;
		}

		return result;
	}

	@Override
	public int writeVoteComment(VoteCommentDTO voteCommentDto) {
		int result = 0;
		String sql = "INSERT " 
				+ "INTO VOTE_COMMENT (ID,BOARD_TYPE,BOARD_ID,COMMENT_INDEX,UPDOWN) "
				+ "VALUES (?,?,?,?,?)";

		try {
			result=jdbcTemplate.update(sql, new Object[] {voteCommentDto.getmId(),voteCommentDto.getbType(),voteCommentDto.getbId(),voteCommentDto.getBcIdx(),voteCommentDto.getvUpDown()});
		} catch (DataAccessException e) {
			e.printStackTrace();
			result=-1;
		}

		return result;
	}

	@Override
	public int getTotalRow(BoardCommentDTO boardCommentDto) {
		String boardType = boardCommentDto.getBoardTypeDto().getbType();
		int result = 0;
		String sql = "SELECT COUNT(*) " 
				+ "FROM " + boardType + "_COMMENT "
				+ "WHERE BOARD_INDEX=?";

		try {
			result=jdbcTemplate.queryForObject(sql, new Object[] {boardCommentDto.getbIdx()},Integer.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			result=-1;
		}

		return result;
	}
	public int getTotalRow(BoardDTO boardDto) {
		String boardType = boardDto.getBoardTypeDto().getbType();
		int result = 0;
		String sql = "SELECT COUNT(*) " 
				+ "FROM " + boardType + "_COMMENT "
				+ "WHERE BOARD_INDEX=?";

		try {
			result=jdbcTemplate.queryForObject(sql, new Object[] {boardDto.getbIdx()},Integer.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			result=-1;
		}

		return result;
	}

	@Override
	public int commentGrouping(BoardCommentDTO boardCommentDto) {
		String boardType=boardCommentDto.getBoardTypeDto().getbType();
		int result = 0;
		String sql = "UPDATE "+boardType+"_COMMENT "
				+ "SET COMMENT_GROUP=COMMENT_INDEX "
				+ "WHERE COMMENT_INDEX=?";

		try {
			result=jdbcTemplate.update(sql, new Object[] {boardCommentDto.getBcIdx()});
		} catch (DataAccessException e) {
			e.printStackTrace();
			result=-1;
		}

		return result;
	}

	@Override
	public int goBest(VoteCommentDTO voteCommentDto) {
		String boardType=voteCommentDto.getbType();
		int result=0;
		String sql="UPDATE "+boardType+"_COMMENT_INFO "
				+ "SET COMMENT_BEST=1 "
				+ "WHERE COMMENT_INDEX=?";
		
		try {
			result=jdbcTemplate.update(sql,new Object[] {voteCommentDto.getBcIdx()});
		} catch (DataAccessException e) {
			e.printStackTrace();
			result=-1;
		}
		return result;
	}

	@Override
	public int subtractTwoVotes(VoteCommentDTO voteCommentDto) {
	int result=0;
	String boardType=voteCommentDto.getbType();
	String sql="SELECT COMMENT_UPVOTE-COMMENT_DOWNVOTE "
			+ "FROM "+boardType+"_COMMENT_INFO "
			+ "WHERE COMMENT_INDEX=?";
	
	try {
		result=jdbcTemplate.queryForObject(sql, new Object[] {voteCommentDto.getBcIdx()},Integer.class);
	} catch (DataAccessException e) {
		e.printStackTrace();
		result=-1;
	}
	
	
	return result;
	}

	@Override
	public int countBestComments(BoardCommentDTO boardCommentDto) {
		int result=0;
		String boardType=boardCommentDto.getBoardTypeDto().getbType();
		String sql="SELECT COUNT(*) FROM "+boardType+"_COMMENT "
				+ "INNER JOIN "+boardType+"_COMMENT_INFO "
				+ "ON "+boardType+"_COMMENT.COMMENT_INDEX="+boardType+"_COMMENT_INFO.COMMENT_INDEX "
				+ "WHERE "+boardType+"_COMMENT.BOARD_INDEX=? AND "+boardType+"_COMMENT_INFO.COMMENT_BEST=1";  
		
		try {
			result=jdbcTemplate.queryForObject(sql, new Object[] {boardCommentDto.getbIdx()}, Integer.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			result=-1;
		}
		
		return result;
	}
public BoardCommentDTO getBoardCommentDTO(VoteCommentDTO voteCommentDto) {
	BoardCommentDTO boardCommentDto=null;
	String boardType=voteCommentDto.getbType();
	String sql="SELECT * FROM "+boardType+"_COMMENT "
			+ "INNER JOIN "+boardType+"_COMMENT_INFO "
			+ "ON "+boardType+"_COMMENT.COMMENT_INDEX="+boardType+"_COMMENT_INFO.COMMENT_INDEX "
			+ "WHERE "+boardType+"_COMMENT.COMMENT_INDEX=?";
	
	try {
		boardCommentDto=jdbcTemplate.queryForObject(sql, new Object[] {voteCommentDto.getBcIdx()}, new BoardCommentRowMapper());
	} catch (DataAccessException e) {
		e.printStackTrace();
		boardCommentDto=null;
	}
	
	return boardCommentDto;
}

@Override
public int getUpvoteNum(VoteCommentDTO voteCommentDto) {
	int result=0;
	String boardType=voteCommentDto.getbType();
	String sql="SELECT COMMENT_UPVOTE "
			+ "FROM "+boardType+"_COMMENT_INFO "
			+ "WHERE COMMENT_INDEX=?";
	
	try {
		result=jdbcTemplate.queryForObject(sql, new Object[] {voteCommentDto.getBcIdx()},Integer.class);
	} catch (DataAccessException e) {
		e.printStackTrace();
		result=-1;
	}
	
	return result;
}

@Override
public int getDownvoteNum(VoteCommentDTO voteCommentDto) {
	int result=0;
	String boardType=voteCommentDto.getbType();
	String sql="SELECT COMMENT_DOWNVOTE "
			+ "FROM "+boardType+"_COMMENT_INFO "
			+ "WHERE COMMENT_INDEX=?";
	
	try {
		result=jdbcTemplate.queryForObject(sql, new Object[] {voteCommentDto.getBcIdx()},Integer.class);
	} catch (DataAccessException e) {
		e.printStackTrace();
		result=-1;
	}
	
	return result;
}

}
