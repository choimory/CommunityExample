package com.ce.dto;

import java.io.Serializable;

public class BoardFileDTO implements Serializable {
	private static final long serialVersionUID = 8660344123434609013L;
	private int bfIdx;
	private String bId;
	private int bIdx;
	private String bfName;
	private String bfPath;
	private int bfLine;

	public int getBfIdx() {
		return bfIdx;
	}

	public void setBfIdx(int bfIdx) {
		this.bfIdx = bfIdx;
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

	public String getBfName() {
		return bfName;
	}

	public void setBfName(String bfName) {
		this.bfName = bfName;
	}

	public String getBfPath() {
		return bfPath;
	}

	public void setBfPath(String bfPath) {
		this.bfPath = bfPath;
	}

	public int getBfLine() {
		return bfLine;
	}

	public void setBfLine(int bfLine) {
		this.bfLine = bfLine;
	}
}
