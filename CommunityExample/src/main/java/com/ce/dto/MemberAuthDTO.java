package com.ce.dto;

import java.io.Serializable;

public class MemberAuthDTO implements Serializable {
	private static final long serialVersionUID = -742726652777184063L;
	private String mId;
	private String mAuth;
	private int mAuthComplete;

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

	public int getmAuthComplete() {
		return mAuthComplete;
	}

	public void setmAuthComplete(int mAuthComplete) {
		this.mAuthComplete = mAuthComplete;
	}


}
