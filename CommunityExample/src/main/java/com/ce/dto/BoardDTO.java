package com.ce.dto;

import java.io.Serializable;
import java.util.List;

import com.ce.component.PageHelper;
import com.ce.component.SearchHelper;

public class BoardDTO implements Serializable {
	private static final long serialVersionUID = -4303597499989713862L;
	private int bIdx;
	private String bId;
	private String bCategory;
	private String bTitle;
	private String bContent;
	private String mId;
	private String mNickname;
	private String bRegDate;
	private BoardInfoDTO boardInfoDto;
	private BoardTypeDTO boardTypeDto;
	private List<BoardFileDTO> boardFileDtoList;
	private PageHelper pageHelper;
	private SearchHelper searchHelper;

	public BoardDTO() {
	}

	public BoardDTO(String bId, PageHelper pageHelper) {
		this.bId = bId;
		this.pageHelper = pageHelper;
	}

	public BoardDTO(String bId, int bIdx) {
		this.bId = bId;
		this.bIdx = bIdx;
	}

	@Override
	public String toString() {
		String result="BoardDTO[bIdx: "+bIdx+", bId:"+bId+", bCategory:"+bCategory+", bTitle:"+bTitle+", bContent:"+bContent+", mId:"+mId+", mNickname:"+mNickname+", bRegdate:"+bRegDate+"]";
		if(boardInfoDto!=null)result+=boardInfoDto.toString();
		if(boardTypeDto!=null)result+=boardTypeDto.toString();
		if(pageHelper!=null)result+=pageHelper.toString();
		if(searchHelper!=null)result+=searchHelper.toString();
		return result;
	}

	public List<BoardFileDTO> getBoardFileDtoList() {
		return boardFileDtoList;
	}

	public void setBoardFileDtoList(List<BoardFileDTO> boardFileDtoList) {
		this.boardFileDtoList = boardFileDtoList;
	}

	public BoardTypeDTO getBoardTypeDto() {
		return boardTypeDto;
	}

	public void setBoardTypeDto(BoardTypeDTO boardTypeDto) {
		this.boardTypeDto = boardTypeDto;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
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

	public int getbIdx() {
		return bIdx;
	}

	public void setbIdx(int bIdx) {
		this.bIdx = bIdx;
	}

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

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getmNickname() {
		return mNickname;
	}

	public void setmNickname(String mNickname) {
		this.mNickname = mNickname;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public String getbRegDate() {
		return bRegDate;
	}

	public void setbRegDate(String bRegDate) {
		this.bRegDate = bRegDate;
	}

	public BoardInfoDTO getBoardInfoDto() {
		return boardInfoDto;
	}

	public void setBoardInfoDto(BoardInfoDTO boardInfoDto) {
		this.boardInfoDto = boardInfoDto;
	}

}
