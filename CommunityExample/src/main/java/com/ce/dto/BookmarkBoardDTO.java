package com.ce.dto;

import java.io.Serializable;

public class BookmarkBoardDTO implements Serializable {
	private static final long serialVersionUID = -6031520007835587686L;
	private String mId;
	private String bType;
	private String bId;

	@Override
	public String toString() {
		System.out.println(mId+", "+bType+", "+bId);
		return super.toString();
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

}
