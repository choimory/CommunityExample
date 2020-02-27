package com.ce.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.ce.component.PageHelper;
import com.ce.component.SearchHelper;
import com.ce.dao.DmDAO;
import com.ce.dao.MemberDAO;
import com.ce.dto.DmDTO;
import com.ce.dto.DmFileDTO;
import com.ce.dto.MemberDTO;

public class DmServiceImpl implements DmService {
	private static final Logger log = LoggerFactory.getLogger(DmServiceImpl.class);
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

	private int fileUpload(List<MultipartFile> files, int dmIdx) {
		int result = 0;
		String filePath = "C:\\choimory_IDE\\Java\\Workspace\\choimory_workspace-CommunityExample\\file repository\\dm\\";
		DmFileDTO dmFileDto = null;
		BufferedOutputStream output = null;
		String fOriginalName = null;
		String fStoredName = null;
		byte[] fileBytes = null;

		if (!files.isEmpty()) {
			for (MultipartFile file : files) {
				try {
					fOriginalName = file.getOriginalFilename();
					fStoredName = dmIdx + "_" + file.getOriginalFilename();
					fileBytes = file.getBytes();

					output = new BufferedOutputStream(new FileOutputStream(new File(filePath, fStoredName)));
					output.write(fileBytes);
					output.close();

					dmFileDto = new DmFileDTO(dmIdx, fOriginalName, fStoredName, file.getSize());
					dmDao.insertDmFile(dmFileDto);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					result = -1;
				} catch (IOException e) {
					e.printStackTrace();
					result = -1;
				}
			}
		}

		return result;
	}

	@Override
	public Map<String, Object> list(MemberDTO memberDto, PageHelper pageHelper, SearchHelper searchHelper) {
		Map<String,Object> resultMap=new HashMap<String,Object>();
		List<DmDTO> dmDtoList = null;
		DmDTO dmDto = new DmDTO();

		pageHelper.paging(dmDao.getTotalRow(memberDto.getmId()));
		dmDto.setPageHelper(pageHelper);
		dmDto.setSearchHelper(searchHelper);
		dmDto.setDmReceiverId(memberDto.getmId());

		// dmReceiverId를 대상으로 page를 이용해 최신순 20개 select
		dmDtoList = dmDao.list(dmDto);

		resultMap.put("dmDtoList", dmDtoList);
		resultMap.put("pageHelper", pageHelper);
		return resultMap;
	}

	@Override
	public Map<String, Object> content(String stringDmIdx, PageHelper pageHelper,SearchHelper searchHelper) {
		Map<String, Object> resultMap = null;
		List<DmDTO> dmDtoList = null;
		DmDTO dmDto = null;
		List<DmFileDTO> dmFileDtoList = null;
		int dmIdx = 0;

		if (stringIdxToInteger(stringDmIdx) != FAIL) {
			dmIdx = stringIdxToInteger(stringDmIdx);
			dmDto = dmDao.content(dmIdx);
			// receiveDate값이 없을시 receiveDate를 현재날짜로 수정
			if (dmDto.getDmReceiveDate().equals(dmDto.getDmSendDate())) {
				dmDao.firstRead(dmIdx);
				dmDto = dmDao.content(dmIdx);
			}
			dmFileDtoList = dmDao.contentFile(dmIdx);
			dmDto.setDmFileDtoList(dmFileDtoList);

			resultMap = new HashMap<String, Object>();
			pageHelper.paging(dmDao.getTotalRow(dmDto.getDmReceiverId()));
			dmDto.setPageHelper(pageHelper);
			dmDto.setSearchHelper(searchHelper);
			dmDtoList = dmDao.list(dmDto);
			
			resultMap.put("dmDto", dmDto);
			resultMap.put("dmDtoList", dmDtoList);
			resultMap.put("pageHelper", pageHelper);			
		}

		return resultMap;
	}

	@Override
	public FileInputStream download(String fStoredName) {
		String filePath = "C:\\choimory_IDE\\Java\\Workspace\\choimory_workspace-CommunityExample\\file repository\\dm\\" + fStoredName;
		File file = new File(filePath);
		FileInputStream input = null;

		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			input = null;
		}

		return input;
	}

	@Override
	public int write(DmDTO dmDto, List<MultipartFile> files) {
		int result = 0;

		// 회원의 닉네임으로 mId얻기
		dmDto.setDmReceiverId(memberDao.changeNicknameToId(dmDto.getDmReceiverNickname()));
		result = dmDao.write(dmDto);
		if (result == SUCCESS) {
			if (files.get(0).getSize() != 0) {
				result = fileUpload(files, dmDao.getLatestIndex(dmDto));
			}
			if (result != SUCCESS) {
				result = FAIL;
			}
		}

		return result;
	}

	@Override
	public int delete(int dmIdx) {
		int result = 0;

		result = dmDao.delete(dmIdx);
		if (result != SUCCESS) {
			result = FAIL;
		}

		return result;
	}

}
