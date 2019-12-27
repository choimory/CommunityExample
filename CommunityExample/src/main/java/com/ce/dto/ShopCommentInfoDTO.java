package com.ce.dto;

public class ShopCommentInfoDTO {
	private int scIdx;
	private int sciUpvote;
	private int sciDownvote;
	private int sciReportCnt;
	private boolean sciBlind;
	private boolean sciNotice;
	private boolean sciBest;

	public int getScIdx() {
		return scIdx;
	}

	public void setScIdx(int scIdx) {
		this.scIdx = scIdx;
	}

	public int getSciUpvote() {
		return sciUpvote;
	}

	public void setSciUpvote(int sciUpvote) {
		this.sciUpvote = sciUpvote;
	}

	public int getSciDownvote() {
		return sciDownvote;
	}

	public void setSciDownvote(int sciDownvote) {
		this.sciDownvote = sciDownvote;
	}

	public int getSciReportCnt() {
		return sciReportCnt;
	}

	public void setSciReportCnt(int sciReportCnt) {
		this.sciReportCnt = sciReportCnt;
	}

	public boolean isSciBlind() {
		return sciBlind;
	}

	public void setSciBlind(boolean sciBlind) {
		this.sciBlind = sciBlind;
	}

	public boolean isSciNotice() {
		return sciNotice;
	}

	public void setSciNotice(boolean sciNotice) {
		this.sciNotice = sciNotice;
	}

	public boolean isSciBest() {
		return sciBest;
	}

	public void setSciBest(boolean sciBest) {
		this.sciBest = sciBest;
	}

}
