package com.ce.dto;

import java.io.Serializable;
import java.util.List;

import com.ce.component.PageHelper;
import com.ce.component.SearchHelper;

public class DmDTO implements Serializable {
	private static final long serialVersionUID = -7775720720583887484L;
	private int dmIdx;
	private String dmSenderId;
	private String dmSenderNickname;
	private String dmSendDate;
	private String dmReceiverId;
	private String dmReceiverNickname;
	private String dmReceiveDate;
	private String dmTitle;
	private String dmContent;
	private List<DmFileDTO> dmFileDtoList;
	private PageHelper pageHelper;
	private SearchHelper searchHelper;

	@Override
	public String toString() {
		String result="DmDTO[dmIdx:"+dmIdx+", dmSenderId:"+dmSenderId+", dmSenderNickname:"+dmSenderNickname+", dmSendDate:"+dmSendDate+", dmReceiverId:"+dmReceiverId+", dmReceiverNickname:"+dmReceiverNickname+", dmReceiveDate:"+dmReceiveDate+", dmTitle:"+dmTitle+", dmContent:"+dmContent+", dmFileDtoList:"+dmFileDtoList.toString();
		if(pageHelper!=null)result+=pageHelper.toString();
		if(searchHelper!=null)result+=searchHelper.toString();
		return result;
	}

	public List<DmFileDTO> getDmFileDtoList() {
		return dmFileDtoList;
	}

	public void setDmFileDtoList(List<DmFileDTO> dmFileDtoList) {
		this.dmFileDtoList = dmFileDtoList;
	}

	public PageHelper getPageHelper() {
		return pageHelper;
	}

	public void setPageHelper(PageHelper pageHelper) {
		this.pageHelper = pageHelper;
	}

	public SearchHelper getSearchHelper() {
		return searchHelper;
	}

	public void setSearchHelper(SearchHelper searchHelper) {
		this.searchHelper = searchHelper;
	}

	public int getDmIdx() {
		return dmIdx;
	}

	public void setDmIdx(int dmIdx) {
		this.dmIdx = dmIdx;
	}

	public String getDmSendDate() {
		return dmSendDate;
	}

	public void setDmSendDate(String dmSendDate) {
		this.dmSendDate = dmSendDate;
	}

	public String getDmReceiveDate() {
		return dmReceiveDate;
	}

	public void setDmReceiveDate(String dmReceiveDate) {
		this.dmReceiveDate = dmReceiveDate;
	}

	public String getDmTitle() {
		return dmTitle;
	}

	public void setDmTitle(String dmTitle) {
		this.dmTitle = dmTitle;
	}

	public String getDmContent() {
		return dmContent;
	}

	public void setDmContent(String dmContent) {
		this.dmContent = dmContent;
	}

	public String getDmSenderId() {
		return dmSenderId;
	}

	public void setDmSenderId(String dmSenderId) {
		this.dmSenderId = dmSenderId;
	}

	public String getDmSenderNickname() {
		return dmSenderNickname;
	}

	public void setDmSenderNickname(String dmSenderNickname) {
		this.dmSenderNickname = dmSenderNickname;
	}

	public String getDmReceiverId() {
		return dmReceiverId;
	}

	public void setDmReceiverId(String dmReceiverId) {
		this.dmReceiverId = dmReceiverId;
	}

	public String getDmReceiverNickname() {
		return dmReceiverNickname;
	}

	public void setDmReceiverNickname(String dmReceiverNickname) {
		this.dmReceiverNickname = dmReceiverNickname;
	}

}
