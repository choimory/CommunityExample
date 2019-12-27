package com.ce.service;

import java.util.Map;

import com.ce.dto.MemberAuthDTO;
import com.ce.dto.MemberDTO;

public interface MemberService {
	 public int idCheck(String mId); //받은 id로 검색해서 데이터 유무 확인
	 public int emailCheck(String mEmail); //받은 email로 검색해서 데이터 유무 확인
	 public MemberDTO join(MemberDTO memberDto); //받은 데이터로 row 작성
	 public int findAccount(String mEmail); //받은 email에 해당하는 회원 비밀번호 변경한뒤 id와 임시비밀번호 이메일전송
	 public MemberDTO login(MemberDTO memberDto); //아이디로 검색한뒤 해당아이디의 비밀번호와 입력값 일치시 로그인, 아닐시 실패
	 public Map<String,Object> memberInfo(String mId); //세션의 id에 해당하는 회원 정보들 가져오기(회원정보, 북마크한 게시판, 게시물 등등..)
	 public int modifyInfo(MemberDTO memberDto); //입력한 값으로 해당회원 정보수정
	 public int withdraw(MemberDTO memberDto); //해당 회원에 관련된 기본정보 삭제
//	 public int auth(MemberAuthDTO memberAuthDto); //입력한 인증키를 테이블상의 인증키와 대조해보고 알맞을경우 진행, 아닐경우 빠꾸
}
