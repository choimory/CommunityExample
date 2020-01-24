package com.ce.dao;

import java.util.List;

import com.ce.dto.BookmarkArticleDTO;
import com.ce.dto.BookmarkBoardDTO;
import com.ce.dto.MemberBanDTO;
import com.ce.dto.MemberDTO;
import com.ce.dto.MemberItemDTO;

public interface MemberDAO {
	public int ban(MemberBanDTO memberBanDto); //insert member_ban
	public int updateBan(MemberBanDTO memberBanDto); //update member_ban
	public int deleteBan(MemberBanDTO memberBanDto); //delete member_ban
	public int idCheck(String mId); // count where mId
	public int emailCheck(String mEmail); // count where mEmail
	public int join(MemberDTO memberDto); // insert member values memberDto
	public int insertMemberInfo(String mId); // insert memberInfo values
	public int login(String mId);
	public int findAccount(MemberDTO memberDto); // update password where mEmail
	public String getPassword(String mId); // select mPw where mId
//	public MemberDTO getMemberDto(MemberDTO memberDto); // select all where mId
	public MemberDTO getMemberDto(String mId); // select all where mId
	public List<MemberItemDTO> getMemberItem(String mId); // select all where mId
	public BookmarkBoardDTO getBookmarkBoardDTO(String mId); //select all where mId
	public BookmarkArticleDTO getBookmarkArticleDTO(String mId); //select all where mId
	public int modify(MemberDTO memberDto); //update where mId
	public int deleteMember(String mId); //delete where mId
//	public boolean isAuthCompleted(String mId); // select authcomplete where mId
	public int unBan(String mId);
	public String changeNicknameToId(String mNickname);
}
