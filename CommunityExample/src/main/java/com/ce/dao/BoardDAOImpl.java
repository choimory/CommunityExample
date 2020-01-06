package com.ce.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ce.component.PageHelper;
import com.ce.dto.BoardCommentDTO;
import com.ce.dto.BoardDTO;
import com.ce.dto.BoardTypeDTO;
import com.ce.dto.BookmarkArticleDTO;
import com.ce.dto.BookmarkBoardDTO;
import com.ce.dto.VoteArticleDTO;

public class BoardDAOImpl implements BoardDAO {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<BoardDTO> reportList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardDTO> reportList(PageHelper pageHelper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardDTO> reportList(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createBoard(BoardTypeDTO boardTypeDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int blind(BoardDTO boardDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardTypeDTO getBoardType(BoardTypeDTO boardTypeDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardTypeDTO getBoardType(BoardDTO boardDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardTypeDTO getBoardType(BoardCommentDTO boardCommentDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardTypeDTO getBoardType(String bId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getbType(String bId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<BoardDTO>> main() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardDTO> list(BoardDTO boardDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getBoardIdList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardDTO content(BoardDTO boardDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int write(BoardDTO boardDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int writeInfo(BoardDTO boardDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int bookmarkBoard(BookmarkBoardDTO bookmarkBoardDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardTypeDTO getBoardCategories(BoardDTO boardDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modifyBoard(BoardDTO boardDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyBoardInfo(BoardDTO boardDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyBoardFile(BoardDTO boardDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(BoardDTO boardDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoardInfo(BoardDTO boardDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoardFile(BoardDTO boardDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardDTO> search(BoardDTO boardDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int bookmarkArticle(BookmarkArticleDTO bookmarkArticleDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int checkVoteArticleAlready(VoteArticleDTO voteArticleDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateVoteNum(VoteArticleDTO voteArticleDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int writeVoteInfo(VoteArticleDTO voteArticleDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int checkReportAlready(BoardDTO boardDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateReportNum(BoardDTO boardDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int writeReportArticle(BoardDTO boardDto) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
