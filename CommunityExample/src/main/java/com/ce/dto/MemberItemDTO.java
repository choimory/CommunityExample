package com.ce.dto;

public class MemberItemDTO {
	private String mId;
	private int sIdx;
	private ShopDTO sDTO;

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

	public ShopDTO getsDTO() {
		return sDTO;
	}

	public void setsDTO(ShopDTO sDTO) {
		this.sDTO = sDTO;
	}

}
