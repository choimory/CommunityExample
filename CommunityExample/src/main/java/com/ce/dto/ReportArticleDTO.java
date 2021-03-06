package com.ce.dto;

import java.io.Serializable;

public class ReportArticleDTO implements Serializable {
	private static final long serialVersionUID = -3770372804082478789L;
	private String mId;
	private String bType;
	private String bId;
	private int bIdx;

	@Override
	public String toString() {
		String result="ReportArticleDTO [mId:"+mId+", bType:"+bType+", bId:"+bId+", bIdx:"+bIdx+"]";
		
		return result;
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
