package com.ce.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ce.component.PageHelper;
import com.ce.dao.BoardDAO;
import com.ce.dao.MemberDAO;
import com.ce.dao.ShopDAO;
import com.ce.dto.BoardCategoryDTO;
import com.ce.dto.BoardDTO;
import com.ce.dto.BoardTypeDTO;
import com.ce.dto.MemberBanDTO;
import com.ce.dto.MemberDTO;
import com.ce.dto.MemberInfoDTO;
import com.ce.dto.ShopDTO;
import com.ce.dto.ShopInfoDTO;

public class AdminServiceImpl implements AdminService {
	private MemberDAO memberDao;
	private BoardDAO boardDao;
	private ShopDAO shopDao;
	private final int SUCCESS=1;
	private final int FAIL=-1;
	
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
		Map<String, List> dtoListMap = new HashMap<String, List>();
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
			result=memberDao.unBan(memberBanDto.getmId());
		}

		return result;
	}

	@Override
	public List<BoardDTO> checkReport(PageHelper pageHelper) {
		List<BoardDTO> boardDtoList = null;

		// blind가 false인 글들중 report개수가 n개 이상인 글들을 page를 이용해 최신순 20개 select
		pageHelper.paging(boardDao.getTotalRowReportList());
		boardDtoList = boardDao.reportList(pageHelper);

		return boardDtoList;
	}

	@Override
	public List<ShopDTO> checkItem(PageHelper pageHelper) {
		List<ShopDTO> shopDtoList = null;

		// shop테이블의 permission이 false인 글들을 page를 이용해 최신순 20개 select select
		pageHelper.paging(shopDao.getTotalRowWaitingPermission());
		shopDtoList = shopDao.waitingPermissionList(pageHelper);

		return shopDtoList;
	}

	@Override
	public int permissionItem(int sIdx, int sPermission) {
		int result = 0;
		ShopInfoDTO shopInfoDto=new ShopInfoDTO();
		
		
		// 해당sIdx의 permission값을 변경
		shopInfoDto.setsIdx(sIdx);
		shopInfoDto.setsPermission(sPermission);
		result = shopDao.permission(shopInfoDto);

		return result;
	}

	@Override
	public List<String> createBoardGet() {
		List<String> boardTypeKorList=null;
		
		//boardTypeList를 중복제거하고 가져와서 리턴
		boardTypeKorList=boardDao.getBoardTypeList();
		
		return boardTypeKorList;
	}

	@Override
	public int createBoardPost(BoardTypeDTO boardTypeDto) {
		int result = 0;
		
		//입력된 btypekor으로 btype가져오기
		boardTypeDto.setbType(boardDao.changeBoardTypeKorToEng(boardTypeDto.getbTypeKor()));
		// bType, bId, bIdKor, bIntroduce를 BOARD_TYPE테이블에 insert
		boardTypeDto.toString();
		result=boardDao.createBoard(boardTypeDto);
		
		if(result!=SUCCESS) {
			result=FAIL;
		}

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
		result = boardDao.blind(boardDto);

		return result;
	}

	@Override
	public int createBoardTypePost(BoardTypeDTO boardTypeDto) {
		// BOARD_TYPE게시판에 새로운 BOARD_TYPE, BOARD_ID, BOARD_INTRODUCE insert
		// CREATE TABLE, TABLE_INFO, TABLE_COMMENT, TABLE_COMMENT_INFO
		// with FK설정
		return 0;
	}

	@Override
	public List<String> addBoardCategoryGet() {
		List<String> bIdKor=null;
		
		// SELECT BID FROM BOARD_TYPE
		bIdKor=boardDao.getBoardIdKorList();
		
		return bIdKor;
	}

	@Override
	public int addBoardCategoryPost(String bIdKor, String bCategory) {
		int result=0;
		BoardCategoryDTO boardCategoryDto=new BoardCategoryDTO();
		
		//bIdKor을 bId로 변경
		boardCategoryDto.setbId(boardDao.changeBoardIdKorToEng(bIdKor));
		boardCategoryDto.setbCategory(bCategory);
		// insert into BOARD_CATEGORY values BOARD_ID, BOARD_CATEGORY 
		result=boardDao.addCategory(boardCategoryDto);
		
		return result;
	}

}
