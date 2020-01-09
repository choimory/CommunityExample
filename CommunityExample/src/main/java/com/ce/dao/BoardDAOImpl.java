package com.ce.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
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
		String boardId = null;
		String sql = "";
		List<BoardDTO> boardDtoList=null;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return boardDtoList;
	}

	@Override
	public List<BoardDTO> reportList(PageHelper pageHelper) {
		String boardId = null;
		String sql = "";
		List<BoardDTO> boardDtoList=null;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return boardDtoList;
	}

	@Override
	public List<BoardDTO> reportList(Map<String, Object> paramMap) {
		String boardId = null;
		String sql = "";
		List<BoardDTO> boardDtoList=null;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return boardDtoList;
	}

	@Override
	public int createBoard(BoardTypeDTO boardTypeDto) {
		String boardId = null;
		String sql = "";
		int result=0;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return result;
	}

	@Override
	public int blind(BoardDTO boardDto) {
		String boardType=boardDto.getBoardTypeDto().getbType();
		String sql = "UPDATE "+boardType+" SET BOARD_BLIND=? WHERE BOARD_INDEX=?";
		int result=0;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return result;
	}

	@Override
	public BoardTypeDTO getBoardType(BoardTypeDTO boardTypeDto) {
		String boardId = null;
		String sql = "";
		
		try {
		} catch (DataAccessException e) {
		}
		
		return boardTypeDto;
	}

	@Override
	public BoardTypeDTO getBoardType(BoardDTO boardDto) {
		String boardId = null;
		String sql = "";
		BoardTypeDTO boardTypeDto=null;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return boardTypeDto;
	}

	@Override
	public BoardTypeDTO getBoardType(BoardCommentDTO boardCommentDto) {
		String boardId = null;
		String sql = "";
		BoardTypeDTO boardTypeDto=null;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return boardTypeDto;
	}

	@Override
	public BoardTypeDTO getBoardType(String bId) {
		String boardId = null;
		String sql = "";
		BoardTypeDTO boardTypeDto=null;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return boardTypeDto;
	}

	@Override
	public String getbType(String bId) {
		String boardId = null;
		String sql = "";
		String bType=null;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return bType;
	}

	@Override
	public Map<String, List<BoardDTO>> main() {
		String boardId = null;
		String sql = "";
		Map<String,List<BoardDTO>> resultMap=null;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return resultMap;
	}

	@Override
	public List<BoardDTO> list(BoardDTO boardDto) {
		String boardId = null;
		String sql = "";
		List<BoardDTO> boardDtoList=null;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return boardDtoList;
	}

	@Override
	public List<String> getBoardIdList() {
		String boardId = null;
		String sql = "";
		List<String> boardIdList=null;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return boardIdList;
	}

	@Override
	public BoardDTO content(BoardDTO boardDto) {
		String boardId = null;
		String sql = "";
		
		try {
		} catch (DataAccessException e) {
		}
		
		return boardDto;
	}

	@Override
	public int write(BoardDTO boardDto) {
		String boardId = null;
		String sql = "";
		int result=0;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return result;
	}

	@Override
	public int writeInfo(BoardDTO boardDto) {
		String boardId = null;
		String sql = "";
		int result=0;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return result;
	}

	@Override
	public int bookmarkBoard(BookmarkBoardDTO bookmarkBoardDto) {
		String boardId = null;
		String sql = "";
		int result=0;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return result;
	}

	@Override
	public List<String> getBoardCategories(BoardDTO boardDto) {
		String boardId = null;
		String sql = "";
		List<String> boardCategoryList=null;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return boardCategoryList;
	}

	@Override
	public int modifyBoard(BoardDTO boardDto) {
		String boardId = null;
		String sql = "";
		int result=0;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return result;
	}

	@Override
	public int modifyBoardInfo(BoardDTO boardDto) {
		String boardId = null;
		String sql = "";
		int result=0;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return result;
	}

	@Override
	public int modifyBoardFile(BoardDTO boardDto) {
		String boardId = null;
		String sql = "";
		int result=0;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return result;
	}

	@Override
	public int deleteBoard(BoardDTO boardDto) {
		String boardId = null;
		String sql = "";
		int result=0;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return result;
	}

	@Override
	public int deleteBoardInfo(BoardDTO boardDto) {
		String boardId = null;
		String sql = "";
		int result =0;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return result;
	}

	@Override
	public int deleteBoardFile(BoardDTO boardDto) {
		String boardId = null;
		String sql = "";
		int result=0;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return result;
	}

	@Override
	public List<BoardDTO> search(BoardDTO boardDto) {
		String boardId = null;
		String sql = "";
		List<BoardDTO> boardDtoList=null;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return boardDtoList;
	}

	@Override
	public int bookmarkArticle(BookmarkArticleDTO bookmarkArticleDto) {
		String boardId = null;
		String sql = "";
		int result=0;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return result;
	}

	@Override
	public int checkVoteArticleAlready(VoteArticleDTO voteArticleDto) {
		String boardId = null;
		String sql = "";
		int result=0;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return result;
	}

	@Override
	public int updateVoteNum(VoteArticleDTO voteArticleDto) {
		String boardId = null;
		String sql = "";
		int result=0;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return result;
	}

	@Override
	public int writeVoteInfo(VoteArticleDTO voteArticleDto) {
		String boardId = null;
		String sql = "";
		int result=0;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return result;
	}

	@Override
	public int checkReportAlready(BoardDTO boardDto) {
		String boardId = null;
		String sql = "";
		int result=0;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return result;
	}

	@Override
	public int updateReportNum(BoardDTO boardDto) {
		String boardId = null;
		String sql = "";
		int result=0;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return result;
	}

	@Override
	public int writeReportArticle(BoardDTO boardDto) {
		String boardId = null;
		String sql = "";
		int result=0;
		
		try {
		} catch (DataAccessException e) {
		}
		
		return result;
	}

}
