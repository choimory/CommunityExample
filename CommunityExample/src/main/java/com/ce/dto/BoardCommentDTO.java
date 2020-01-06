package com.ce.dto;

import java.io.Serializable;

import com.ce.component.PageHelper;
import com.ce.component.SearchHelper;

public class BoardCommentDTO implements Serializable {
	private static final long serialVersionUID = -5000076885322699817L;
	private int bcIdx;
	private int bIdx;
	private String mId;
	private String mNickname;
	private String bcContent;
	private String bcRegDate;
	private int bcGroup;
	private int bcStep;
	private int bcIndent;
	private BoardCommentInfoDTO boardCommentInfoDto;
	private BoardTypeDTO boardTypeDto;
	private PageHelper pageHelper;

	public BoardTypeDTO getBoardTypeDto() {
		return boardTypeDto;
	}

	public void setBoardTypeDto(BoardTypeDTO boardTypeDto) {
		this.boardTypeDto = boardTypeDto;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public PageHelper getPageHelper() {
		return pageHelper;
	}

	public void setPageHelper(PageHelper pageHelper) {
		this.pageHelper = pageHelper;
	}

	public BoardCommentInfoDTO getBciDTO() {
		return boardCommentInfoDto;
	}

	public void setBciDTO(BoardCommentInfoDTO boardCommentInfoDto) {
		this.boardCommentInfoDto = boardCommentInfoDto;
	}

	public int getBcIdx() {
		return bcIdx;
	}

	public void setBcIdx(int bcIdx) {
		this.bcIdx = bcIdx;
	}

	public int getbIdx() {
		return bIdx;
	}

	public void setbIdx(int bIdx) {
		this.bIdx = bIdx;
	}

	public String getmNickname() {
		return mNickname;
	}

	public void setmNickname(String mNickname) {
		this.mNickname = mNickname;
	}

	public String getBcContent() {
		return bcContent;
	}

	public void setBcContent(String bcContent) {
		this.bcContent = bcContent;
	}

	public String getBcRegDate() {
		return bcRegDate;
	}

	public void setBcRegDate(String bcRegDate) {
		this.bcRegDate = bcRegDate;
	}

	public int getBcGroup() {
		return bcGroup;
	}

	public void setBcGroup(int bcGroup) {
		this.bcGroup = bcGroup;
	}

	public int getBcStep() {
		return bcStep;
	}

	public void setBcStep(int bcStep) {
		this.bcStep = bcStep;
	}

	public int getBcIndent() {
		return bcIndent;
	}

	public void setBcIndent(int bcIndent) {
		this.bcIndent = bcIndent;
	}

	public BoardCommentInfoDTO getBoardCommentInfoDto() {
		return boardCommentInfoDto;
	}

	public void setBoardCommentInfoDto(BoardCommentInfoDTO boardCommentInfoDto) {
		this.boardCommentInfoDto = boardCommentInfoDto;
	}
}
