package com.ce.dto;

import java.io.Serializable;

public class BoardCommentInfoDTO implements Serializable {
	private static final long serialVersionUID = -4389160422293820531L;
	private int bcIdx;
	private int bcUpvote;
	private int bcDownvote;
	private int bcReportNum;
	private int bcBlind;
	private int bcNotice;
	private int bcBest;

	@Override
	public String toString(){
		System.out.println(bcIdx+", "+bcUpvote+", "+bcDownvote+", "+bcReportNum+", "+bcBlind+", "+bcNotice+", "+bcBest);
		return super.toString();
	}

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

	public int getBcReportNum() {
		return bcReportNum;
	}

	public void setBcReportNum(int bcReportNum) {
		this.bcReportNum = bcReportNum;
	}

	public int getBcBlind() {
		return bcBlind;
	}

	public void setBcBlind(int bcBlind) {
		this.bcBlind = bcBlind;
	}

	public int getBcNotice() {
		return bcNotice;
	}

	public void setBcNotice(int bcNotice) {
		this.bcNotice = bcNotice;
	}

	public int getBcBest() {
		return bcBest;
	}

	public void setBcBest(int bcBest) {
		this.bcBest = bcBest;
	}

}
