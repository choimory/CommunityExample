package com.ce.service;

import java.util.Map;

import com.ce.dto.MemberAuthDTO;
import com.ce.dto.MemberDTO;

public interface MemberService {
	 public int idCheck(String mId); //받은 id로 검색해서 데이터 유무 확인
	 public int nicknameCheck(String mNickname);
	 public int emailCheck(String mEmail); //받은 email로 검색해서 데이터 유무 확인
	 public MemberDTO join(MemberDTO memberDto); //받은 데이터로 row 작성
	 public MemberDTO findAccount(String mEmail); //받은 email에 해당하는 회원 비밀번호 변경한뒤 id와 임시비밀번호 이메일전송
	 public int sendMail(MemberDTO memberDto); // controller에 @EnableAsync를 붙이고 sendMail에 @Async를 붙여서 메소드를 비동기 호출해서 메일을 비동기 전송하려고 메소드정의함. @EnableASync를 붙인 클래스가 본인의 @Async를 호출할땐 비동기호출이 안되기때문에 어쩔수없이 컨트롤러-서비스 분리함
	 public Map<String,Object> login(MemberDTO memberDto); //아이디로 검색한뒤 해당아이디의 비밀번호와 입력값 일치시 로그인, 아닐시 실패
	 public Map<String,Object> memberInfo(String mId); //세션의 id에 해당하는 회원 정보들 가져오기(회원정보, 북마크한 게시판, 게시물 등등..)
	 public int modifyInfo(MemberDTO memberDto); //입력한 값으로 해당회원 정보수정
	 public int withdraw(MemberDTO memberDto); //해당 회원에 관련된 기본정보 삭제
//	 public int auth(MemberAuthDTO memberAuthDto); //입력한 인증키를 테이블상의 인증키와 대조해보고 알맞을경우 진행, 아닐경우 빠꾸
}
