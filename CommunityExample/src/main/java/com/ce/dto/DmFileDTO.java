package com.ce.dto;

import java.io.Serializable;

public class DmFileDTO implements Serializable{
	private static final long serialVersionUID = -2980632785302493633L;
	private int fIdx;
	private int dmIdx;
	private String fOriginalName;
	private String fStoredName;
	private Long fSize;
	
	public DmFileDTO() {}
	public DmFileDTO(int dmIdx, String fOriginalName, String fStoredName, Long fSize) {
		this.dmIdx=dmIdx;
		this.fOriginalName=fOriginalName;
		this.fStoredName=fStoredName;
		this.fSize=fSize;
	}

	@Override
	public String toString() {
		return fIdx+", "+dmIdx+", "+fOriginalName+", "+fStoredName+", "+fSize;
	}
	
	public int getfIdx() {
		return fIdx;
	}

	public void setfIdx(int fIdx) {
		this.fIdx = fIdx;
	}

	public int getDmIdx() {
		return dmIdx;
	}

	public void setDmIdx(int dmIdx) {
		this.dmIdx = dmIdx;
	}

	public String getfOriginalName() {
		return fOriginalName;
	}

	public void setfOriginalName(String fOriginalName) {
		this.fOriginalName = fOriginalName;
	}

	public String getfStoredName() {
		return fStoredName;
	}

	public void setfStoredName(String fStoredName) {
		this.fStoredName = fStoredName;
	}

	public Long getfSize() {
		return fSize;
	}

	public void setfSize(Long fSize) {
		this.fSize = fSize;
	}
}
