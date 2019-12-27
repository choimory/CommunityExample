package com.ce.service;

import java.util.List;
import java.util.Map;

import com.ce.dto.BoardDTO;


public interface MainService {
	 public Map<String, List<BoardDTO>> main(); //게시판의 최신글들 가져오기
}
