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
import com.ce.dto.MemberBanDTO;
import com.ce.dto.MemberDTO;
import com.ce.dto.MemberInfoDTO;
import com.ce.dto.ShopDTO;

public class AdminServiceImpl implements AdminService {
	private MemberDAO memberDao;
	private BoardDAO boardDao;
	private ShopDAO shopDao;

	public void setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

	public void setBoardDao(BoardDAO boardDao) {
		this.boardDao = boardDao;
	}

	public void setShopDao(ShopDAO shopDao) {
		this.shopDao = shopDao;
	}

	@Override
	public Map<String, List> main() {
		Map<String, List> dtoListMap = new HashMap<String,List>();
		List<BoardDTO> boardDtoList = null;
		List<ShopDTO> shopDtoList = null;
		PageHelper pageHelper = new PageHelper();

		// checkItem 최신글, checkReport 최신글 5개정도 가져오기
		boardDtoList = boardDao.reportList(pageHelper);
		shopDtoList = shopDao.waitingPermissionList(pageHelper);
		dtoListMap.put("boardDtoList", boardDtoList);
		dtoListMap.put("shopDtoList", shopDtoList);

		return dtoListMap;
	}

	@Override
	public int ban(MemberBanDTO memberBanDto) {
		int result = 0;

		// id를 받아서 ban값을 true로 바꾸고 endtoban을 입력
		if (memberBanDto.getmBan() == 1) {
			result = memberDao.ban(memberBanDto);
		} else if (memberBanDto.getmBan() == 0) {
			// ban해제 메소드
		}

		return result;
	}

	@Override
	public List<BoardDTO> checkReport(PageHelper pageHelper) {
		List<BoardDTO> boardDtoList = null;

		// blind가 false인 글들중 report개수가 n개 이상인 글들을 page를 이용해 최신순 20개 select
		boardDtoList = boardDao.reportList(pageHelper);

		return boardDtoList;
	}

	@Override
	public List<ShopDTO> checkItem(PageHelper pageHelper) {
		List<ShopDTO> shopDtoList = null;

		// shop테이블의 permission이 false인 글들을 page를 이용해 최신순 20개 select select
		shopDtoList=shopDao.waitingPermissionList(pageHelper);

		return shopDtoList;
	}

	@Override
	public int permissionItem(int sIdx) {
		int result = 0;

		// 해당sIdx의 permission값을 true로 변경
		result = shopDao.permission(sIdx);

		return result;
	}

	@Override
	public int createBoard(BoardTypeDTO boardTypeDto) {
		int result = 0;

		// 1. 중복되지 않은 bType입력시 BOARD_TYPE에 row insert, 해당 타입의 게시판,댓글게시판,파일게시판 생성
		// 2. 1은 중복인데 bId는 중복이 아닐시 해당 bType에 속하는 새로운 게시판을 생성
		// 3. 2은 중복인데 bCategory는 중복이 아닐시 해당게시판의 새로운 카테고리를 생성
		boardDao.createBoard(boardTypeDto);

		return result;
	}

	@Override
	public int blind(BoardDTO boardDto) {
		int result = 0;
		BoardTypeDTO boardTypeDto = null;

		// bId로 bType얻기
		boardTypeDto = boardDao.getBoardType(boardDto);
		boardDto.setBoardTypeDto(boardTypeDto);
		// 해당 테이블의 bIdx글의 blind를 기존과 다르게 변경
		result=boardDao.blind(boardDto);

		return result;
	}

}
