package com.ce.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ce.dto.BoardCommentDTO;
import com.ce.dto.BoardDTO;
import com.ce.dto.VoteCommentDTO;

public class BoardCommentDAOImpl implements BoardCommentDAO {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<BoardCommentDTO> commentList(BoardDTO boardDto) {
		String boardId = null;
		String sql = "";
		List<BoardCommentDTO> boardCommentDtoList=null;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return boardCommentDtoList;
	}

	@Override
	public List<BoardCommentDTO> comment(BoardCommentDTO boardCommentDto) {
		String boardId = null;
		String sql = "";
		List<BoardCommentDTO> boardCommentDtoList=null;
		
		try {
		} catch (DataAccessException e) {
		}
		return boardCommentDtoList;
	}

	@Override
	public int writeComment(BoardCommentDTO boardCommentDto) {
		String boardId = null;
		String sql = "";
		int result=0;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return result;
	}

	@Override
	public int writeCommentInfo(BoardCommentDTO boardCommentDto) {
		String boardId = null;
		String sql = "";
		int result=0;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return result;
	}

	@Override
	public int modifyComment(BoardCommentDTO boardCommentDto) {
		String boardId = null;
		String sql = "";
		int result=0;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return result;
	}

	@Override
	public int modifyCommentInfo(BoardCommentDTO boardCommentDto) {
		String boardId = null;
		String sql = "";
		int result=0;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return result;
	}

	@Override
	public int deleteComment(BoardCommentDTO boardCommentDto) {
		String boardId = null;
		String sql = "";
		int result=0;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return result;
	}

	@Override
	public int deleteCommentInfo(BoardCommentDTO boardCommentDto) {
		String boardId = null;
		String sql = "";
		int result=0;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return result;
	}

	@Override
	public int replyComment(BoardCommentDTO boardCommentDto) {
		String boardId = null;
		String sql = "";
		int result=0;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return result;
	}

	@Override
	public int checkVoteCommentAlready(VoteCommentDTO voteCommentDto) {
		String boardId = null;
		String sql = "";
		int result=0;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return result;
	}

	@Override
	public int updateCommentVoteNum(VoteCommentDTO voteCommentDto) {
		String boardId = null;
		String sql = "";
		int result=0;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return result;
	}

	@Override
	public int writeVoteCommentInfo(VoteCommentDTO voteCommentDto) {
		String boardId = null;
		String sql = "";
		int result=0;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return result;
	}
}
