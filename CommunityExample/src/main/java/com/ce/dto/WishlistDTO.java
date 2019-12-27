package com.ce.dto;

public class WishlistDTO {
	private String mId;
	private int wIdx;
	private int sIdx;
	private ShopDTO shopDto;

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public int getwIdx() {
		return wIdx;
	}

	public void setwIdx(int wIdx) {
		this.wIdx = wIdx;
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
