package com.ce.dto;

public class BookmarkArticleDTO {
	private int baIdx;
	private String mId;
	private String bType;
	private String bId;
	private int bIdx;
	private BoardDTO boardDto;

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
