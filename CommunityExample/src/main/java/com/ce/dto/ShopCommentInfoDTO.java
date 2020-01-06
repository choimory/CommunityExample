package com.ce.dto;

import java.io.Serializable;

public class ShopCommentInfoDTO implements Serializable {
	private static final long serialVersionUID = 8215236811570547116L;
	private int scIdx;
	private int sciUpvote;
	private int sciDownvote;
	private int sciReportNum;
	private int sciBlind;
	private int sciNotice;
	private int sciBest;

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

	public int getSciReportNum() {
		return sciReportNum;
	}

	public void setSciReportNum(int sciReportNum) {
		this.sciReportNum = sciReportNum;
	}

	public int getSciBlind() {
		return sciBlind;
	}

	public void setSciBlind(int sciBlind) {
		this.sciBlind = sciBlind;
	}

	public int getSciNotice() {
		return sciNotice;
	}

	public void setSciNotice(int sciNotice) {
		this.sciNotice = sciNotice;
	}

	public int getSciBest() {
		return sciBest;
	}

	public void setSciBest(int sciBest) {
		this.sciBest = sciBest;
	}


}
