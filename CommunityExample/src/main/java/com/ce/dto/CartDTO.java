package com.ce.dto;

import java.io.Serializable;

public class CartDTO implements Serializable {
	private static final long serialVersionUID = -7064459111441251745L;
	private int cIdx;
	private int sIdx;
	private int cartCnt;
	private String mId;
	private ShopDTO shopDto;

	@Override
	public String toString() {
		System.out.println(cIdx+", "+sIdx+", "+cartCnt);
		if(shopDto!=null)System.out.println(shopDto.toString());
		return super.toString();
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public int getcIdx() {
		return cIdx;
	}

	public void setcIdx(int cIdx) {
		this.cIdx = cIdx;
	}

	public int getsIdx() {
		return sIdx;
	}

	public void setsIdx(int sIdx) {
		this.sIdx = sIdx;
	}

	public int getCartCnt() {
		return cartCnt;
	}

	public void setCartCnt(int cartCnt) {
		this.cartCnt = cartCnt;
	}

	public ShopDTO getShopDto() {
		return shopDto;
	}

	public void setShopDto(ShopDTO shopDto) {
		this.shopDto = shopDto;
	}

}
