package com.ce.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ce.component.PageHelper;
import com.ce.dao.BoardDAO;
import com.ce.dao.MemberDAO;
import com.ce.dao.ShopDAO;
import com.ce.dto.BoardDTO;
import com.ce.dto.BoardTypeDTO;
import com.ce.dto.MemberDTO;
import com.ce.dto.MemberInfoDTO;
import com.ce.dto.ShopDTO;

public class AdminServiceImpl implements AdminService{
	private MemberDAO memberDao;
	private BoardDAO boardDao;
	private ShopDAO shopDao;
	
	@Override
	public int ban(MemberDTO memberDto, MemberInfoDTO memberInfoDto) {
		int result=0;
		memberDto.setMemberInfoDto(memberInfoDto);
		
		//id를 받아서 ban값을 true로 바꾸고 endtoban을 입력
		result=memberDao.ban(memberDto);
		
		return result;
	}

	@Override
	public List<BoardDTO> checkReport(PageHelper pageHelper) {
		List<BoardDTO> boardDtoList = null;
		Map<String,Object> paramMap=new HashMap<String,Object>();
		int minimumReportNum=50;
		
		//blind가 false인 글들중 report개수가 n개 이상인 글들을 page를 이용해 최신순 20개 select 
		//TODO 모든게시판을 탐색해야 하는 문제 -> mysql union 활용
		paramMap.put("pageHelper", pageHelper);
		paramMap.put("reportNum", minimumReportNum);
		boardDtoList=boardDao.reportList(pageHelper); 
		
		return boardDtoList;
	}

	@Override
	public List<ShopDTO> checkItem(PageHelper pageHelper) {
		List<ShopDTO> shopDtoList=null;
		
		//shop테이블의 permission이 false인 글들을 page를 이용해 최신순 20개 select  select
		shopDao.waitingPermissionList(pageHelper);

		return shopDtoList;
	}

	@Override
	public int permissionItem(int sIdx) {
		int result=0;
		
		//해당sIdx의 permission값을 true로 변경
		result=shopDao.permission(sIdx);

		return result;
	}

	@Override
	public int createBoard(BoardTypeDTO boardTypeDto) {
		int result=0;
		
		//1. 중복되지 않은 bType입력시 BOARD_TYPE에 row insert, 해당 타입의 게시판,댓글게시판,파일게시판 생성
		//2. 1은 중복인데 bId는 중복이 아닐시 해당 bType에 속하는 새로운 게시판을 생성
		//3. 2은 중복인데 bCategory는 중복이 아닐시 해당게시판의 새로운 카테고리를 생성 
		boardDao.createBoard(boardTypeDto);

		return result;
	}

	@Override
	public int blind(BoardDTO boardDto) {
		int result=0;
		BoardTypeDTO boardTypeDto = null;
		
		//bId로 bType얻기
		boardTypeDto=boardDao.getBoardType(boardDto);
		boardDto.setBoardTypeDto(boardTypeDto);
		//해당 테이블의 bIdx글의 blind를 기존과 다르게 변경
		boardDao.blind(boardDto);
		
		return result;
	}

	@Override
	public Map<String, Object> main() {
		Map<String, Object> dtoListMap = null;
		List<BoardDTO> boardDtoList=null;
		List<ShopDTO> shopDtoList=null;
		
		//checkItem 최신글, checkReport 최신글 5개정도 가져오기
		boardDtoList=boardDao.reportList(); // TODO 모든게시판을 탐색해야 하는 문제
		shopDtoList=shopDao.waitingPermissionList();
		dtoListMap.put("boardDtoList", boardDtoList);
		dtoListMap.put("shopDtoList", shopDtoList);
		
		return dtoListMap;
	}

}
