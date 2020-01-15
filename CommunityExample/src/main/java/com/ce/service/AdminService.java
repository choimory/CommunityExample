package com.ce.service;

import java.util.List;
import java.util.Map;

import com.ce.component.PageHelper;
import com.ce.dto.BoardDTO;
import com.ce.dto.BoardTypeDTO;
import com.ce.dto.MemberBanDTO;
import com.ce.dto.ShopDTO;

public interface AdminService {
	  public int ban(MemberBanDTO memberBanDto); //해당 ID의 ENDTOBAN 컬럼 값 변경
	  public List<BoardDTO> checkReport(PageHelper pageHelper); //report개수가 높은 글들을 select
	  public List<ShopDTO> checkItem(PageHelper pageHelper); //판매허가 대기중인 shop글들을 select
	  public int permissionItem(int sIdx); //해당index의 permission 컬럼 값을 변경
	  public int createBoard(BoardTypeDTO boardTypeDto); //타입,게시판명,카테고리를 받아 
	  public int blind(BoardDTO boardDto); //idx를 받아 해당 row의 blind컬럼값 변경
	  public Map<String, List> main(); //checkItem 최신글, checkReport 최신글 5개정도 가져오기 
}
