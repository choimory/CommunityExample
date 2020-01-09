package com.ce.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import com.ce.component.hash.HashHelper;
import com.ce.dao.MemberDAO;
import com.ce.dao.ShopDAO;
import com.ce.dto.MemberAuthDTO;
import com.ce.dto.MemberDTO;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDao;
	private ShopDAO shopDao;
	@Resource(name="hashHelper")
	private HashHelper hashHelper;
	private final int SUCCESS = 1;
	private final int FAIL = -1;

	public void setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

	public void setShopDao(ShopDAO shopDao) {
		this.shopDao = shopDao;
	}

	public void setHashHelper(HashHelper hashHelper) {
		this.hashHelper = hashHelper;
	}

	@Override
	public int idCheck(String mId) {
		int result = 0;

		// 받은 id로 검색해서 데이터 유무 확인
		result = memberDao.idCheck(mId);

		return result;
	}

	@Override
	public int emailCheck(String mEmail) {
		int result = 0;

		// 받은 email로 검색해서 데이터 유무 확인
		result = memberDao.emailCheck(mEmail);

		return result;
	}

	@Override
	public MemberDTO join(MemberDTO memberDto) {
		int result = 0;

		// 1.mPassword 해쉬화
		memberDto.setmPassword(hashHelper.hashByBCrypt(memberDto.getmPassword()));
		// 2.insert
		result = memberDao.join(memberDto);
		if (result == FAIL) {
			memberDto = null;
		} else if (result == SUCCESS) {
			result=memberDao.insertMemberInfo(memberDto);
			// 3. insert한 memberDto 받아오기
			memberDto = memberDao.getMemberDto(memberDto.getmId());
		}

		return memberDto;
	}

	@Override
	public int findAccount(String mEmail) {
		int result = 0;
		int randomPassword = 0;
		String hashedPassword = null;
		Random random = new Random();
		MemberDTO memberDto = new MemberDTO();

		// 1.변경할 무작위수 생성
		randomPassword = random.nextInt(1000000);
		// 2.해당 무작위수 해쉬화
		hashedPassword = hashHelper.hashByBCrypt(randomPassword + "");
		// 3. mdto에 주입
		memberDto.setmEmail(mEmail);
		memberDto.setmPassword(hashedPassword);
		// 4.해싱한 비밀번호로 변경
		result = memberDao.findAccount(memberDto);
		// TODO 5.변경한 비밀번호 email로 전송

		return result;
	}

	@Override
	public MemberDTO login(MemberDTO memberDto) {
		boolean result = false;
		String hashedPassword = null;

		// 1.form에서 입력한 mId를 조건으로 db에서 pw만 가져오기
		// TODO id로 검색한 결과가 없을때 hashedPassword에 반환될 값은??
		hashedPassword = memberDao.getPassword(memberDto.getmId());
		// 2.form에서 넘어온 pw와 db의 pw를 해싱컴포넌트에서 비교
		if (!hashedPassword.equals("1이 실패시 저장될값")) {
			result = hashHelper.matchByBCrypt(memberDto.getmPassword(), hashedPassword);
			// 3.비밀번호 일치시 memberDto 가져오기
			if (result) {
				memberDto = memberDao.getMemberDto(memberDto.getmId());
			} else {
				memberDto = null;
			}
		}

		return memberDto;
	}

	@Override
	public Map<String, Object> memberInfo(String mId) {
		Map<String, Object> dtoMap = new HashMap<String, Object>();

		// 세션의 id에 해당하는 회원 정보들 가져오기(회원정보, 보유아이콘, 아이콘 위시리스트, 즐겨찾기한 게시판, 즐겨찾기한 게시물,)
		dtoMap.put("memberDto", memberDao.getMemberDto(mId));
		dtoMap.put("memberItemDto", memberDao.getMemberItem(mId));
		dtoMap.put("wishListDto", shopDao.getWishlistDTO(mId));
		dtoMap.put("bookmarkBoardDto", memberDao.getBookmarkBoardDTO(mId));
		dtoMap.put("bookmarkArticleDto", memberDao.getBookmarkArticleDTO(mId));
		// TODO map에 넣은 dto중 null이 있는지 확인하고 하나라도 null이 있으면 map자체를 null로 변경
//		dtoMap.keySet().iterator();

		return dtoMap;
	}

	@Override
	public int modifyInfo(MemberDTO memberDto) {
		int result = 0;

		// 입력한 값으로 해당회원 정보수정
//		result=memberDao.modifyInfo(memberDto);

		return result;
	}

	@Override
	public int withdraw(MemberDTO memberDto) {
		int result = 0;
		String hashedPassword = null;

		// 1.mId를 조건으로 db에서 pw만 가져오기
		// TODO 검색결과가 없을때 hashedPassword에 반환될 값은??
		hashedPassword = memberDao.getPassword(memberDto.getmId());
		// 2.입력한 pw와 db의 pw를 해싱컴포넌트에서 비교
		if (!hashedPassword.equals("1의 결과가 없을때 저장될 값")) {
			if (hashHelper.matchByBCrypt(memberDto.getmPassword(), hashedPassword)) {
				// 3.해당 회원에 관련된 기본정보 삭제
				result = memberDao.deleteMember(memberDto);
				if (result == SUCCESS) {
					memberDao.deleteMemberInfo(memberDto);
				}
			}
		}

		return result;
	}

	/*
	 * @Override public int auth(MemberAuthDTO memberAuthDto) { int result=0;
	 * 
	 * //입력한 인증키를 테이블상의 인증키와 대조해보고 알맞을경우 진행, 아닐경우 빠꾸
	 * 
	 * return result; }
	 */
}
