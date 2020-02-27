package com.ce.service;

import java.util.Map;

import com.ce.dto.MemberAuthDTO;
import com.ce.dto.MemberDTO;

public interface MemberService {
	 public int idCheck(String mId);
	 public int nicknameCheck(String mNickname);
	 public int emailCheck(String mEmail); 
	 public MemberDTO join(MemberDTO memberDto);
	 public MemberDTO findAccount(String mEmail);
	 public int sendMail(MemberDTO memberDto);
	 public Map<String,Object> login(MemberDTO memberDto); 
	 public MemberDTO callBack(String apiResult);
	 public Map<String,Object> memberInfo(String mId); 
	 public int modifyInfo(MemberDTO memberDto);
	 public int withdraw(MemberDTO memberDto); 
//	 public int auth(MemberAuthDTO memberAuthDto); //입력한 인증키를 테이블상의 인증키와 대조해보고 알맞을경우 진행, 아닐경우 빠꾸
}
