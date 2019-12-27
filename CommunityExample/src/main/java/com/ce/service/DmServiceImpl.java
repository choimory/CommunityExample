package com.ce.service;

import java.util.List;

import com.ce.component.PageHelper;
import com.ce.component.SearchHelper;
import com.ce.dao.DmDAO;
import com.ce.dto.DmDTO;
import com.ce.dto.MemberDTO;

public class DmServiceImpl implements DmService {
	private DmDAO dmDao;
	private final int SUCCESS = 1;
	private final int FAIL = -1;

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
	public List<DmDTO> list(String mId,DmDTO dmDto, PageHelper pageHelper) {
		List<DmDTO> dmDtoList = null;
		dmDto.setPageHelper(pageHelper);
		dmDto.setDmReceiverId(mId);
	
		// dmReceiverId를 대상으로 page를 이용해 최신순 20개 select
		dmDtoList = dmDao.list(dmDto);

		return dmDtoList;
	}

	@Override
	public DmDTO content(String stringDmIdx) {
		DmDTO dmDto = null;
		int dmIdx = 0;

		if (stringIdxToInteger(stringDmIdx) != FAIL) {
			dmIdx=stringIdxToInteger(stringDmIdx);
			dmDto = dmDao.content(dmIdx);
			// receivedate값이 없을시 receivedate를 현재날짜로 수정
			if (dmDto.getDmReceiveDate() == null) {
				dmDao.firstRead(dmIdx);
			}
		}

		return dmDto;
	}

	@Override
	public int write(MemberDTO memberDto,DmDTO dmDto) {
		int result = 0;

		 result=dmDao.write(dmDto);

		return result;
	}

	@Override
	public List<DmDTO> search(String mId, DmDTO dmDto, SearchHelper searchHelper, PageHelper pageHelper) {
		dmDto.setDmReceiverId(mId);
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

		return result;
	}

}
