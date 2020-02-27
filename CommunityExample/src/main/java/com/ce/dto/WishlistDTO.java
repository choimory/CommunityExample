package com.ce.dto;

import java.io.Serializable;

public class WishlistDTO implements Serializable {
	private static final long serialVersionUID = 3037625566014920634L;
	private int wIdx;
	private int sIdx;
	private String mId;
	private ShopDTO shopDto;

	@Override
	public String toString() {
		System.out.println(wIdx+", "+sIdx+", "+mId);
		if(shopDto!=null)System.out.println(shopDto.toString());
		return super.toString();
	}

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
