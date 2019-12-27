package com.ce.service;

import java.util.List;
import java.util.Map;

import com.ce.dao.BoardDAO;
import com.ce.dto.BoardDTO;

public class MainServiceImpl implements MainService{
	private BoardDAO boardDao;
	
	
	@Override
	public Map<String, List<BoardDTO>> main() {
		Map<String, List<BoardDTO>> dtoListMap=null;
		
		//게시판의 최신글들 가져오기
		dtoListMap=boardDao.main();
		
		return dtoListMap;
	}

}
