package com.ce.dto;

import java.io.Serializable;

public class BookmarkBoardDTO implements Serializable {
	private static final long serialVersionUID = -6031520007835587686L;
	private String mId;
	private String bType;
	private String bId;
	private String bTypeKor;
	private String bIdKor;

	@Override
	public String toString() {
		String result="BookmarkBoardDTO[mId:"+mId+", bType:"+bType+", bId:"+bId+", bTypeKor:"+bTypeKor+", bIdKor:"+bIdKor+"]";
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

	public String getbTypeKor() {
		return bTypeKor;
	}

	public void setbTypeKor(String bTypeKor) {
		this.bTypeKor = bTypeKor;
	}

	public String getbIdKor() {
		return bIdKor;
	}

	public void setbIdKor(String bIdKor) {
		this.bIdKor = bIdKor;
	}

}
