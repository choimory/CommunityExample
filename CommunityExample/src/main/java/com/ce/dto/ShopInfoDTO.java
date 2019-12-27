package com.ce.dto;

public class ShopInfoDTO {
	private int sIdx;
	private boolean sPermission;
	private int sReportCnt;
	private boolean sBlind;
	private int sHit;
	private int sUpvote;
	private int sDownvote;
	private int sCommentCnt;

	public int getsIdx() {
		return sIdx;
	}

	public void setsIdx(int sIdx) {
		this.sIdx = sIdx;
	}

	public boolean issPermission() {
		return sPermission;
	}

	public void setsPermission(boolean sPermission) {
		this.sPermission = sPermission;
	}

	public int getsReportCnt() {
		return sReportCnt;
	}

	public void setsReportCnt(int sReportCnt) {
		this.sReportCnt = sReportCnt;
	}

	public boolean issBlind() {
		return sBlind;
	}

	public void setsBlind(boolean sBlind) {
		this.sBlind = sBlind;
	}

	public int getsHit() {
		return sHit;
	}

	public void setsHit(int sHit) {
		this.sHit = sHit;
	}

	public int getsUpvote() {
		return sUpvote;
	}

	public void setsUpvote(int sUpvote) {
		this.sUpvote = sUpvote;
	}

	public int getsDownvote() {
		return sDownvote;
	}

	public void setsDownvote(int sDownvote) {
		this.sDownvote = sDownvote;
	}

	public int getsCommentCnt() {
		return sCommentCnt;
	}

	public void setsCommentCnt(int sCommentCnt) {
		this.sCommentCnt = sCommentCnt;
	}
}
