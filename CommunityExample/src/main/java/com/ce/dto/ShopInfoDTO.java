package com.ce.dto;

import java.io.Serializable;

public class ShopInfoDTO implements Serializable {
	private static final long serialVersionUID = -7990166658045141486L;
	private int sIdx;
	private int sHit;
	private int sUpvote;
	private int sDownvote;
	private int sCommentNum;
	private int sReportNum;
	private int sPermission;
	private int sBlind;

	public int getsIdx() {
		return sIdx;
	}

	public void setsIdx(int sIdx) {
		this.sIdx = sIdx;
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

	public int getsCommentNum() {
		return sCommentNum;
	}

	public void setsCommentNum(int sCommentNum) {
		this.sCommentNum = sCommentNum;
	}

	public int getsReportNum() {
		return sReportNum;
	}

	public void setsReportNum(int sReportNum) {
		this.sReportNum = sReportNum;
	}

	public int getsPermission() {
		return sPermission;
	}

	public void setsPermission(int sPermission) {
		this.sPermission = sPermission;
	}

	public int getsBlind() {
		return sBlind;
	}

	public void setsBlind(int sBlind) {
		this.sBlind = sBlind;
	}

}
