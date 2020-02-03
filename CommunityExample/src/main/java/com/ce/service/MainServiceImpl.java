package com.ce.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ce.dao.BoardDAO;
import com.ce.dto.BoardDTO;
import com.ce.dto.BoardTypeDTO;

public class MainServiceImpl implements MainService {
	private BoardDAO boardDao;
	private static final Logger log = LoggerFactory.getLogger(MainServiceImpl.class);

	public void setBoardDao(BoardDAO boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public Map<String, Object> main() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> bestMap = new HashMap<String, Object>();
		Map<String, Object> otherMap = new HashMap<String, Object>();
		List<String> bTypeList = null;
		Map<String, List<String>> bIdListMap = new HashMap<String, List<String>>();

		log.debug("main();");
		// 게시판타입 목록 가져오기
		bTypeList = boardDao.getBoardTypeList();
		// 게시판타입별 게시판목록 가져오기
		for (String bType : bTypeList) {
			bIdListMap.put(bType, boardDao.getBoardIdListByType(bType));
		}
		// 게시판별 글목록 가져오기
		bestMap.put("best", boardDao.bestMain());
		for (String bType : bTypeList) { // 게시판타입 분류
			List<String> bIdList = bIdListMap.get(bType);
			for (String bId : bIdList) { // 게시판타입별 게시판 분류
				// boardDto세팅
				BoardDTO boardDto = new BoardDTO();
				BoardTypeDTO boardTypeDto = new BoardTypeDTO();
				boardDto.setbId(bId);
				boardTypeDto.setbType(bType);
				boardDto.setBoardTypeDto(boardTypeDto);
				// id별 글목록 가져와 map에 담기
				if (!bId.equals("best")) { // best는 제외
					if (bId.equals("humor") || bId.equals("issue")) { //humor와 issue도 제외
						bestMap.put(bId, boardDao.otherMain(boardDto));
					} else {
						otherMap.put(bId, boardDao.otherMain(boardDto));
					}
				}
			}
		}
		// TODO 전체 null체크

		resultMap.put("bestMap", bestMap);
		resultMap.put("otherMap", otherMap);
		return resultMap;
	}

}
