package com.ce.dto;

import java.io.Serializable;

public class BookmarkArticleDTO implements Serializable {
	private static final long serialVersionUID = 1227100098226602298L;
	private int baIdx;
	private String mId;
	private String bType;
	private String bId;
	private int bIdx;
	private BoardDTO boardDto;

	@Override
	public String toString() {
		String result="BookmarkArticleDTO [baIdx:"+baIdx+", mId:"+mId+", bType:"+bType+", bId:"+bId+", bIdx:"+bIdx+"]";
		if(boardDto!=null) {
			result+=boardDto.toString();
		}
		return result;
	}

	public int getBaIdx() {
		return baIdx;
	}

	public void setBaIdx(int baIdx) {
		this.baIdx = baIdx;
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

	public BoardDTO getBoardDto() {
		return boardDto;
	}

	public void setBoardDto(BoardDTO boardDto) {
		this.boardDto = boardDto;
	}

}
