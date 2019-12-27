package com.ce.service;

import java.util.HashMap;
import java.util.Map;

import com.ce.dao.MemberDAO;
import com.ce.dao.ShopDAO;
import com.ce.dto.MemberAuthDTO;
import com.ce.dto.MemberDTO;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDao;
	private ShopDAO shopDao;
	private final int SUCCESS = 1;
	private final int FAIL = -1;

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

		// TODO 1.mPassword 해쉬화
		// 2.insert
		result = memberDao.join(memberDto);
		if (result == FAIL) {
			memberDto = null;
		} else if (result == SUCCESS) {
			// 3. insert한 memberDto 받아오기
			memberDto = memberDao.getMemberDto(memberDto);
		}

		return memberDto;
	}

	@Override
	public int findAccount(String mEmail) {
		int result = 0;
		int randomPassword = 0;
		MemberDTO memberDto = new MemberDTO();

		//TODO
		// 1.변경할 무작위수 생성
		// 2.해당 무작위수 해쉬화
		// 3. mdto에 주입
		// 4.해싱한 비밀번호로 변경
		result=memberDao.findAccount(memberDto);
		// 5.변경한 비밀번호 email로 전송

		return result;
	}

	@Override
	public MemberDTO login(MemberDTO memberDto) {
		int result = 0;
		String hashedPassword = null;

		// 1.form에서 입력한 mId를 조건으로 db에서 pw만 가져오기
//		hashedPassword=memberDao.getPassword(memberDto.getmId());
		// TODO 2.form에서 넘어온 pw와 db의 pw를 해싱컴포넌트에서 비교
//		result=
		// 3.비밀번호 일치시 memberDto 가져오기
//		if(result==1){
//			memberDto=memberDao.getMemberDto(memberDto);
//		}else{
//			memberDto=null;
//		}

		return memberDto;
	}

	@Override
	public Map<String, Object> memberInfo(String mId) {
		Map<String, Object> dtoMap = new HashMap<String,Object>();

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
//		hashedPassword=memberDao.getPassword(memberDto.getmId());
		// 2.입력한 pw와 db의 pw를 해싱컴포넌트에서 비교
//		result=
		// 3.
		// 4.해당 회원에 관련된 기본정보 삭제
		if (result == 1) {
			result = memberDao.deleteMember(memberDto);
			if (result == 1) {
				memberDao.deleteMemberInfo(memberDto);
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
