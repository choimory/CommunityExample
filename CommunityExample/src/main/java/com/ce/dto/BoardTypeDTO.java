package com.ce.dto;

import java.util.List;

public class BoardTypeDTO {
	private String bId;
	private String bType;
	private String bIdKor;
	private String bTypeKor;
	private List<String> bCategory;

	public List<String> getbCategory() {
		return bCategory;
	}

	public void setbCategory(List<String> bCategory) {
		this.bCategory = bCategory;
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
