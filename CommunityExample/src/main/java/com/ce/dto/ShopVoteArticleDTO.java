package com.ce.dto;

import java.io.Serializable;

public class ShopVoteArticleDTO implements Serializable {
	private static final long serialVersionUID = -8430273166967737487L;
	private String mId;
	private int sIdx;
	private int svUpdown;

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public int getsIdx() {
		return sIdx;
	}

	public void setsIdx(int sIdx) {
		this.sIdx = sIdx;
	}

	public int getSvUpdown() {
		return svUpdown;
	}

	public void setSvUpdown(int svUpdown) {
		this.svUpdown = svUpdown;
	}

}
