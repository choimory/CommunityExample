package com.ce.dto;

import java.io.Serializable;

import com.ce.component.PageHelper;
import com.ce.component.SearchHelper;

public class ShopCommentDTO implements Serializable {
	private static final long serialVersionUID = 9060615446736656036L;
	private int scIdx;
	private int sIdx;
	private String mId;
	private String mNickname;
	private String scContent;
	private String scRegDate;
	private int scGroup;
	private int scStep;
	private int scIndent;
	private ShopCommentInfoDTO shopCommentInfoDto;
	private PageHelper pageHelper;
	private SearchHelper searchHelper;
	

	@Override
	public String toString() {
		System.out.println(scIdx+", "+sIdx+", "+mId+", "+mNickname+", "+scContent+", "+scRegDate+", "+scGroup+", "+scStep+", "+scIdx);
		if(shopCommentInfoDto!=null)System.out.println(shopCommentInfoDto.toString());
		if(pageHelper!=null)System.out.println(pageHelper.toString());
		if(searchHelper!=null)System.out.println(searchHelper.toString());
		return super.toString();
	}

	public SearchHelper getSearchHelper() {
		return searchHelper;
	}

	public void setSearchHelper(SearchHelper searchHelper) {
		this.searchHelper = searchHelper;
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

	public String getScRegDate() {
		return scRegDate;
	}

	public void setScRegDate(String scRegDate) {
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
