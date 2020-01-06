package com.ce.dto;

import java.io.Serializable;

public class BoardInfoDTO implements Serializable {
	private static final long serialVersionUID = 6450534919628271431L;
	private int bIdx;
	private int bHit;
	private int bUpvote;
	private int bDownvote;
	private int bCommentNum;
	private int bReportNum;
	private int bBlind;
	private int bNotice;
	private int bBest;

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

	public int getbCommentNum() {
		return bCommentNum;
	}

	public void setbCommentNum(int bCommentNum) {
		this.bCommentNum = bCommentNum;
	}

	public int getbReportNum() {
		return bReportNum;
	}

	public void setbReportNum(int bReportNum) {
		this.bReportNum = bReportNum;
	}

	public int getbBlind() {
		return bBlind;
	}

	public void setbBlind(int bBlind) {
		this.bBlind = bBlind;
	}

	public int getbNotice() {
		return bNotice;
	}

	public void setbNotice(int bNotice) {
		this.bNotice = bNotice;
	}

	public int getbBest() {
		return bBest;
	}

	public void setbBest(int bBest) {
		this.bBest = bBest;
	}

}
