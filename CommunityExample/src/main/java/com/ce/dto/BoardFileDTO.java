package com.ce.dto;

import java.io.Serializable;

public class BoardFileDTO implements Serializable {
	private static final long serialVersionUID = 8660344123434609013L;
	private int fIdx;
	private int bIdx;
	private String fOriginalName;
	private String fStoredName;
	private Long fSize;
	private BoardTypeDTO boardTypeDto;

	public BoardFileDTO () {}
	public BoardFileDTO(int bIdx, String fOriginalName, String fStoredName, Long fSize) {
		this.bIdx=bIdx;
		this.fOriginalName=fOriginalName;
		this.fStoredName=fStoredName;
		this.fSize=fSize;
	}
	
	
	@Override
	public String toString() {
		return fIdx+", "+bIdx+", "+fOriginalName+", "+fStoredName+", "+fSize;
	}

	public int getfIdx() {
		return fIdx;
	}

	public void setfIdx(int fIdx) {
		this.fIdx = fIdx;
	}

	public int getbIdx() {
		return bIdx;
	}

	public void setbIdx(int bIdx) {
		this.bIdx = bIdx;
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
	public BoardTypeDTO getBoardTypeDto() {
		return boardTypeDto;
	}
	public void setBoardTypeDto(BoardTypeDTO boardTypeDto) {
		this.boardTypeDto = boardTypeDto;
	}


}
