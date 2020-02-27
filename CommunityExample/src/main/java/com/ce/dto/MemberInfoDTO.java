package com.ce.dto;

import java.io.Serializable;

public class MemberInfoDTO implements Serializable {
	private static final long serialVersionUID = -4133063279364651457L;
	private String mId;
	private int mExp;
	private int mPoint;
	private int mEquipItem;
	private String mRegDate;
	private String mLoginDate;
	private String mAdmin;

	@Override
	public String toString() {
		System.out.println(mId+", "+mExp+", "+mPoint+", "+mEquipItem+", "+mRegDate+", "+mLoginDate+", "+mAdmin);
		return super.toString();
	}

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



	public String getmAdmin() {
		return mAdmin;
	}

	public void setmAdmin(String mAdmin) {
		this.mAdmin = mAdmin;
	}

}
