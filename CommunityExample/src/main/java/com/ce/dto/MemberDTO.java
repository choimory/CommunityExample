package com.ce.dto;

import java.io.Serializable;

public class MemberDTO implements Serializable {
	private static final long serialVersionUID = 7695195705679883936L;
	private String mId;
	private String mPassword;
	private String mNickname;
	private String mEmail;
	private MemberInfoDTO memberInfoDto;
	private MemberBanDTO memberBanDto;

	@Override
	public String toString() {
		System.out.println(mId+", "+mPassword+", "+mNickname+", "+mEmail);
		if(memberInfoDto!=null)System.out.println(memberInfoDto.toString());
		if(memberBanDto!=null)System.out.println(memberBanDto.toString());
		return super.toString();
	}

	public MemberBanDTO getMemberBanDto() {
		return memberBanDto;
	}

	public void setMemberBanDto(MemberBanDTO memberBanDto) {
		this.memberBanDto = memberBanDto;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmNickname() {
		return mNickname;
	}

	public void setmNickname(String mNickname) {
		this.mNickname = mNickname;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}

	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	public MemberInfoDTO getMemberInfoDto() {
		return memberInfoDto;
	}

	public void setMemberInfoDto(MemberInfoDTO memberInfoDto) {
		this.memberInfoDto = memberInfoDto;
	}

}
