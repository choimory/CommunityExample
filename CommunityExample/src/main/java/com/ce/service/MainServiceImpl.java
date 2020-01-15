package com.ce.service;

import java.util.List;
import java.util.Map;

import com.ce.dao.BoardDAO;
import com.ce.dto.BoardDTO;

public class MainServiceImpl implements MainService {
	private BoardDAO boardDao;

	public void setBoardDao(BoardDAO boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public Map<String, List<BoardDTO>> main() {
		List<String> boardTypeList = null;
		Map<String, List<String>> boardIdAndTypeListMap = null;
		Map<String, List<BoardDTO>> resultMap = null;

		boardTypeList = boardDao.getBoardTypeList();
		boardIdAndTypeListMap = boardDao.getBoardIdListByType(boardTypeList);
		boardIdAndTypeListMap.put("boardTypeList", boardTypeList);

		// 메인글들 타입/게시판명별로 가져오기
		resultMap = boardDao.otherMain(boardIdAndTypeListMap);
		resultMap.put("best", boardDao.bestMain(boardTypeList));

		return resultMap;
	}

}
