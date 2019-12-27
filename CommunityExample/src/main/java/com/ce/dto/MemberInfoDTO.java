package com.ce.dto;

import java.sql.Timestamp;

public class MemberInfoDTO {
	private String mId;
	private int mExp;
	private int mPoint;
	private int mEquipItem;
	private Timestamp mRegDate;
	private Timestamp mLoginDate;
	private boolean mBan;
	private Timestamp mEndToBan;
	private String mAdmin;

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public int getmExp() {
		return mExp;
	}

	public void setmExp(int mExp) {
		this.mExp = mExp;
	}

	public int getmPoint() {
		return mPoint;
	}

	public void setmPoint(int mPoint) {
		this.mPoint = mPoint;
	}

	public int getmEquipItem() {
		return mEquipItem;
	}

	public void setmEquipItem(int mEquipItem) {
		this.mEquipItem = mEquipItem;
	}

	public Timestamp getmRegDate() {
		return mRegDate;
	}

	public void setmRegDate(Timestamp mRegDate) {
		this.mRegDate = mRegDate;
	}

	public Timestamp getmLoginDate() {
		return mLoginDate;
	}

	public void setmLoginDate(Timestamp mLoginDate) {
		this.mLoginDate = mLoginDate;
	}

	public boolean ismBan() {
		return mBan;
	}

	public void setmBan(boolean mBan) {
		this.mBan = mBan;
	}

	public Timestamp getmEndToBan() {
		return mEndToBan;
	}

	public void setmEndToBan(Timestamp mEndToBan) {
		this.mEndToBan = mEndToBan;
	}

	public String getmAdmin() {
		return mAdmin;
	}

	public void setmAdmin(String mAdmin) {
		this.mAdmin = mAdmin;
	}

}
