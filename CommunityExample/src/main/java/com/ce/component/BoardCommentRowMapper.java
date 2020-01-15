package com.ce.component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;

import com.ce.dto.BoardCommentDTO;
import com.ce.dto.BoardCommentInfoDTO;

public class BoardCommentRowMapper implements RowMapper<BoardCommentDTO>{

	@Override
	public BoardCommentDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardCommentDTO boardCommentDto = new BoardCommentDTO();
		BoardCommentInfoDTO boardCommentInfoDto = new BoardCommentInfoDTO();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		boardCommentDto.setBcIdx(rs.getInt("COMMENT_INDEX"));
		boardCommentDto.setbIdx(rs.getInt("BOARD_INDEX"));
		boardCommentDto.setmId(rs.getString("ID"));
		boardCommentDto.setmNickname(rs.getString("NICKNAME"));
		boardCommentDto.setBcContent(rs.getString("COMMENT_CONTENT"));
		boardCommentDto.setBcRegDate(dateFormat.format(rs.getTimestamp("COMMENT_REGDATE")));
		boardCommentDto.setBcGroup(rs.getInt("COMMENT_GROUP"));
		boardCommentDto.setBcStep(rs.getInt("COMMENT_STEP"));
		boardCommentDto.setBcIndent(rs.getInt("COMMENT_INDENT"));
		
		boardCommentInfoDto.setBcIdx(rs.getInt("COMMENT_INDEX"));
		boardCommentInfoDto.setBcUpvote(rs.getInt("COMMENT_UPVOTE"));
		boardCommentInfoDto.setBcDownvote(rs.getInt("COMMENT_DOWNVOTE"));
		boardCommentInfoDto.setBcReportNum(rs.getInt("COMMENT_REPORTNUM"));
		boardCommentInfoDto.setBcBlind(rs.getInt("COMMENT_BLIND"));
		boardCommentInfoDto.setBcNotice(rs.getInt("COMMENT_NOTICE"));
		boardCommentInfoDto.setBcBest(rs.getInt("COMMENT_BEST"));
		
		boardCommentDto.setBoardCommentInfoDto(boardCommentInfoDto);
		
		return boardCommentDto;
	}

}
