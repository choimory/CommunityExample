package com.ce.component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;

import com.ce.dto.BoardDTO;
import com.ce.dto.BoardInfoDTO;

public class BoardRowMapper implements RowMapper<BoardDTO>{

	@Override
	public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardDTO boardDto = new BoardDTO();
		BoardInfoDTO boardInfoDto = new BoardInfoDTO();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		boardDto.setbIdx(rs.getInt("BOARD_INDEX"));
		boardDto.setbId(rs.getString("BOARD_ID"));
		boardDto.setbCategory(rs.getString("BOARD_CATEGORY"));
		boardDto.setbTitle(rs.getString("BOARD_TITLE"));
		boardDto.setbContent(rs.getString("BOARD_CONTENT"));
		boardDto.setmId(rs.getString("ID"));
		boardDto.setmNickname(rs.getString("NICKNAME"));
		boardDto.setbRegDate(dateFormat.format(rs.getTimestamp("BOARD_REGDATE")));
		
		boardInfoDto.setbIdx(rs.getInt("BOARD_INDEX"));
		boardInfoDto.setbHit(rs.getInt("BOARD_HIT"));
		boardInfoDto.setbUpvote(rs.getInt("BOARD_UPVOTE"));
		boardInfoDto.setbDownvote(rs.getInt("BOARD_DOWNVOTE"));
		boardInfoDto.setbCommentNum(rs.getInt("BOARD_COMMENTNUM"));
		boardInfoDto.setbReportNum(rs.getInt("BOARD_REPORTNUM"));
		boardInfoDto.setbBlind(rs.getInt("BOARD_BLIND"));
		boardInfoDto.setbNotice(rs.getInt("BOARD_NOTICE"));
		boardInfoDto.setbBest(rs.getInt("BOARD_BEST"));
		
		boardDto.setBoardInfoDto(boardInfoDto);
		
		return boardDto;
	}

}
