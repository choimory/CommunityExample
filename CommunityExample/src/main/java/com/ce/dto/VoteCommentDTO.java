package com.ce.dto;

import java.io.Serializable;

public class VoteCommentDTO implements Serializable {
	private static final long serialVersionUID = -4747788034870824720L;
	private String mId;
	private String bType;
	private String bId;
	private int bcIdx;
	private int vUpDown;

	@Override
	public String toString() {
		System.out.println(mId+", "+bType+", "+bId+", "+bcIdx+", "+vUpDown);
		return super.toString();
	}

	public int getvUpDown() {
		return vUpDown;
	}

	public void setvUpDown(int vUpDown) {
		this.vUpDown = vUpDown;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getbType() {
		return bType;
	}

	public void setbType(String bType) {
		this.bType = bType;
	}

	public String getbId() {
		return bId;
	}

	public void setbId(String bId) {
		this.bId = bId;
	}

	public int getBcIdx() {
		return bcIdx;
	}

	public void setBcIdx(int bcIdx) {
		this.bcIdx = bcIdx;
	}

}
