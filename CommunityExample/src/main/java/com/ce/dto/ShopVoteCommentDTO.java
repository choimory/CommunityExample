package com.ce.dto;

import java.io.Serializable;

public class ShopVoteCommentDTO implements Serializable {
	private static final long serialVersionUID = 4165283592147175586L;
	private String mId;
	private int sIdx;
	private int scIdx;
	private int scvUpdown;
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
	public int getScIdx() {
		return scIdx;
	}
	public void setScIdx(int scIdx) {
		this.scIdx = scIdx;
	}
	public int getScvUpdown() {
		return scvUpdown;
	}
	public void setScvUpdown(int scvUpdown) {
		this.scvUpdown = scvUpdown;
	}
}
