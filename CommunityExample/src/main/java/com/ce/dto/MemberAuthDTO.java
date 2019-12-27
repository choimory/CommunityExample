package com.ce.dto;

public class MemberAuthDTO {
	private String mId;
	private String mAuth;
	private boolean mAuthComplete;

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmAuth() {
		return mAuth;
	}

	public void setmAuth(String mAuth) {
		this.mAuth = mAuth;
	}

	public boolean ismAuthComplete() {
		return mAuthComplete;
	}

	public void setmAuthComplete(boolean mAuthComplete) {
		this.mAuthComplete = mAuthComplete;
	}

}
