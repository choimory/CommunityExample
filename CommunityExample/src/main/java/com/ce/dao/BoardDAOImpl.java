package com.ce.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ce.component.BoardBestRowMapper;
import com.ce.component.BoardRowMapper;
import com.ce.component.PageHelper;
import com.ce.component.SearchHelper;
import com.ce.dto.BoardCategoryDTO;
import com.ce.dto.BoardCommentDTO;
import com.ce.dto.BoardDTO;
import com.ce.dto.BoardFileDTO;
import com.ce.dto.BoardTypeDTO;
import com.ce.dto.BookmarkArticleDTO;
import com.ce.dto.BookmarkBoardDTO;
import com.ce.dto.ReportArticleDTO;
import com.ce.dto.VoteArticleDTO;

public class BoardDAOImpl implements BoardDAO {
	private JdbcTemplate jdbcTemplate;
	private static final Logger log=LoggerFactory.getLogger(BoardDAOImpl.class);

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	@Override
	public int getTotalRowReportList() {
		int result = 0;
		String sql = "SELECT COUNT(*) " + "FROM HUMOR_INFO, GAME_INFO, SPORTS_INFO, ENTERTAINMENT_INFO "
				+ "WHERE HUMOR_INFO.BOARD_REPORTNUM>=50 " + "AND GAME_INFO.BOARD_REPORTNUM>=50 "
				+ "AND SPORTS_INFO.BOARD_REPORTNUM>=50 " + "AND ENTERTAINMENT_INFO.BOARD_REPORTNUM>=50";

		try {
			result = jdbcTemplate.queryForObject(sql, Integer.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			result = -1;
		}
		return result;
	}

	@Override
	public List<BoardDTO> reportList(PageHelper pageHelper) {
		List<BoardDTO> boardDtoList = null;
		String sql = "SELECT * FROM HUMOR INNER JOIN HUMOR_INFO ON HUMOR.BOARD_INDEX=HUMOR_INFO.BOARD_INDEX WHERE HUMOR_INFO.BOARD_REPORTNUM>=50 "
				+ "UNION ALL "
				+ "SELECT * FROM GAME INNER JOIN GAME_INFO ON GAME.BOARD_INDEX=GAME_INFO.BOARD_INDEX WHERE GAME_INFO.BOARD_REPORTNUM>=50 "
				+ "UNION ALL "
				+ "SELECT * FROM ENTERTAINMENT INNER JOIN ENTERTAINMENT_INFO ON ENTERTAINMENT.BOARD_INDEX=ENTERTAINMENT_INFO.BOARD_INDEX WHERE ENTERTAINMENT_INFO.BOARD_REPORTNUM>=50 "
				+ "UNION ALL "
				+ "SELECT * FROM SPORTS INNER JOIN SPORTS_INFO ON SPORTS.BOARD_INDEX=SPORTS_INFO.BOARD_INDEX WHERE SPORTS_INFO.BOARD_REPORTNUM>=50 "
//				+"UNION ALL "
//				+"SELECT * FROM SHOP INNER JOIN SHOP_INFO ON SHOP.BOARD_INDEX=SHOP_INFO.BOARD_INDEX WHERE SHOP_INFO.BOARD_REPORTNUM>=50 "
				+ "ORDER BY BOARD_REGDATE ASC " + "LIMIT ?,?";

		try {
			boardDtoList = jdbcTemplate.query(sql, new Object[] { pageHelper.getListFirst(), pageHelper.getListLast() },
					new BoardRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
			boardDtoList = null;
		}

		return boardDtoList;
	}

	@Override
	public int createBoard(BoardTypeDTO boardTypeDto) {
		String boardType = null;
		int result = 0;
		String sql = "INSERT " + "INTO BOARD_TYPE(BOARD_TYPE, BOARD_ID, BOARD_TYPE_KOR, BOARD_ID_KOR, BOARD_INTRODUCE) "
				+ "VALUES (?,?,?,?,?)";

		try {
			result = jdbcTemplate.update(sql, new Object[] { boardTypeDto.getbType(), boardTypeDto.getbId(),
					boardTypeDto.getbTypeKor(), boardTypeDto.getbIdKor(), boardTypeDto.getbIntroduce() });
		} catch (DataAccessException e) {
		}

		return result;
	}

	@Override
	public int blind(BoardDTO boardDto) {
		String boardType = boardDto.getBoardTypeDto().getbType();
		int result = 0;
		String sql = "UPDATE " + boardType + " " + "SET BOARD_BLIND=? " + "WHERE BOARD_INDEX=?";

		try {
			result = jdbcTemplate.update(sql,
					new Object[] { boardDto.getBoardInfoDto().getbBlind(), boardDto.getbIdx() });
		} catch (DataAccessException e) {
			e.printStackTrace();
			result = -1;
		}

		return result;
	}

	@Override
	public BoardTypeDTO getBoardType(BoardTypeDTO boardTypeDto) {
		String sql = "SELECT * " + "FROM BOARD_TYPE " + "WHERE BOARD_ID=?";

		try {
			boardTypeDto = jdbcTemplate.queryForObject(sql, new Object[] { boardTypeDto.getbId() },
					new RowMapper<BoardTypeDTO>() {
						@Override
						public BoardTypeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
							BoardTypeDTO boardTypeDto = new BoardTypeDTO();
							boardTypeDto.setbType(rs.getString("BOARD_TYPE"));
							boardTypeDto.setbId(rs.getString("BOARD_ID"));
							boardTypeDto.setbTypeKor(rs.getString("BOARD_TYPE_KOR"));
							boardTypeDto.setbIdKor(rs.getString("BOARD_ID_KOR"));
							boardTypeDto.setbIntroduce(rs.getString("BOARD_INTRODUCE"));
							return boardTypeDto;
						}
					});
		} catch (DataAccessException e) {
			e.printStackTrace();
			boardTypeDto = null;
		}

		return boardTypeDto;
	}

	@Override
	public BoardTypeDTO getBoardType(BoardDTO boardDto) {
		BoardTypeDTO boardTypeDto = null;
		String sql = "SELECT * " + "FROM BOARD_TYPE " + "WHERE BOARD_ID=?";

		try {
			boardTypeDto = jdbcTemplate.queryForObject(sql, new Object[] { boardDto.getbId() },
					new RowMapper<BoardTypeDTO>() {
						@Override
						public BoardTypeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
							BoardTypeDTO boardTypeDto = new BoardTypeDTO();
							boardTypeDto.setbType(rs.getString("BOARD_TYPE"));
							boardTypeDto.setbId(rs.getString("BOARD_ID"));
							boardTypeDto.setbTypeKor(rs.getString("BOARD_TYPE_KOR"));
							boardTypeDto.setbIdKor(rs.getString("BOARD_ID_KOR"));
							boardTypeDto.setbIntroduce(rs.getString("BOARD_INTRODUCE"));
							return boardTypeDto;
						}
					});
		} catch (DataAccessException e) {
			e.printStackTrace();
			boardTypeDto = null;
		}

		return boardTypeDto;
	}

	@Override
	public BoardTypeDTO getBoardType(String bId) {
		BoardTypeDTO boardTypeDto = null;
		String sql = "SELECT * " 
				+ "FROM BOARD_TYPE " 
				+ "WHERE BOARD_ID=?";

		try {
			boardTypeDto = jdbcTemplate.queryForObject(sql, new Object[] { bId }, new RowMapper<BoardTypeDTO>() {
				@Override
				public BoardTypeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					BoardTypeDTO boardTypeDto = new BoardTypeDTO();
					boardTypeDto.setbType(rs.getString("BOARD_TYPE"));
					boardTypeDto.setbId(rs.getString("BOARD_ID"));
					boardTypeDto.setbTypeKor(rs.getString("BOARD_TYPE_KOR"));
					boardTypeDto.setbIdKor(rs.getString("BOARD_ID_KOR"));
					boardTypeDto.setbIntroduce(rs.getString("BOARD_INTRODUCE"));
					return boardTypeDto;
				}
			});
		} catch (DataAccessException e) {
			e.printStackTrace();
			boardTypeDto = null;
		}

		return boardTypeDto;
	}

	@Override
	public String changeBoardTypeKorToEng(String boardTypeKor) {
		String boardType = null;
		String sql = "SELECT DISTINCT BOARD_TYPE.BOARD_TYPE " + "FROM BOARD_TYPE " + "WHERE BOARD_TYPE.BOARD_TYPE_KOR=?";

		try {
			boardType=jdbcTemplate.queryForObject(sql, new Object[] {boardTypeKor}, String.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			boardType = null;
		}

		return boardType;
	}

	@Override
	public String getbType(String bId) {
		String boardType = null;
		String sql = "SELECT BOARD_TYPE " + "FROM BOARD_TYPE " + "WHERE BOARD_ID=?";

		try {
			boardType = jdbcTemplate.queryForObject(sql, new Object[] { bId }, String.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			boardType = null;
		}

		return boardType;
	}@Override
	public List<String> getBoardTypeList() {
		List<String> boardTypeList = null;
		String sql = "SELECT DISTINCT BOARD_TYPE.BOARD_TYPE " + "FROM BOARD_TYPE";

		try {
			boardTypeList = jdbcTemplate.queryForList(sql, String.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			boardTypeList = null;
		}
		return boardTypeList;
	}

	@Override
	public List<String> getBoardTypeListKor() {
		List<String> boardTypeKorList = null;
		String sql = "SELECT DISTINCT BOARD_TYPE.BOARD_TYPE_KOR " + "FROM BOARD_TYPE";

		try {
			boardTypeKorList = jdbcTemplate.queryForList(sql, String.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			boardTypeKorList = null;
		}
		return boardTypeKorList;
	}



	@Override
	public List<String> getBoardIdList() {
		List<String> boardIdList = null;
		String sql = "SELECT BOARD_ID " + "FROM BOARD_TYPE";

		try {
			boardIdList = jdbcTemplate.queryForList(sql, String.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			boardIdList = null;
		}

		return boardIdList;
	}
	@Override
	public List<String> getBoardIdKorList() {
		List<String> boardIdList = null;
		String sql = "SELECT BOARD_ID_KOR " + "FROM BOARD_TYPE";

		try {
			boardIdList = jdbcTemplate.queryForList(sql, String.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			boardIdList = null;
		}

		return boardIdList;
	}

	@Override
	public List<BoardDTO> list(BoardDTO boardDto) {
		String boardType = boardDto.getBoardTypeDto().getbType();
		String query=boardDto.getSearchHelper().getQuery();
		String target=boardDto.getSearchHelper().getTarget();
		String bCategory=boardDto.getSearchHelper().getbCategory();
		List<BoardDTO> boardDtoList = null;
		int limitFirst = boardDto.getPageHelper().getListFirst();
		int limitLast = boardDto.getPageHelper().getListLast();
		String sql = "SELECT * " 
				+ "FROM " + boardType + " " 
				+ "INNER JOIN " + boardType + "_INFO " 
				+ "ON " + boardType+ ".BOARD_INDEX=" + boardType + "_INFO.BOARD_INDEX ";				
			
		try {
			if(query==null && bCategory.equals("all")) { //전체 리스트
				sql+="WHERE BOARD_ID=? "
					+ "ORDER BY " + boardType+ ".BOARD_INDEX DESC " 
					+ "LIMIT ?,?";
				boardDtoList = jdbcTemplate.query(sql, new Object[] { boardDto.getbId(), limitFirst, limitLast }, new BoardRowMapper());
			}else if(query==null&& !bCategory.equals("all")){	//카테고리 검색	
					sql+="WHERE BOARD_ID=? AND BOARD_CATEGORY=? "
							+ "ORDER BY "+boardType+".BOARD_INDEX DESC "
							+ "LIMIT ?,?";
					boardDtoList = jdbcTemplate.query(sql, new Object[] { boardDto.getbId(), bCategory, limitFirst, limitLast }, new BoardRowMapper());
			} else if(query!=null && bCategory.equals("all")){ //검색어 검색
				if(target.equals("both")) {	//제목+내용 검색
					query="%"+boardDto.getSearchHelper().getQuery()+"%";
					sql+="WHERE BOARD_ID=? AND BOARD_TITLE LIKE ? OR BOARD_CONTENT LIKE ? "
							+ "ORDER BY "+boardType+".BOARD_INDEX DESC "
							+ "LIMIT ?,?";
					boardDtoList = jdbcTemplate.query(sql, new Object[] { boardDto.getbId(), query, query, limitFirst, limitLast }, new BoardRowMapper());
				} else if(target.equals("title")) { //제목 검색
					query="%"+boardDto.getSearchHelper().getQuery()+"%";
					sql+="WHERE BOARD_ID=? AND BOARD_TITLE LIKE ? "
							+ "ORDER BY "+boardType+".BOARD_INDEX DESC "
							+ "LIMIT ?,?";
					boardDtoList = jdbcTemplate.query(sql, new Object[] { boardDto.getbId(), query, limitFirst, limitLast }, new BoardRowMapper());
				} else if(target.equals("content")) { //내용 검색
					query="%"+boardDto.getSearchHelper().getQuery()+"%";					
					sql+="WHERE BOARD_ID=? AND BOARD_CONTENT LIKE ? "
							+ "ORDER BY "+boardType+".BOARD_INDEX DESC "
							+ "LIMIT ?,?";
					boardDtoList = jdbcTemplate.query(sql, new Object[] { boardDto.getbId(), query, limitFirst, limitLast }, new BoardRowMapper());
				} else if(target.equals("nickname")) {	//닉네임 검색			
					sql+="WHERE BOARD_ID=? AND NICKNAME LIKE ? "
							+ "ORDER BY "+boardType+".BOARD_INDEX DESC "
							+ "LIMIT ?,?";
					boardDtoList = jdbcTemplate.query(sql, new Object[] { boardDto.getbId(), query, limitFirst, limitLast }, new BoardRowMapper());
				}
			}else if(query!=null&&!bCategory.equals("all")) { //검색어+카테고리 검색
				if(target.equals("both")) {	//제목+내용+카테고리 검색
					query="%"+boardDto.getSearchHelper().getQuery()+"%";
					sql+="WHERE BOARD_ID=? AND BOARD_TITLE LIKE ? OR BOARD_CONTENT LIKE ? AND BOARD_CATEGORY=? "
							+ "ORDER BY "+boardType+".BOARD_INDEX DESC "
							+ "LIMIT ?,?";
					boardDtoList = jdbcTemplate.query(sql, new Object[] { boardDto.getbId(), query, query,bCategory, limitFirst, limitLast }, new BoardRowMapper());
				} else if(target.equals("title")) { //제목+카테고리 검색
					query="%"+boardDto.getSearchHelper().getQuery()+"%";
					sql+="WHERE BOARD_ID=? AND BOARD_TITLE LIKE ? AND BOARD_CATEGORY=? "
							+ "ORDER BY "+boardType+".BOARD_INDEX DESC "
							+ "LIMIT ?,?";
					boardDtoList = jdbcTemplate.query(sql, new Object[] { boardDto.getbId(), query, bCategory,limitFirst, limitLast }, new BoardRowMapper());
				} else if(target.equals("content")) { //내용+카테고리 검색
					query="%"+boardDto.getSearchHelper().getQuery()+"%";					
					sql+="WHERE BOARD_ID=? AND BOARD_CONTENT LIKE ? AND BOARD_CATEGORY=? "
							+ "ORDER BY "+boardType+".BOARD_INDEX DESC "
							+ "LIMIT ?,?";
					boardDtoList = jdbcTemplate.query(sql, new Object[] { boardDto.getbId(), query, bCategory,limitFirst, limitLast }, new BoardRowMapper());
				} else if(target.equals("nickname")) {	//닉네임+카테고리 검색			
					sql+="WHERE BOARD_ID=? AND NICKNAME LIKE ? AND BOARD_CATEGORY=? "
							+ "ORDER BY "+boardType+".BOARD_INDEX DESC "
							+ "LIMIT ?,?";
					boardDtoList = jdbcTemplate.query(sql, new Object[] { boardDto.getbId(), query,bCategory, limitFirst, limitLast }, new BoardRowMapper());
				}
			}
			
		} catch (DataAccessException e) {
			e.printStackTrace();
			boardDtoList = null;
		}

		return boardDtoList;
	}

	@Override
	public BoardDTO content(BoardDTO boardDto) {
		String boardType = boardDto.getBoardTypeDto().getbType();
		String sql = "SELECT * " 
				+ "FROM " + boardType + " " 
				+ "INNER JOIN " + boardType + "_INFO " 
				+ "ON " + boardType + ".BOARD_INDEX=" + boardType + "_INFO.BOARD_INDEX "
				+ "WHERE " + boardType + ".BOARD_INDEX=?";

		try {
			boardDto = jdbcTemplate.queryForObject(sql, new Object[] { boardDto.getbIdx() }, new BoardRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
			boardDto = null;
		}

		return boardDto;
	}

	@Override
	public List<BoardFileDTO> contentFile(BoardDTO boardDto) {
		List<BoardFileDTO> boardFileDtoList=null;
		String boardType=boardDto.getBoardTypeDto().getbType();
		int bIdx=boardDto.getbIdx();
		String sql="SELECT * "
				+ "FROM "+boardType+"_FILE "
				+ "WHERE BOARD_INDEX=?";
		
		try {
			boardFileDtoList=jdbcTemplate.query(sql, new Object[] {bIdx}, new RowMapper<BoardFileDTO>() {
				@Override
				public BoardFileDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					BoardFileDTO bfDto=new BoardFileDTO();
					
					bfDto.setfIdx(rs.getInt("FILE_INDEX"));
					bfDto.setbIdx(rs.getInt("BOARD_INDEX"));
					bfDto.setfOriginalName(rs.getString("FILE_ORIGINAL_NAME"));
					bfDto.setfStoredName(rs.getString("FILE_STORED_NAME"));
					bfDto.setfSize(rs.getLong("FILE_SIZE"));
					
					return bfDto;
				}
			});
		} catch (DataAccessException e) {
			e.printStackTrace();
			boardFileDtoList=null;
		}
		
		return boardFileDtoList;
	}


	@Override
	public int increaseHit(BoardDTO boardDto) {
		String boardType = boardDto.getBoardTypeDto().getbType();
		int result = 0;
		String sql = "UPDATE " + boardType + "_INFO " + "SET BOARD_HIT=BOARD_HIT+1 " + "WHERE BOARD_INDEX=?";

		try {
			result = jdbcTemplate.update(sql, new Object[] { boardDto.getbIdx() });
		} catch (DataAccessException e) {
			e.printStackTrace();
			result = -1;
		}

		return result;
	}

	@Override
	public int write(BoardDTO boardDto) {
		String boardType = boardDto.getBoardTypeDto().getbType();
		int result = 0;
		String sql = "INSERT " + "INTO " + boardType
				+ " (BOARD_INDEX,BOARD_ID,BOARD_CATEGORY,BOARD_TITLE,BOARD_CONTENT,ID,NICKNAME,BOARD_REGDATE) "
				+ "VALUES (0,?,?,?,?,?,?,NOW())";

		try {
			result = jdbcTemplate.update(sql, new Object[] { boardDto.getbId(), boardDto.getbCategory(),
					boardDto.getbTitle(), boardDto.getbContent(), boardDto.getmId(), boardDto.getmNickname() });
		} catch (DataAccessException e) {
			e.printStackTrace();
			result = -1;
		}

		return result;
	}

	@Override
	public int getLatestIndex(BoardDTO boardDto) {
		int result = 0;
		String boardType = boardDto.getBoardTypeDto().getbType();
		String sql = "SELECT MAX(BOARD_INDEX)" + "FROM " + boardType + " "
				+ "WHERE ID=? AND NICKNAME=? AND BOARD_TITLE=? AND BOARD_CONTENT=?";

		try {
			result = jdbcTemplate.queryForObject(sql, new Object[] { boardDto.getmId(), boardDto.getmNickname(),
					boardDto.getbTitle(), boardDto.getbContent() }, Integer.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			result = -1;
		}
		return result;
	}

	@Override
	public int writeInfo(BoardDTO boardDto) {
		String boardType = boardDto.getBoardTypeDto().getbType();
		int result = 0;
		String sql = "INSERT " + "INTO " + boardType
				+ "_INFO (BOARD_INDEX,BOARD_HIT,BOARD_UPVOTE,BOARD_DOWNVOTE,BOARD_COMMENTNUM,BOARD_REPORTNUM,BOARD_BLIND,BOARD_NOTICE,BOARD_BEST)"
				+ "VALUES (?,0,0,0,0,0,0,?,0)";

		try {
			result = jdbcTemplate.update(sql,
					new Object[] { boardDto.getbIdx(), boardDto.getBoardInfoDto().getbNotice() });
		} catch (DataAccessException e) {
			e.printStackTrace();
			result = -1;
		}

		return result;
	}

	@Override
	public int bookmarkBoard(BookmarkBoardDTO bookmarkBoardDto) {
		int result = 0;
		String sql = "INSERT " 
				+ "INTO BOOKMARK_BOARD (ID,BOARD_TYPE,BOARD_ID,BOARD_TYPE_KOR,BOARD_ID_KOR) " 
				+ "VALUES (?,?,?,?,?)";

		try {
			result = jdbcTemplate.update(sql,
					new Object[] { bookmarkBoardDto.getmId(), bookmarkBoardDto.getbType(), bookmarkBoardDto.getbId(),bookmarkBoardDto.getbTypeKor(),bookmarkBoardDto.getbIdKor() });
		} catch (DataAccessException e) {
			e.printStackTrace();
			result = -1;
		}

		return result;
	}

	@Override
	public int unBookmarkBoard(BookmarkBoardDTO bookmarkBoardDto) {
		int result = 0;
		String sql = "DELETE " 
				+ "FROM BOOKMARK_BOARD " 
				+ "WHERE ID=? AND BOARD_ID=?";

		try {
			result = jdbcTemplate.update(sql, new Object[] { bookmarkBoardDto.getmId(), bookmarkBoardDto.getbId() });
		} catch (DataAccessException e) {
			e.printStackTrace();
			result = -1;
		}

		return result;
	}

	@Override
	public List<String> getBoardCategory(String bId) {
		List<String> boardCategoryList = null;
		String sql = "SELECT BOARD_CATEGORY " 
				+ "FROM BOARD_CATEGORY " 
				+ "WHERE BOARD_ID=?"
				+ "ORDER BY BOARD_CATEGORY ASC";

		try {
			boardCategoryList = jdbcTemplate.queryForList(sql, new Object[] { bId }, String.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			boardCategoryList = null;
		}

		return boardCategoryList;
	}

	@Override
	public int modify(BoardDTO boardDto) {
		String boardType = boardDto.getBoardTypeDto().getbType();
		;
		int result = 0;
		String sql = "UPDATE " + boardType + " "
				+ "SET BOARD_CATEGORY=?,BOARD_TITLE=?,BOARD_CONTENT=?,BOARD_REGDATE=NOW() " 
				+ "WHERE BOARD_INDEX=?";

		try {
			result = jdbcTemplate.update(sql, new Object[] { boardDto.getbCategory(), boardDto.getbTitle(),
					boardDto.getbContent(), boardDto.getbIdx() });
		} catch (DataAccessException e) {
			e.printStackTrace();
			result = -1;
		}

		return result;
	}

	@Override
	public int modifyFile(BoardDTO boardDto) {
		String boardType = boardDto.getBoardTypeDto().getbType();
		int result = 0;
		String sql = "";

		try {
		} catch (DataAccessException e) {
			e.printStackTrace();
			result = -1;
		}

		return result;
	}

	@Override
	public int delete(BoardDTO boardDto) {
		String boardType = boardDto.getBoardTypeDto().getbType();
		int result = 0;
		String sql = "DELETE FROM " + boardType + " " 
				+ "WHERE BOARD_INDEX=?";

		try {
			result = jdbcTemplate.update(sql, new Object[] { boardDto.getbIdx() });
		} catch (DataAccessException e) {
			e.printStackTrace();
			result = -1;
		}

		return result;
	}

	@Override
	public int deleteFile(BoardDTO boardDto) {
		String boardType = boardDto.getBoardTypeDto().getbType();
		int result = 0;
		String sql = "";

		try {
		} catch (DataAccessException e) {
			e.printStackTrace();
			result = -1;
		}

		return result;
	}


	@Override
	public int bookmarkArticle(BookmarkArticleDTO bookmarkArticleDto) {
		int result = 0;
		String sql = "INSERT " + "INTO BOOKMARK_ARTICLE (BOOKMARK_INDEX,ID,BOARD_TYPE,BOARD_ID,BOARD_INDEX) "
				+ "VALUES (0,?,?,?,?)";

		try {
			result = jdbcTemplate.update(sql, new Object[] {bookmarkArticleDto.getmId(),
					bookmarkArticleDto.getbType(), bookmarkArticleDto.getbId(), bookmarkArticleDto.getbIdx() });
		} catch (DataAccessException e) {
			e.printStackTrace();
			result = -1;
		}

		return result;
	}

	@Override
	public int unBookmarkArticle(BookmarkArticleDTO bookmarkArticleDto) {
		int result = 0;
		String sql = "DELETE " 
				+ "FROM BOOKMARK_ARTICLE " 
				+ "WHERE ID=? AND BOARD_ID=? AND BOARD_INDEX=?";

		try {
			result = jdbcTemplate.update(sql,
					new Object[] { bookmarkArticleDto.getmId(),bookmarkArticleDto.getbId(),bookmarkArticleDto.getbIdx()});
		} catch (DataAccessException e) {
			e.printStackTrace();
			result = -1;
		}

		return result;
	}

	@Override
	public int checkBookmarkArticleAlready(BookmarkArticleDTO bookmarkArticleDto) {
		int result=0;
		String sql="SELECT COUNT(*) "
				+ "FROM BOOKMARK_ARTICLE "
				+ "WHERE ID=? AND BOARD_ID=? AND BOARD_INDEX=?";
		
		try {
			result=jdbcTemplate.queryForObject(sql, new Object[] {bookmarkArticleDto.getmId(),bookmarkArticleDto.getbId(),bookmarkArticleDto.getbIdx()}, Integer.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			result=-1;
		}
		return result;
	}


	@Override
	public int checkVoteArticleAlready(VoteArticleDTO voteArticleDto) {
		int result = 0;
		String sql = "SELECT COUNT(*) " + "FROM VOTE_ARTICLE " + "WHERE ID=? AND BOARD_INDEX=?";

		try {
			result = jdbcTemplate.queryForObject(sql,
					new Object[] { voteArticleDto.getmId(), voteArticleDto.getbIdx() }, Integer.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			result = -1;
		}

		return result;
	}

	@Override
	public int checkReportAlready(ReportArticleDTO reportArticleDto) {
		int result = 0;
		String sql = "SELECT COUNT(*) " 
				+ "FROM REPORT_ARTICLE " 
				+ "WHERE ID=? AND BOARD_INDEX=?";

		try {
			result = jdbcTemplate.queryForObject(sql, new Object[] { reportArticleDto.getmId(), reportArticleDto.getbIdx() },
					Integer.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			result = -1;
		}

		return result;
	}

	@Override
	public int writeReportArticle(ReportArticleDTO reportArticleDto) {
		int result = 0;
		String sql = "INSERT " 
				+ "INTO REPORT_ARTICLE (ID,BOARD_TYPE,BOARD_ID,BOARD_INDEX) " 
				+ "VALUES (?,?,?,?)";

		try {
			result = jdbcTemplate.update(sql,
					new Object[] { reportArticleDto.getmId(), reportArticleDto.getbType(), reportArticleDto.getbId(), reportArticleDto.getbIdx() });
		} catch (DataAccessException e) {
			e.printStackTrace();
			result = -1;
		}

		return result;
	}

	@Override
	public int thumbsUpContent(VoteArticleDTO voteArticleDto) {
		String boardType = voteArticleDto.getbType();
		int result = 0;
		String sql = "UPDATE " + boardType + "_INFO " + "SET BOARD_UPVOTE=BOARD_UPVOTE+1" + " WHERE BOARD_INDEX=?";

		try {
			result = jdbcTemplate.update(sql, new Object[] { voteArticleDto.getbIdx() });
		} catch (DataAccessException e) {
			e.printStackTrace();
			result = -1;
		}

		return result;
	}

	@Override
	public int thumbsDownContent(VoteArticleDTO voteArticleDto) {
		String boardType = voteArticleDto.getbType();
		int result = 0;
		String sql = "UPDATE " + boardType + "_INFO " + "SET BOARD_DOWNVOTE=BOARD_DOWNVOTE+1" + " WHERE BOARD_INDEX=?";

		try {
			result = jdbcTemplate.update(sql, new Object[] { voteArticleDto.getbIdx() });
		} catch (DataAccessException e) {
			e.printStackTrace();
			result = -1;
		}

		return result;
	}

	@Override
	public int writeVoteArticle(VoteArticleDTO voteArticleDto) {
		String boardType = voteArticleDto.getbType();
		int result = 0;
		String sql = "INSERT " + "INTO VOTE_ARTICLE (ID,BOARD_TYPE,BOARD_ID,BOARD_INDEX,UPDOWN) "
				+ "VALUES (?,?,?,?,?)";

		try {
			result = jdbcTemplate.update(sql, new Object[] { voteArticleDto.getmId(), boardType,
					voteArticleDto.getbId(), voteArticleDto.getbIdx(), voteArticleDto.getvUpDown() });
		} catch (DataAccessException e) {
			e.printStackTrace();
			result = -1;
		}

		return result;
	}

	@Override
	public int increaseReport(ReportArticleDTO reportArticleDto) {
		String boardType = reportArticleDto.getbType();
		int result = 0;
		String sql = "UPDATE " + boardType + "_INFO " 
				+ "SET BOARD_REPORTNUM=BOARD_REPORTNUM+1 " 
				+ "WHERE BOARD_INDEX=?";

		try {
			result = jdbcTemplate.update(sql, new Object[] { reportArticleDto.getbIdx() });
		} catch (DataAccessException e) {
			e.printStackTrace();
			result = -1;
		}

		return result;
	}

	@Override
	public int getTotalRow(BoardDTO boardDto) {
		String boardType = boardDto.getBoardTypeDto().getbType();
		int result = 0;
		String sql = "SELECT COUNT(*) " + "FROM " + boardType;

		try {
			result = jdbcTemplate.queryForObject(sql, Integer.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			result = -1;
		}

		return result;
	}

	@Override
	public int goBest(VoteArticleDTO voteArticleDto) {
		String boardType = voteArticleDto.getbType();
		int result = 0;
		String sql = "UPDATE " + boardType + "_INFO " + "SET BOARD_BEST=1 " + "WHERE BOARD_INDEX=?";

		try {
			result = jdbcTemplate.update(sql, new Object[] { voteArticleDto.getbIdx() });
		} catch (DataAccessException e) {
			e.printStackTrace();
			result = -1;
		}

		return result;
	}

	@Override
	public String changeBoardIdKorToEng(String bIdKor) {
		String bId=null;
		String sql="SELECT BOARD_TYPE.BOARD_ID "
				+ "FROM BOARD_TYPE "
				+ "WHERE BOARD_TYPE.BOARD_ID_KOR=?";
		
		try {
			bId=jdbcTemplate.queryForObject(sql, new Object[] {bIdKor}, String.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			bId=null;
		}
		
		return bId;
	}

	@Override
	public int addCategory(BoardCategoryDTO boardCategoryDto) {
		int result=0;
		String sql="INSERT INTO BOARD_CATEGORY (BOARD_ID, BOARD_CATEGORY) VALUES (?, ?)";
				
		try {
			result=jdbcTemplate.update(sql, new Object[] {boardCategoryDto.getbId(),boardCategoryDto.getbCategory()});
		} catch (DataAccessException e) {
			e.printStackTrace();
			result=-1;
		}
				
		return result;
	}


	@Override
	public int insertBoardFile(BoardFileDTO boardFileDto) {
		int result=0;
		String boardType=boardFileDto.getBoardTypeDto().getbType();
		String sql="INSERT "
				+ "INTO "+boardType+"_FILE (FILE_INDEX, BOARD_INDEX, FILE_ORIGINAL_NAME, FILE_STORED_NAME, FILE_SIZE) "
				+ "VALUES (0,?,?,?,?)";
		
		try {
			jdbcTemplate.update(sql,new Object[] {boardFileDto.getbIdx(),boardFileDto.getfOriginalName(),boardFileDto.getfStoredName(),boardFileDto.getfSize()});
		} catch (DataAccessException e) {
			e.printStackTrace();
			result=-1;
		}
		return result;
	}


	@Override
	public int increaseCommentNum(BoardCommentDTO boardCommentDto) {
		int result=0;
		String boardType=boardCommentDto.getBoardTypeDto().getbType();
		String sql="UPDATE "+boardType+"_INFO "
				+ "SET BOARD_COMMENTNUM=BOARD_COMMENTNUM+1 "
				+ "WHERE BOARD_INDEX=?";
		
		try {
			result=jdbcTemplate.update(sql, new Object[] {boardCommentDto.getbIdx()});
		} catch (DataAccessException e) {
			e.printStackTrace();
			result=-1;
		}
		return result;
	}


	@Override
	public int getUpvoteNum(VoteArticleDTO voteArticleDto) {
		int result=0;
		String boardType=voteArticleDto.getbType();
		String sql="SELECT BOARD_UPVOTE "
				+ "FROM "+boardType+"_INFO "
				+ "WHERE BOARD_INDEX=?";
		
		try {
			result=jdbcTemplate.queryForObject(sql, new Object[] {voteArticleDto.getbIdx()}, Integer.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			result=-1;
		}
		return result;
	}


	@Override
	public int getDownvoteNum(VoteArticleDTO voteArticleDto) {
		int result=0;
		String boardType=voteArticleDto.getbType();
		String sql="SELECT BOARD_DOWNVOTE "
				+ "FROM "+boardType+"_INFO "
				+ "WHERE BOARD_INDEX=?";
		
		try {
			result=jdbcTemplate.queryForObject(sql, new Object[] {voteArticleDto.getbIdx()}, Integer.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			result=-1;
		}
		return result;
	}


	@Override
	public int subtractTwoVotes(VoteArticleDTO voteArticleDto) {
		int result=0;
		String boardType=voteArticleDto.getbType();
		String sql="SELECT BOARD_UPVOTE-BOARD_DOWNVOTE "
				+ "FROM "+boardType+"_INFO "
				+ "WHERE BOARD_INDEX=?";
		
		try {
			result=jdbcTemplate.queryForObject(sql, new Object[] {voteArticleDto.getbIdx()},Integer.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			result=-1;
		}
		
		
		return result;
	}


	@Override
	public int isBookmarkedBoard(BookmarkBoardDTO bookmarkBoardDto) {
		int result=0;
		String sql="SELECT COUNT(*) "
				+ "FROM BOOKMARK_BOARD "
				+ "WHERE ID=? AND BOARD_ID=?";
		
		try {
			result=jdbcTemplate.queryForObject(sql, new Object[] {bookmarkBoardDto.getmId(),bookmarkBoardDto.getbId()},Integer.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			result=-1;
		}
		
		return result;
	}


	@Override
	public int isBookmarkedArticle(BookmarkArticleDTO bookmarkArticleDto) {
		int result=0;
		String sql="SELECT COUNT(*) "
				+ "FROM BOOKMARK_ARTICLE "
				+ "WHERE ID=? AND BOARD_ID=? AND BOARD_INDEX=?";
		
		try {
			result=jdbcTemplate.queryForObject(sql, new Object[] {bookmarkArticleDto.getmId(),bookmarkArticleDto.getbId(),bookmarkArticleDto.getbIdx()}, Integer.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			result=-1;
		}
		return result;
	}


	@Override
	public List<BoardDTO> best(PageHelper pageHelper) {
		List<BoardDTO> boardDtoList=null;
		SearchHelper searchHelper=pageHelper.getSearchHelper();
		String query=searchHelper.getQuery();
		String target=searchHelper.getTarget();
		int first=pageHelper.getListFirst();
		int last=pageHelper.getListLast();
		String sql=null;
		String humor="SELECT * FROM humor JOIN humor_INFO ON humor.BOARD_INDEX=humor_INFO.BOARD_INDEX JOIN BOARD_TYPE ON humor.BOARD_ID=BOARD_TYPE.BOARD_ID WHERE BOARD_BEST=1";
		String game="SELECT * FROM game JOIN game_info ON game.BOARD_INDEX=game_INFO.BOARD_INDEX JOIN BOARD_TYPE ON game.BOARD_ID=BOARD_TYPE.BOARD_ID WHERE BOARD_BEST=1";
		String sports="SELECT * FROM sports JOIN sports_INFO ON sports.BOARD_INDEX=sports_INFO.BOARD_INDEX JOIN BOARD_TYPE ON sports.BOARD_ID=BOARD_TYPE.BOARD_ID WHERE BOARD_BEST=1";
		String entertainment="SELECT * FROM entertainment JOIN entertainment_INFO ON entertainment.BOARD_INDEX=entertainment_INFO.BOARD_INDEX JOIN BOARD_TYPE ON entertainment.BOARD_ID=BOARD_TYPE.BOARD_ID WHERE BOARD_BEST=1";
		String orderBy=" ORDER BY BOARD_REGDATE DESC";
		String limit=" LIMIT ?,?";
		try {
			if(query==null) {//전체 리스트
				sql=humor+" UNION ALL "+game+" UNION ALL "+sports+" UNION ALL "+entertainment+orderBy+limit;
				boardDtoList=jdbcTemplate.query(sql, new Object[] {first,last}, new BoardBestRowMapper());
			} else if(query!=null) {
				if(target.equals("both")) { //제목+내용 검색	
					query="%"+query+"%";
					humor=humor+" AND BOARD_TITLE LIKE ? OR BOARD_CONTENT LIKE ?";
					game=game+" AND BOARD_TITLE LIKE ? OR BOARD_CONTENT LIKE ?";
					sports=sports+" AND BOARD_TITLE LIKE ? OR BOARD_CONTENT LIKE ?";
					entertainment=entertainment+" AND BOARD_TITLE LIKE ? OR BOARD_CONTENT LIKE ?";
					sql=humor+" UNION ALL "+game+" UNION ALL "+sports+" UNION ALL "+entertainment+orderBy+limit;
					boardDtoList=jdbcTemplate.query(sql, new Object[] {query,query,query,query,query,query,query,query,first,last}, new BoardBestRowMapper());
				}else if(target.equals("title")) {	//제목 검색		
					query="%"+query+"%";
					humor=humor+" AND BOARD_TITLE LIKE ?";
					game=game+" AND BOARD_TITLE LIKE ?";
					sports=sports+" AND BOARD_TITLE LIKE ?";
					entertainment=entertainment+" AND BOARD_TITLE LIKE ?";
					sql=humor+" UNION ALL "+game+" UNION ALL "+sports+" UNION ALL "+entertainment+orderBy+limit;
					boardDtoList=jdbcTemplate.query(sql, new Object[] {query,query,query,query,first,last}, new BoardBestRowMapper());
				}else if(target.equals("content")) { //내용 검색		
					query="%"+query+"%";
					humor=humor+" AND BOARD_CONTENT LIKE ?";
					game=game+" AND BOARD_CONTENT LIKE ?";
					sports=sports+" AND BOARD_CONTENT LIKE ?";
					entertainment=entertainment+" AND BOARD_CONTENT LIKE ?";
					sql=humor+" UNION ALL "+game+" UNION ALL "+sports+" UNION ALL "+entertainment+orderBy+limit;
					boardDtoList=jdbcTemplate.query(sql, new Object[] {query,query,query,query,first,last}, new BoardBestRowMapper());	
				}else if(target.equals("nickname")) { //닉네임 검색		
					query="%"+query+"%";
					humor=humor+" AND NICKNAME LIKE ?";
					game=game+" AND NICKNAME LIKE ?";
					sports=sports+" AND NICKNAME LIKE ?";
					entertainment=entertainment+" AND NICKNAME LIKE ?";
					sql=humor+" UNION ALL "+game+" UNION ALL "+sports+" UNION ALL "+entertainment+orderBy+limit;
					boardDtoList=jdbcTemplate.query(sql, new Object[] {query,query,query,query,first,last}, new BoardBestRowMapper());	
				}
			}
						
		} catch (DataAccessException e) {
			e.printStackTrace();
			boardDtoList=null;
		}
		
		return boardDtoList;
	}


	@Override
	public List<String> getBoardIdListByType(String bType) {
		List<String> boardIdList=null;
		String sql="SELECT BOARD_ID FROM BOARD_TYPE WHERE BOARD_TYPE=?";
		
		try {
			boardIdList=jdbcTemplate.queryForList(sql, new Object[] {bType},String.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			boardIdList=null;
		}
		
		return boardIdList;
	}


	@Override
	public List<BoardDTO> bestMain() {
		List<BoardDTO> bestDto=null;
		String humor="SELECT * FROM humor JOIN humor_INFO ON humor.BOARD_INDEX=humor_INFO.BOARD_INDEX JOIN BOARD_TYPE ON humor.BOARD_ID=BOARD_TYPE.BOARD_ID WHERE BOARD_BEST=1";
		String game="SELECT * FROM game JOIN game_info ON game.BOARD_INDEX=game_INFO.BOARD_INDEX JOIN BOARD_TYPE ON game.BOARD_ID=BOARD_TYPE.BOARD_ID WHERE BOARD_BEST=1";
		String sports="SELECT * FROM sports JOIN sports_INFO ON sports.BOARD_INDEX=sports_INFO.BOARD_INDEX JOIN BOARD_TYPE ON sports.BOARD_ID=BOARD_TYPE.BOARD_ID WHERE BOARD_BEST=1";
		String entertainment="SELECT * FROM entertainment JOIN entertainment_INFO ON entertainment.BOARD_INDEX=entertainment_INFO.BOARD_INDEX JOIN BOARD_TYPE ON entertainment.BOARD_ID=BOARD_TYPE.BOARD_ID WHERE BOARD_BEST=1";
		String orderBy=" ORDER BY BOARD_REGDATE DESC";
		String limit=" LIMIT 0,9";
		String sql=humor+" UNION ALL "+game+" UNION ALL "+sports+" UNION ALL "+entertainment+orderBy+limit;
		
		try {
			bestDto=jdbcTemplate.query(sql, new BoardBestRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
			bestDto=null;
		}
		
		return bestDto;
	}


	@Override
	public List<BoardDTO> otherMain(BoardDTO boardDto) {
		List<BoardDTO> boardDtoList=null;
		String boardType=boardDto.getBoardTypeDto().getbType();
		String bId=boardDto.getbId();
		String sql="SELECT * "
				+ "FROM "+boardType+" "
				+ "INNER JOIN "+boardType+"_INFO "
				+ "ON "+boardType+".BOARD_INDEX="+boardType+"_INFO.BOARD_INDEX "
				+ "INNER JOIN BOARD_TYPE "
				+ "ON "+boardType+".BOARD_ID=BOARD_TYPE.BOARD_ID "
				+ "WHERE "+boardType+".BOARD_ID=? "
				+ "ORDER BY "+boardType+".BOARD_INDEX DESC "
				+ "LIMIT 0,4";
		
		try {
			boardDtoList=jdbcTemplate.query(sql, new Object[] {bId}, new BoardBestRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
			boardDtoList=null;
		}
		
		return boardDtoList;
	}


	@Override
	public int getBestTotalRow(List<String> boardTypeList) {
		int result=0;
		String sql="SELECT SUM(bestcount) "
				+ "FROM ("
				+ "SELECT COUNT(*) AS bestcount FROM humor_info WHERE humor_info.BOARD_BEST=1 "
				+ "UNION ALL "
				+ "SELECT COUNT(*) AS bestcount FROM game_info WHERE game_info.BOARD_BEST=1 "
				+ "UNION ALL "
				+ "SELECT COUNT(*) AS bestcount FROM sports_info WHERE sports_info.BOARD_BEST=1 "
				+ "UNION ALL "
				+ "SELECT COUNT(*) AS bestcount FROM entertainment_info WHERE entertainment_info.BOARD_BEST=1"
				+ ")anytbname"; 
		
		try {
			result=jdbcTemplate.queryForObject(sql, Integer.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			result=-1;
		}
		
		return result;
	}


	@Override
	public String getStoredFileName(BoardFileDTO boardFileDto) {
		String fileName=null;
		String boardType=boardFileDto.getBoardTypeDto().getbType();
		String sql="SELECT FILE_STORED_NAME "
				+ "FROM "+boardType+"_FILE "
				+ "WHERE FILE_INDEX=?";
		
		try {
			fileName=jdbcTemplate.queryForObject(sql, new Object[] {boardFileDto.getfIdx()}, String.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			fileName=null;
		}
		
		return fileName;
	}
	
}
