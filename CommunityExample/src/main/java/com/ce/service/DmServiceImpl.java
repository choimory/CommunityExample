package com.ce.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ce.component.PageHelper;
import com.ce.component.SearchHelper;
import com.ce.dao.DmDAO;
import com.ce.dao.MemberDAO;
import com.ce.dto.DmDTO;
import com.ce.dto.MemberDTO;

public class DmServiceImpl implements DmService {
	private DmDAO dmDao;
	private MemberDAO memberDao;
	private final int SUCCESS = 1;
	private final int FAIL = -1;


	public void setDmDao(DmDAO dmDao) {
		this.dmDao = dmDao;
	}

	public void setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

	private int stringIdxToInteger(String index) {
		int result = 0;
		try {
			result = Integer.parseInt(index);
		} catch (NumberFormatException ne) {
			result = -1;
		}
		return result;
	}

	@Override
	public List<DmDTO> list(MemberDTO memberDto, PageHelper pageHelper, SearchHelper searchHelper) {
		List<DmDTO> dmDtoList = null;
		DmDTO dmDto=new DmDTO();
		
		pageHelper.list();
		pageHelper.pagination2(dmDao.getTotalRow(memberDto.getmId()));
		dmDto.setPageHelper(pageHelper);
		dmDto.setSearchHelper(searchHelper);
		dmDto.setDmReceiverId(memberDto.getmId());
	
		// dmReceiverId를 대상으로 page를 이용해 최신순 20개 select
		dmDtoList = dmDao.list(dmDto);
		
		return dmDtoList;
	}

	@Override
	public Map<String,Object> content(String stringDmIdx, PageHelper pageHelper) {
		Map<String,Object> resultMap=null;
		List<DmDTO> dmDtoList=null;
		DmDTO dmDto = null;
		int dmIdx = 0;

		if (stringIdxToInteger(stringDmIdx) != FAIL) {
			dmIdx=stringIdxToInteger(stringDmIdx);
			dmDto = dmDao.content(dmIdx);
			// receiveDate값이 없을시 receiveDate를 현재날짜로 수정
			if (dmDto.getDmReceiveDate().equals(dmDto.getDmSendDate())) {
				dmDao.firstRead(dmIdx);
				dmDto = dmDao.content(dmIdx);
			}
			resultMap=new HashMap<String,Object>();
			dmDto.setPageHelper(pageHelper);
			dmDtoList=dmDao.list(dmDto);
			resultMap.put("dmDto", dmDto);
			resultMap.put("dmDtoList", dmDtoList);
		}

		return resultMap;
	}

	@Override
	public int write(DmDTO dmDto) {
		int result = 0;

		 //회원의 닉네임으로 mId얻기
		dmDto.setDmReceiverId(memberDao.changeNicknameToId(dmDto.getDmReceiverNickname()));
		 result=dmDao.write(dmDto);
		 if(result!=SUCCESS) {
			 result=FAIL;
		 }

		return result;
	}

	@Override
	public List<DmDTO> search(DmDTO dmDto, SearchHelper searchHelper, PageHelper pageHelper) {
		pageHelper.list();
		pageHelper.pagination2(dmDao.getTotalRow(dmDto.getDmReceiverId()));
		dmDto.setSearchHelper(searchHelper);
		dmDto.setPageHelper(pageHelper);
		List<DmDTO> dmDtoList = null;

		// query와 target과 page를 이용해 검색한 결과 뿌리기
		 dmDtoList=dmDao.search(dmDto);

		return dmDtoList;
	}

	@Override
	public int delete(int dmIdx) {
		int result = 0;

		 result=dmDao.delete(dmIdx);
		 if(result!=SUCCESS) {
			 result=FAIL;
		 }

		return result;
	}

}
