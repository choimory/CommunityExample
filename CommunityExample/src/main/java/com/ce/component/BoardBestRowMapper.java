package com.ce.component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;

import com.ce.dto.BoardDTO;
import com.ce.dto.BoardInfoDTO;
import com.ce.dto.BoardTypeDTO;

public class BoardBestRowMapper implements RowMapper<BoardDTO>{

	@Override
	public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardDTO bdto=new BoardDTO();
		BoardInfoDTO bidto=new BoardInfoDTO();
		BoardTypeDTO btdto=new BoardTypeDTO();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		bdto.setbIdx(rs.getInt("BOARD_INDEX"));
		bdto.setbId(rs.getString("BOARD_ID"));
		bdto.setbCategory(rs.getString("BOARD_CATEGORY"));
		bdto.setbTitle(rs.getString("BOARD_TITLE"));
		bdto.setbContent(rs.getString("BOARD_CONTENT"));
		bdto.setmId(rs.getString("ID"));
		bdto.setmNickname(rs.getString("NICKNAME"));
		bdto.setbRegDate(dateFormat.format(rs.getTimestamp("BOARD_REGDATE")));
		
		bidto.setbIdx(rs.getInt("BOARD_INDEX"));
		bidto.setbHit(rs.getInt("BOARD_HIT"));
		bidto.setbUpvote(rs.getInt("BOARD_UPVOTE"));
		bidto.setbDownvote(rs.getInt("BOARD_DOWNVOTE"));
		bidto.setbCommentNum(rs.getInt("BOARD_COMMENTNUM"));
		bidto.setbReportNum(rs.getInt("BOARD_REPORTNUM"));
		bidto.setbBlind(rs.getInt("BOARD_BLIND"));
		bidto.setbNotice(rs.getInt("BOARD_NOTICE"));
		bidto.setbBest(rs.getInt("BOARD_BEST"));
		
		btdto.setbType(rs.getString("BOARD_TYPE"));
		btdto.setbTypeKor(rs.getString("BOARD_TYPE_KOR"));
		btdto.setbId(rs.getString("BOARD_ID"));
		btdto.setbIdKor(rs.getString("BOARD_ID_KOR"));
		btdto.setbIntroduce(rs.getString("BOARD_INTRODUCE"));
		
		bdto.setBoardInfoDto(bidto);
		bdto.setBoardTypeDto(btdto);
		
		return bdto;
	}

}
