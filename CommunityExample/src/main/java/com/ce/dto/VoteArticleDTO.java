package com.ce.dto;

public class VoteArticleDTO {
	private String mId;
	private String bType;
	private String bId;
	private int bIdx;
	private int vUpDown;
	
	
	public int getvUpDown() {
		return vUpDown;
	}

	public void setvUpDown(int vUpDown) {
		this.vUpDown = vUpDown;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getbType() {
		return bType;
	}

	public void setbType(String bType) {
		this.bType = bType;
	}

	public String getbId() {
		return bId;
	}

	public void setbId(String bId) {
		this.bId = bId;
	}

	public int getbIdx() {
		return bIdx;
	}

	public void setbIdx(int bIdx) {
		this.bIdx = bIdx;
	}

}
