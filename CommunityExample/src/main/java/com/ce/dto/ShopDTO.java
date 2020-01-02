package com.ce.dto;

import java.sql.Timestamp;

import com.ce.component.PageHelper;
import com.ce.component.SearchHelper;

public class ShopDTO {
	private int sIdx;
	private String sType;
	private String sCategory;
	private String mId;
	private String mNickname;
	private String sTitle;
	private String sContent;
	private String sFileName;
	private int sPrice;
	private String sRegDate;
	private ShopInfoDTO shopInfoDto;
	private PageHelper pageHelper;
	private SearchHelper searchHelper;
	
	
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

	public SearchHelper getSearchHelper() {
		return searchHelper;
	}

	public void setSearchHelper(SearchHelper searchHelper) {
		this.searchHelper = searchHelper;
	}

	public int getsIdx() {
		return sIdx;
	}

	public void setsIdx(int sIdx) {
		this.sIdx = sIdx;
	}

	public String getsType() {
		return sType;
	}

	public void setsType(String sType) {
		this.sType = sType;
	}

	public String getsCategory() {
		return sCategory;
	}

	public void setsCategory(String sCategory) {
		this.sCategory = sCategory;
	}

	public String getmNickname() {
		return mNickname;
	}

	public void setmNickname(String mNickname) {
		this.mNickname = mNickname;
	}

	public String getsTitle() {
		return sTitle;
	}

	public void setsTitle(String sTitle) {
		this.sTitle = sTitle;
	}

	public String getsContent() {
		return sContent;
	}

	public void setsContent(String sContent) {
		this.sContent = sContent;
	}

	public String getsFileName() {
		return sFileName;
	}

	public void setsFileName(String sFileName) {
		this.sFileName = sFileName;
	}

	public int getsPrice() {
		return sPrice;
	}

	public void setsPrice(int sPrice) {
		this.sPrice = sPrice;
	}

	public String getsRegDate() {
		return sRegDate;
	}

	public void setsRegDate(String sRegDate) {
		this.sRegDate = sRegDate;
	}

	public ShopInfoDTO getShopInfoDto() {
		return shopInfoDto;
	}

	public void setShopInfoDto(ShopInfoDTO shopInfoDto) {
		this.shopInfoDto = shopInfoDto;
	}


}
