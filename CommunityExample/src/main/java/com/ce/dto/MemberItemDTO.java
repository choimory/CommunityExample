package com.ce.dto;

import java.io.Serializable;

public class MemberItemDTO implements Serializable {
	private static final long serialVersionUID = 1072502445302846250L;
	private String mId;
	private int sIdx;
	private ShopDTO shopDto;

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public int getsIdx() {
		return sIdx;
	}

	public void setsIdx(int sIdx) {
		this.sIdx = sIdx;
	}

	public ShopDTO getShopDto() {
		return shopDto;
	}

	public void setShopDto(ShopDTO shopDto) {
		this.shopDto = shopDto;
	}

}
