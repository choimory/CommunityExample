package com.ce.dto;

import java.io.Serializable;
import java.util.List;

public class BoardCategoryDTO implements Serializable{
	private static final long serialVersionUID = 1836666720811590523L;
	private String bId;
	private String bCategory;


	public String getbId() {
		return bId;
	}

	public void setbId(String bId) {
		this.bId = bId;
	}

	public String getbCategory() {
		return bCategory;
	}

	public void setbCategory(String bCategory) {
		this.bCategory = bCategory;
	}


}
