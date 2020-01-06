package com.ce.dao;

import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardCommentDTO> comment(BoardCommentDTO boardCommentDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int writeComment(BoardCommentDTO boardCommentDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int writeCommentInfo(BoardCommentDTO boardCommentDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyComment(BoardCommentDTO boardCommentDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyCommentInfo(BoardCommentDTO boardCommentDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteComment(BoardCommentDTO boardCommentDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCommentInfo(BoardCommentDTO boardCommentDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int replyComment(BoardCommentDTO boardCommentDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int checkVoteCommentAlready(VoteCommentDTO voteCommentDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCommentVoteNum(VoteCommentDTO voteCommentDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int writeVoteCommentInfo(VoteCommentDTO voteCommentDto) {
		// TODO Auto-generated method stub
		return 0;
	}
}
