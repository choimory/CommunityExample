package com.ce.dto;

import java.sql.Timestamp;

public class MemberInfoDTO {
	private String mId;
	private int mExp;
	private int mPoint;
	private int mEquipItem;
	private String mRegDate;
	private String mLoginDate;
	private boolean mBan;
	private String mEndToBan;
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

	public String getmRegDate() {
		return mRegDate;
	}

	public void setmRegDate(String mRegDate) {
		this.mRegDate = mRegDate;
	}

	public String getmLoginDate() {
		return mLoginDate;
	}

	public void setmLoginDate(String mLoginDate) {
		this.mLoginDate = mLoginDate;
	}

	public boolean ismBan() {
		return mBan;
	}

	public void setmBan(boolean mBan) {
		this.mBan = mBan;
	}

	public String getmEndToBan() {
		return mEndToBan;
	}

	public void setmEndToBan(String mEndToBan) {
		this.mEndToBan = mEndToBan;
	}

	public String getmAdmin() {
		return mAdmin;
	}

	public void setmAdmin(String mAdmin) {
		this.mAdmin = mAdmin;
	}

}
