package com.ce.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ce.component.BoardRowMapper;
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
		String sql = "CREATE TABLE +boardType+();";

		try {
		} catch (DataAccessException e) {
		}

		return result;
	}

	@Override
	public int blind(BoardDTO boardDto) {
		String boardType = boardDto.getBoardTypeDto().getbType();
		int result = 0;
		String sql = "UPDATE " + boardType + " " 
				+ "SET BOARD_BLIND=? " 
				+ "WHERE BOARD_INDEX=?";

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
		String sql = "SELECT * " 
				+ "FROM BOARD_TYPE " 
				+ "WHERE BOARD_ID=?";

		try {
			boardTypeDto = jdbcTemplate.queryForObject(sql, new Object[] { boardTypeDto.getbId() },
					new RowMapper<BoardTypeDTO>() {
						@Override
						public BoardTypeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
							BoardTypeDTO boardTypeDto = new BoardTypeDTO();
							boardTypeDto.setbId(rs.getString("BOARD_ID"));
							boardTypeDto.setbType(rs.getString("BOARD_TYPE"));
							boardTypeDto.setbCategory(rs.getString("BOARD_CATEGORY"));
							boardTypeDto.setbIdKor(rs.getString("BOARD_ID_KOR"));
							boardTypeDto.setbTypeKor(rs.getString("BOARD_TYPE_KOR"));
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
		String sql = "SELECT * " 
				+ "FROM BOARD_TYPE " 
				+ "WHERE BOARD_ID=?";

		try {
			boardTypeDto = jdbcTemplate.queryForObject(sql, new Object[] { boardDto.getbId() },
					new RowMapper<BoardTypeDTO>() {
						@Override
						public BoardTypeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
							BoardTypeDTO boardTypeDto = new BoardTypeDTO();
							boardTypeDto.setbId(rs.getString("BOARD_ID"));
							boardTypeDto.setbType(rs.getString("BOARD_TYPE"));
							boardTypeDto.setbCategory(rs.getString("BOARD_CATEGORY"));
							boardTypeDto.setbIdKor(rs.getString("BOARD_ID_KOR"));
							boardTypeDto.setbTypeKor(rs.getString("BOARD_TYPE_KOR"));
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
				+ "WHERE BOARD_ID";

		try {
			boardTypeDto = jdbcTemplate.queryForObject(sql, new RowMapper<BoardTypeDTO>() {
				@Override
				public BoardTypeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					BoardTypeDTO boardTypeDto = new BoardTypeDTO();
					boardTypeDto.setbId(rs.getString("BOARD_ID"));
					boardTypeDto.setbType(rs.getString("BOARD_TYPE"));
					boardTypeDto.setbCategory(rs.getString("BOARD_CATEGORY"));
					boardTypeDto.setbIdKor(rs.getString("BOARD_ID_KOR"));
					boardTypeDto.setbTypeKor(rs.getString("BOARD_TYPE_KOR"));
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
	public String getbType(String bId) {
		String boardType = null;
		String sql = "SELECT BOARD_TYPE " 
				+ "FROM BOARD_TYPE " 
				+ "WHERE BOARD_ID=?";

		try {
			boardType = jdbcTemplate.queryForObject(sql, new Object[] { bId }, String.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			boardType = null;
		}

		return boardType;
	}

	@Override
	public List<String> getBoardTypeList() {
		List<String> boardTypeList = null;
		String sql = "SELECT DISTINCT BOARD_TYPE " 
				+ "FROM BOARD_TYPE";

		try {
			// query로는 매개변수에 Class<T>가 안되기때문에 queryForList를 호출하긴 했는데 써본적 없는 메소드이므로 관찰요망
			boardTypeList = jdbcTemplate.queryForList(sql, String.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			boardTypeList = null;
		}
		return boardTypeList;
	}

	@Override
	public Map<String, List<String>> getBoardIdListByType(List<String> boardTypeList) {
		Map<String, List<String>> boardIdMapByType = new HashMap<String, List<String>>();
		String sql = null;

		try {
			for (String boardType : boardTypeList) {
				sql = "SELECT BOARD_ID " 
						+ "FROM BOARD_TYPE " 
						+ "WHERE BOARD_TYPE=?";
				boardIdMapByType.put(boardType,
						jdbcTemplate.queryForList(sql, new Object[] { boardType }, String.class));
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			boardIdMapByType = null;
		}

		return boardIdMapByType;
	}
	
	

	@Override
	public Map<String, List<BoardDTO>> main(Map<String, Object> paramMap) {
		Map<String, List<BoardDTO>> resultMap = new HashMap<String, List<BoardDTO>>();
		List<String> boardTypeList = (List<String>) paramMap.put("boardTypeList", paramMap);
		
		try {
			resultMap.put("best", jdbcTemplate.query("SELECT BEST", new BoardRowMapper()));
			for (String boardType : boardTypeList) {
			}
		} catch (DataAccessException e) {
		}

		return resultMap;
	}

	
	
	@Override
	public List<BoardDTO> bestMain(List<String> boardTypeList) {
		List<BoardDTO> bestMainList=null;
		String sql = "SELECT * FROM HUMOR INNER JOIN HUMOR_INFO ON HUMOR.BOARD_INDEX=HUMOR_INFO.BOARD_INDEX WHERE HUMOR_INFO.BOARD_UPVOTE>=50 "
				+ "UNION ALL "
				+ "SELECT * FROM GAME INNER JOIN GAME_INFO ON GAME.BOARD_INDEX=GAME_INFO.BOARD_INDEX WHERE GAME_INFO.BOARD_UPVOTE>=50 "
				+ "UNION ALL "
				+ "SELECT * FROM ENTERTAINMENT INNER JOIN ENTERTAINMENT_INFO ON ENTERTAINMENT.BOARD_INDEX=ENTERTAINMENT_INFO.BOARD_INDEX WHERE ENTERTAINMENT_INFO.BOARD_UPVOTE>=50 "
				+ "UNION ALL "
				+ "SELECT * FROM SPORTS INNER JOIN SPORTS_INFO ON SPORTS.BOARD_INDEX=SPORTS_INFO.BOARD_INDEX WHERE SPORTS_INFO.BOARD_UPVOTE=50 "
				+ "ORDER BY BOARD_REGDATE ASC " 
				+ "LIMIT 1,9";

		try {
			bestMainList=jdbcTemplate.query(sql, new BoardRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
			bestMainList=null;
		}
		
		return bestMainList;
	}

	@Override
	public Map<String, List<BoardDTO>> otherMain(Map<String, List<String>> paramMap) {
		Map<String,List<BoardDTO>> resultMap=new HashMap<String,List<BoardDTO>>();
		List<String> boardTypeList=paramMap.get("boardTypeList");
		String sql=null;
		
		try {
			for(String boardType:boardTypeList) {
				sql="SELECT * "
					+ "FROM "+boardType+" "
					+ "INNER JOIN "+boardType+"_INFO "
					+ "ON "+boardType+".BOARD_INDEX="+boardType+"_INFO.BOARD_INDEX "
					+ "WHERE BOARD_ID=? "
					+ "ORDER BY "+boardType+".BOARD_INDEX ASC"
					+ "LIMIT 1,5";
					List<String> boardIdList=paramMap.get(boardType);
					for(String boardId:boardIdList) {
						resultMap.put(boardId, jdbcTemplate.query(sql,new Object[] {boardId},new BoardRowMapper()));
					}
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			resultMap=null;
		}
		
		return resultMap;
	}

	@Override
	public List<List<BoardDTO>> humorMain(List<String> boardIdList) {
		List<List<BoardDTO>> humorMainList=new ArrayList<List<BoardDTO>>();
		String sql="SELECT * "
				+ "FROM HUMOR "
				+ "INNER JOIN HUMOR_INFO "
				+ "ON HUMOR.BOARD_INDEX=HUMOR_INFO.BOARD_INDEX "
				+ "WHERE BOARD_ID=? "
				+ "ORDER BY HUMOR.BOARD_INDEX ASC"
				+ "LIMIT 1,5";
		
		try {
			for(String boardId:boardIdList) {
				humorMainList.add(jdbcTemplate.query(sql,new Object[] {boardId},new BoardRowMapper()));
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			humorMainList=null;
		}
		
		return humorMainList;
	}

	@Override
	public List<List<BoardDTO>> sportsMain(List<String> boardIdList) {
		List<List<BoardDTO>> sportsMainList=new ArrayList<List<BoardDTO>>();;
		String sql="SELECT * "
				+ "FROM SPORTS "
				+ "INNER JOIN SPORTS_INFO "
				+ "ON SPORTS.BOARD_INDEX=SPORTS_INFO.BOARD_INDEX "
				+ "WHERE BOARD_ID=? "
				+ "ORDER BY SPORTS.BOARD_INDEX ASC"
				+ "LIMIT 1,5";
		
		try {
			for(String boardId:boardIdList) {
				sportsMainList.add(jdbcTemplate.query(sql,new Object[] {boardId},new BoardRowMapper()));
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			sportsMainList=null;
		}
		
		return sportsMainList;
	}

	@Override
	public List<List<BoardDTO>> gameMain(List<String> boardIdList) {
		List<List<BoardDTO>> gameMainList=new ArrayList<List<BoardDTO>>();;
		String sql="SELECT * "
				+ "FROM GAME "
				+ "INNER JOIN GAME_INFO "
				+ "ON GAME.BOARD_INDEX=GAME_INFO.BOARD_INDEX "
				+ "WHERE BOARD_ID=? "
				+ "ORDER BY GAME.BOARD_INDEX ASC"
				+ "LIMIT 1,5";
		
		try {
			for(String boardId:boardIdList) {
				gameMainList.add(jdbcTemplate.query(sql,new Object[] {boardId},new BoardRowMapper()));
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			gameMainList=null;
		}
		
		return gameMainList;
	}

	@Override
	public List<List<BoardDTO>> entertainmentMain(List<String> boardIdList) {
		List<List<BoardDTO>> entertainmentMainList=new ArrayList<List<BoardDTO>>();;
		String sql="SELECT * "
				+ "FROM ENTERTAINMENT "
				+ "INNER JOIN ENTERTAINMENT_INFO "
				+ "ON ENTERTAINMENT.BOARD_INDEX=ENTERTAINMENT_INFO.BOARD_INDEX "
				+ "WHERE BOARD_ID=? "
				+ "ORDER BY ENTERTAINMENT.BOARD_INDEX ASC"
				+ "LIMIT 1,5";
		
		try {
			for(String boardId:boardIdList) {
				entertainmentMainList.add(jdbcTemplate.query(sql,new Object[] {boardId},new BoardRowMapper()));
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			entertainmentMainList=null;
		}
		
		return entertainmentMainList;
	}

	@Override
	public List<String> getBoardIdList() {
		List<String> boardIdList = null;
		String sql = "SELECT BOARD_ID " 
				+ "FROM BOARD_TYPE";

		try {
			// query로는 매개변수에 Class<T>가 안되기때문에 queryForList를 호출하긴 했는데 써본적 없는 메소드이므로 관찰요망
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
		;
		List<BoardDTO> boardDtoList = null;
		int limitFirst = boardDto.getPageHelper().getListFirst();
		int limitLast = boardDto.getPageHelper().getListLast();
		String sql = null;

		if (boardDto.getbId().equals("BEST")) {
			sql = "humor union game union ent union sports";

		} else {
			sql = "SELECT * " 
					+ "FROM " + boardType + " " 
					+ "INNER JOIN " + boardType + "_INFO " + "ON " + boardType
					+ ".BOARD_INDEX=" + boardType + "_INFO.BOARD_INDEX " 
					+ "WHERE BOARD_INDEX ASC " 
					+ "LIMIT ?,?";
		}

		try {
			boardDtoList = jdbcTemplate.query(sql, new Object[] { limitFirst, limitLast }, new BoardRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
			boardDtoList = null;
		}

		return boardDtoList;
	}

	@Override
	public BoardDTO content(BoardDTO boardDto) {
		String boardType = boardDto.getBoardTypeDto().getbType();
		;
		String sql = "SELECT * " 
				+ "FROM " + boardType + " " 
				+ "INNER JOIN " + boardType + "_INFO " 
				+ "ON " + boardType+ ".BOARD_INDEX=" + boardType + "_INFO.BOARD_INDEX " 
				+ "WHERE BOARD_INDEX=?";

		try {
			boardDto = jdbcTemplate.queryForObject(sql, new Object[] { boardDto.getbIdx() }, new BoardRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
			boardDto = null;
		}

		return boardDto;
	}

	@Override
	public int increaseHit(BoardDTO boardDto) {
		String boardType = boardDto.getBoardTypeDto().getbType();
		;
		int result = 0;
		String sql = "UPDATE " + boardType + "_INFO " 
				+ "SET BOARD_HIT+=1 " 
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
	public int write(BoardDTO boardDto) {
		String boardType = boardDto.getBoardTypeDto().getbType();
		;
		int result = 0;
		String sql = "INSERT " 
				+ "INTO " + boardType+ " (BOARD_INDEX,BOARD_ID,BOARD_CATEGORY,BOARD_TITLE,BOARD_CONTENT,ID,NICKNAME,BOARD_REGDATE) "
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
	public int writeInfo(BoardDTO boardDto) {
		String boardType = boardDto.getBoardTypeDto().getbType();
		;
		int result = 0;
		String sql = "INSERT " 
				+ "INTO " + boardType+ "_INFO (BOARD_INDEX,BOARD_HIT,BOARD_UPVOTE,BOARD_DOWNVOTE,BOARD_COMMENTNUM,BOARD_REPORTNUM,BOARD_BLIND,BOARD_NOTICE,BOARD_BEST)"
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
				+ "INTO BOOKMARK_BOARD (ID,BOARD_TYPE,BOARD_ID) " 
				+ "VALUES (?,?,?)";

		try {
			result = jdbcTemplate.update(sql,
					new Object[] { bookmarkBoardDto.getmId(), bookmarkBoardDto.getbType(), bookmarkBoardDto.getbId() });
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
	public List<String> getBoardCategories(BoardDTO boardDto) {
		List<String> boardCategoryList = null;
		String sql = "SELECT BOARD_CATEGORY " 
				+ "FROM BOARD_TYPE " 
				+ "WHERE BOARD_ID=?";

		try {
			boardCategoryList = jdbcTemplate.queryForList(sql, new Object[] { boardDto.getbId() }, String.class);
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
		;
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
		;
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
		;
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
	public List<BoardDTO> search(BoardDTO boardDto) {
		String boardType = boardDto.getBoardTypeDto().getbType();
		;
		List<BoardDTO> boardDtoList = null;
		String sql = "SELECT * FROM +boardType+ " + "INNER JOIN +boardType+_INFO "
				+ "ON +boardType+.BOARD_INDEX=+boardType+_INFO.BOARD_INDEX "
//				+ "WHERE LIKE=?"
				+ "LIMIT ?,?";

		try {
		} catch (DataAccessException e) {
			e.printStackTrace();
			boardDtoList = null;
		}

		return boardDtoList;
	}

	@Override
	public int bookmarkArticle(BookmarkArticleDTO bookmarkArticleDto) {
		int result = 0;
		String sql = "INSERT " 
				+ "INTO BOOKMARK_ARTICLE (BOOKMARK_INDEX,ID,BOARD_TYPE,BOARD_ID,BOARD_INDEX) "
				+ "VALUES (0,?,?,?,?)";

		try {
			result = jdbcTemplate.update(sql, new Object[] { bookmarkArticleDto.getBaIdx(), bookmarkArticleDto.getmId(),
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
				+ "WHERE ID=? AND BOOKMARK_INDEX=?";

		try {
			result = jdbcTemplate.update(sql,
					new Object[] { bookmarkArticleDto.getmId(), bookmarkArticleDto.getBaIdx() });
		} catch (DataAccessException e) {
			e.printStackTrace();
			result = -1;
		}

		return result;
	}

	@Override
	public int checkVoteArticleAlready(VoteArticleDTO voteArticleDto) {
		int result = 0;
		String sql = "SELECT COUNT(*) " 
				+ "FROM VOTE_ARTICLE " 
				+ "WHERE ID=? AND BOARD_INDEX=?";

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
	public int checkReportAlready(BoardDTO boardDto) {
		int result = 0;
		String sql = "SELECT COUNT(*) " 
				+ "FROM REPORT_ARTICLE " 
				+ "WHERE ID=? AND BOARD_INDEX=?";

		try {
			result = jdbcTemplate.queryForObject(sql, new Object[] { boardDto.getmId(), boardDto.getbIdx() },
					Integer.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			result = -1;
		}

		return result;
	}

	@Override
	public int writeReportArticle(BoardDTO boardDto) {
		String boardType = boardDto.getBoardTypeDto().getbType();
		int result = 0;
		String sql = "INSERT " 
				+ "INTO REPORT_ARTICLE (ID,BOARD_TYPE,BOARD_ID,BOARD_INDEX) " 
				+ "VALUES (?,?,?,?)";

		try {
			result = jdbcTemplate.update(sql,
					new Object[] { boardDto.getmId(), boardType, boardDto.getbId(), boardDto.getbIdx() });
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
		String sql = "UPDATE " + boardType + "_INFO " 
				+ "SET BOARD_UPVOTE+=1" 
				+ "WHERE BOARD_INDEX=?";

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
		String sql = "UPDATE " + boardType + "_INFO " 
				+ "SET BOARD_DOWNVOTE+=1" 
				+ "WHERE BOARD_INDEX=?";

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
		String sql = "INSERT " 
				+ "INTO VOTE_ARTICLE (ID,BOARD_TYPE,BOARD_ID,BOARD_INDEX,UPDOWN) "
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
	public int increaseReport(BoardDTO boardDto) {
		String boardType = boardDto.getBoardTypeDto().getbType();
		;
		int result = 0;
		String sql = "UPDATE " + boardType + "_INFO " 
				+ "SET BOARD_REPORTNUM+=1" 
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
	public int getTotalRow(BoardDTO boardDto) {
		String boardType = boardDto.getBoardTypeDto().getbType();
		int result = 0;
		String sql = "SELECT COUNT(*) " 
				+ "FROM " + boardType;

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
		String sql = "UPDATE " + boardType + "_INFO " 
				+ "SET BOARD_BEST=1 " 
				+ "WHERE BOARD_INDEX=?";

		try {
			result = jdbcTemplate.update(sql, new Object[] { voteArticleDto.getbIdx() });
		} catch (DataAccessException e) {
			e.printStackTrace();
			result = -1;
		}

		return result;
	}

}
