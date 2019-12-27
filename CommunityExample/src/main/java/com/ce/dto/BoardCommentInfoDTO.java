package com.ce.dto;

public class BoardCommentInfoDTO {
	private int bcIdx;
	private int bcUpvote;
	private int bcDownvote;
	private int bcReportCnt;
	private boolean bcBlind;
	private boolean bcNotice;
	private boolean bcBest;

	public int getBcIdx() {
		return bcIdx;
	}

	public void setBcIdx(int bcIdx) {
		this.bcIdx = bcIdx;
	}

	public int getBcUpvote() {
		return bcUpvote;
	}

	public void setBcUpvote(int bcUpvote) {
		this.bcUpvote = bcUpvote;
	}

	public int getBcDownvote() {
		return bcDownvote;
	}

	public void setBcDownvote(int bcDownvote) {
		this.bcDownvote = bcDownvote;
	}

	public int getBcReportCnt() {
		return bcReportCnt;
	}

	public void setBcReportCnt(int bcReportCnt) {
		this.bcReportCnt = bcReportCnt;
	}

	public boolean isBcBlind() {
		return bcBlind;
	}

	public void setBcBlind(boolean bcBlind) {
		this.bcBlind = bcBlind;
	}

	public boolean isBcNotice() {
		return bcNotice;
	}

	public void setBcNotice(boolean bcNotice) {
		this.bcNotice = bcNotice;
	}

	public boolean isBcBest() {
		return bcBest;
	}

	public void setBcBest(boolean bcBest) {
		this.bcBest = bcBest;
	}
}
