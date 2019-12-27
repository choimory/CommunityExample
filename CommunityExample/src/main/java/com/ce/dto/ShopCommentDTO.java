package com.ce.dto;

import java.sql.Timestamp;

import com.ce.component.PageHelper;
import com.ce.component.SearchHelper;

public class ShopCommentDTO {
	private int scIdx;
	private int sIdx;
	private String mId;
	private String mNickname;
	private String scContent;
	private Timestamp scRegDate;
	private int scGroup;
	private int scStep;
	private int scIndent;
	private ShopCommentInfoDTO shopCommentInfoDto;
	private PageHelper pageHelper;
	

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

	public int getScIdx() {
		return scIdx;
	}

	public void setScIdx(int scIdx) {
		this.scIdx = scIdx;
	}

	public int getsIdx() {
		return sIdx;
	}

	public void setsIdx(int sIdx) {
		this.sIdx = sIdx;
	}

	public String getmNickname() {
		return mNickname;
	}

	public void setmNickname(String mNickname) {
		this.mNickname = mNickname;
	}

	public String getScContent() {
		return scContent;
	}

	public void setScContent(String scContent) {
		this.scContent = scContent;
	}

	public Timestamp getScRegDate() {
		return scRegDate;
	}

	public void setScRegDate(Timestamp scRegDate) {
		this.scRegDate = scRegDate;
	}

	public int getScGroup() {
		return scGroup;
	}

	public void setScGroup(int scGroup) {
		this.scGroup = scGroup;
	}

	public int getScStep() {
		return scStep;
	}

	public void setScStep(int scStep) {
		this.scStep = scStep;
	}

	public int getScIndent() {
		return scIndent;
	}

	public void setScIndent(int scIndent) {
		this.scIndent = scIndent;
	}

	public ShopCommentInfoDTO getShopCommentInfoDto() {
		return shopCommentInfoDto;
	}

	public void setShopCommentInfoDto(ShopCommentInfoDTO shopCommentInfoDto) {
		this.shopCommentInfoDto = shopCommentInfoDto;
	}


}
