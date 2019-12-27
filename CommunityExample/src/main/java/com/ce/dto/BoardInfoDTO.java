package com.ce.dto;

public class BoardInfoDTO {
	private int bIdx;
	private int bHit;
	private int bUpvote;
	private int bDownvote;
	private int bCommentCnt;
	private int bReportCnt;
	private boolean bBlind;
	private boolean bNotice;
	private boolean bBest;

	public int getbIdx() {
		return bIdx;
	}

	public void setbIdx(int bIdx) {
		this.bIdx = bIdx;
	}

	public int getbHit() {
		return bHit;
	}

	public void setbHit(int bHit) {
		this.bHit = bHit;
	}

	public int getbUpvote() {
		return bUpvote;
	}

	public void setbUpvote(int bUpvote) {
		this.bUpvote = bUpvote;
	}

	public int getbDownvote() {
		return bDownvote;
	}

	public void setbDownvote(int bDownvote) {
		this.bDownvote = bDownvote;
	}

	public int getbCommentCnt() {
		return bCommentCnt;
	}

	public void setbCommentCnt(int bCommentCnt) {
		this.bCommentCnt = bCommentCnt;
	}

	public int getbReportCnt() {
		return bReportCnt;
	}

	public void setbReportCnt(int bReportCnt) {
		this.bReportCnt = bReportCnt;
	}

	public boolean isbBlind() {
		return bBlind;
	}

	public void setbBlind(boolean bBlind) {
		this.bBlind = bBlind;
	}

	public boolean isbNotice() {
		return bNotice;
	}

	public void setbNotice(boolean bNotice) {
		this.bNotice = bNotice;
	}

	public boolean isbBest() {
		return bBest;
	}

	public void setbBest(boolean bBest) {
		this.bBest = bBest;
	}
}
