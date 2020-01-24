package com.ce.dto;

import java.io.Serializable;

public class BoardTypeDTO implements Serializable {
	private static final long serialVersionUID = -8141888733747346504L;
	private String bId;
	private String bType;
	private String bIdKor;
	private String bTypeKor;
	private String bIntroduce;
	

	public String getbIntroduce() {
		return bIntroduce;
	}

	public void setbIntroduce(String bIntroduce) {
		this.bIntroduce = bIntroduce;
	}

	@Override
	public String toString() {
		System.out.println(bId+", "+bType+", "+bIdKor+", "+bTypeKor+", "+bIntroduce);
		return super.toString();
	}

	public String getbId() {
		return bId;
	}

	public void setbId(String bId) {
		this.bId = bId;
	}

	public String getbType() {
		return bType;
	}

	public void setbType(String bType) {
		this.bType = bType;
	}

	public String getbIdKor() {
		return bIdKor;
	}

	public void setbIdKor(String bIdKor) {
		this.bIdKor = bIdKor;
	}

	public String getbTypeKor() {
		return bTypeKor;
	}

	public void setbTypeKor(String bTypeKor) {
		this.bTypeKor = bTypeKor;
	}

}
