package com.ce.dto;

import java.io.Serializable;

public class MemberBanDTO implements Serializable{
	private static final long serialVersionUID = -6405340915573061180L;
	private String mId;
	private int mBan;
	private String mReason;
	private String mEndToBan;

	public int getmBan() {
		return mBan;
	}

	public void setmBan(int mBan) {
		this.mBan = mBan;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmReason() {
		return mReason;
	}

	public void setmReason(String mReason) {
		this.mReason = mReason;
	}

	public String getmEndToBan() {
		return mEndToBan;
	}

	public void setmEndToBan(String mEndToBan) {
		this.mEndToBan = mEndToBan;
	}

	@Override
	public String toString() {
		System.out.println(mId+", "+mBan+", "+mReason+", "+mEndToBan);
		return super.toString();
	}

}
