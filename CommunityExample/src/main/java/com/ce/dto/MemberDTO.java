package com.ce.dto;

public class MemberDTO {
	private String mId;
	private String mNickname;
	private String mPassword;
	private String mEmail;
	private MemberInfoDTO memberInfoDto;

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
