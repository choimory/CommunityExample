package com.ce.dto;

public class CartDTO {
	private String mId;
	private int cartIdx;
	private int sIdx;
	private int cartCnt;
	private ShopDTO shopDto;

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public int getCartIdx() {
		return cartIdx;
	}

	public void setCartIdx(int cartIdx) {
		this.cartIdx = cartIdx;
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
