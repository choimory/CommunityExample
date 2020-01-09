package com.ce.dao;

import com.ce.dto.BookmarkArticleDTO;
import com.ce.dto.BookmarkBoardDTO;
import com.ce.dto.MemberDTO;
import com.ce.dto.MemberItemDTO;

public interface MemberDAO {
	public int ban(MemberDTO memberDto); //update ban, update endToban where mId
	public int idCheck(String mId); // count where mId
	public int emailCheck(String mEmail); // count where mEmail
	public int join(MemberDTO memberDto); // insert member values memberDto
	public int insertMemberInfo(MemberDTO memberDto); // insert memberInfo values
	public int findAccount(MemberDTO memberDto); // update password where mEmail
	public String getPassword(String mId); // select mPw where mId
//	public MemberDTO getMemberDto(MemberDTO memberDto); // select all where mId
	public MemberDTO getMemberDto(String mId); // select all where mId
	public MemberItemDTO getMemberItem(String mId); // select all where mId
	public BookmarkBoardDTO getBookmarkBoardDTO(String mId); //select all where mId
	public BookmarkArticleDTO getBookmarkArticleDTO(String mId); //select all where mId
	public int modifyInfo(MemberDTO memberDto); //update where mId
	public int deleteMember(MemberDTO memberDto); //delete where mId
	public int deleteMemberInfo(MemberDTO memberDto); //delete where mId
//	public boolean isAuthCompleted(String mId); // select authcomplete where mId
}
