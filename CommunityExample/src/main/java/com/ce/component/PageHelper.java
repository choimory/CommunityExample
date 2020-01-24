package com.ce.component;

import java.util.ArrayList;
import java.util.List;

public class PageHelper {
	private int displayNum;
	
	private int listFirst;
	private int listLast;

	private int totalPage;
	private int page;
	private int groupFirst;
	private int groupLast;
	private List<Integer> pageGroup;
	
	private SearchHelper searchHelper;

	public PageHelper() {
		this.displayNum = 20;
		this.page = 1;
		this.totalPage = 1;
		list();
	}

	public PageHelper(int displayNum, int page, int totalRow) {
		setDisplayNum(displayNum);
		setTotalPage(totalRow, displayNum);
		setPage(page, totalRow, displayNum);
		list(displayNum, page, totalRow);
	}

	@Override
	public String toString() {
		System.out.println(displayNum + ", " + page + ", " + totalPage + ", " + listFirst + ", " + listLast + ", "
				+ groupFirst + ", " + groupLast);
		if (searchHelper != null)
			System.out.println(searchHelper.toString());
		return super.toString();
	}

	public void paging(int totalRow) {
		setTotalPage(totalRow);
		list();
		pagination2(totalRow);
	}

	public void setDisplayNum(int displayNum) {
		final int DISPLAYNUM_MAXIMUM = 100;
		final int DISPLAYNUM_MINIMUM = 20;

		if (displayNum > DISPLAYNUM_MAXIMUM || displayNum < DISPLAYNUM_MINIMUM) {
			this.displayNum = DISPLAYNUM_MINIMUM;
		} else {
			this.displayNum = displayNum;
		}
	}

	public void setPage(int page) {
		final int PAGE_MINIMUM = 1;

		if (page < PAGE_MINIMUM) {
			this.page = PAGE_MINIMUM;
		} else {
			this.page = page;
		}
	}

	public void setPage(int page, int totalRow) {
		final int PAGE_MINIMUM = 1;
		setTotalPage(totalRow);

		if (page < PAGE_MINIMUM) {
			this.page = PAGE_MINIMUM;
		} else if (page >= totalPage) {
			this.page = totalPage;
		} else {
			this.page = page;
		}
	}

	public void setPage(int page, int totalRow, int displayNum) {
		final int PAGE_MINIMUM = 1;
		setTotalPage(totalRow, displayNum);

		if (page < PAGE_MINIMUM) {
			this.page = PAGE_MINIMUM;
		} else if (page >= totalPage) {
			this.page = totalPage;
		} else {
			this.page = page;
		}
	}

	public void setTotalPage(int totalRow) {
		if (totalRow > displayNum) {
			double totalPageDouble = totalRow / displayNum;
			if (totalRow % displayNum != 0) {
				totalPageDouble++;
			}
			this.totalPage = (int) totalPageDouble;
			if (totalPage < page) {
				page = totalPage;
			}
		} else {
			this.totalPage = 1;
			if (totalPage < page) {
				page = totalPage;
			}
		}
	}

	public void setTotalPage(int totalRow, int displayNum) {
		if (totalRow > displayNum) {
			double totalPageDouble = totalRow / displayNum;
			if (totalRow % displayNum != 0) {
				totalPageDouble++;
			}
			this.totalPage = (int) totalPageDouble;
		} else {
			this.totalPage = 1;
		}
	}

	public int getDisplayNum() {
		return displayNum;
	}

	public List<Integer> getPageGroup() {
		return pageGroup;
	}

	public void setPageGroup(List<Integer> pageGroup) {
		this.pageGroup = pageGroup;
	}

	public SearchHelper getSearchHelper() {
		return searchHelper;
	}

	public void setSearchHelper(SearchHelper searchHelper) {
		this.searchHelper = searchHelper;
	}

	public int getPage() {
		return page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getListFirst() {
		return listFirst;
	}

	public void setListFirst(int listFirst) {
		this.listFirst = listFirst;
	}

	public int getListLast() {
		return listLast;
	}

	public void setListLast(int listLast) {
		this.listLast = listLast;
	}

	public int getGroupFirst() {
		return groupFirst;
	}

	public int getGroupLast() {
		return groupLast;
	}

	public void setGroupFirst(int groupFirst) {
		this.groupFirst = groupFirst;
	}

	public void setGroupLast(int groupLast) {
		this.groupLast = groupLast;
	}

	public void list() {
		listFirst = (page - 1) * displayNum;
		listLast = listFirst + (displayNum - 1);
	}

	public void list(int displayNum, int page, int totalRow) {
		setDisplayNum(displayNum);
		setPage(page, totalRow, displayNum);

		listFirst = (page - 1) * displayNum + 1;
		listLast = listFirst + (displayNum - 1);
	}

	public void pagination1(int totalRow) {
		this.pageGroup = new ArrayList<Integer>();
		final int GROUP_RANGE = 3;
		setTotalPage(totalRow);

		// groupFirst구하기
		if (page >= GROUP_RANGE + 1) {
			groupFirst = page - GROUP_RANGE;
		} else if (page <= GROUP_RANGE) {
			groupFirst = 1;
		}
		// groupLast구하기
		if (totalPage - page >= GROUP_RANGE + 1) {
			groupLast = page + GROUP_RANGE;
		} else if (totalPage - page <= GROUP_RANGE) {
			groupLast = totalPage;
		}

		// pageGroup완성하기
		for (int i = groupFirst; i <= groupLast; i++) {
			pageGroup.add(i);
		}
	}

	public void pagination1(int totalRow, int displayNum, int page) {
		this.pageGroup = new ArrayList<Integer>();
		final int GROUP_RANGE = 3;

		setDisplayNum(displayNum);
		setPage(page, totalRow, displayNum);
		setTotalPage(totalRow, displayNum);

		// groupFirst구하기
		if (page >= GROUP_RANGE + 1) {
			groupFirst = page - GROUP_RANGE;
		} else if (page <= GROUP_RANGE) {
			groupFirst = 1;
		}
		// groupLast구하기
		if (totalPage - page >= GROUP_RANGE + 1) {
			groupLast = page + GROUP_RANGE;
		} else if (totalPage - page <= GROUP_RANGE) {
			groupLast = totalPage;
		}

		// pageGroup완성하기
		for (int i = groupFirst; i <= groupLast; i++) {
			pageGroup.add(i);
		}
	}

	public void pagination2(int totalRow) {
		this.pageGroup = new ArrayList<Integer>();
		final int GROUP_RANGE_MINIMUM = 1;
		double groupRange = page / 10;

		setTotalPage(totalRow);

		// groupFirst구하기
		if (groupRange < GROUP_RANGE_MINIMUM) {
			groupFirst = 1;
		} else if (groupRange >= GROUP_RANGE_MINIMUM) {
			groupFirst = ((int) groupRange * 10) + 1;
		}
		// groupLast구하기
		if (groupRange < GROUP_RANGE_MINIMUM) {
			groupLast = 10;
			if (groupLast > totalPage) {
				groupLast = totalPage;
			}
		} else if (groupRange >= GROUP_RANGE_MINIMUM) {
			groupFirst = ((int) groupRange * 10) + 10;
			if (groupLast > totalPage) {
				groupLast = totalPage;
			}
		}
		// pageGroup완성하기
		for (int i = groupFirst; i <= groupLast; i++) {
			pageGroup.add(i);
		}
	}

	public void pagination2(int totalRow, int displayNum, int page) {
		this.pageGroup = new ArrayList<Integer>();
		final int GROUP_RANGE_MINIMUM = 1;
		double groupRange = page / 10;

		setDisplayNum(displayNum);
		setPage(page, totalRow, displayNum);
		setTotalPage(totalRow, displayNum);

		// groupFirst구하기
		if (groupRange < GROUP_RANGE_MINIMUM) {
			groupFirst = 1;
		} else if (groupRange >= GROUP_RANGE_MINIMUM) {
			groupFirst = ((int) groupRange * 10) + 1;
		}
		// groupLast구하기
		if (groupRange < GROUP_RANGE_MINIMUM) {
			groupLast = 10;
			if (groupLast > totalPage) {
				groupLast = totalPage;
			}
		} else if (groupRange >= GROUP_RANGE_MINIMUM) {
			groupFirst = ((int) groupRange * 10) + 10;
			if (groupLast > totalPage) {
				groupLast = totalPage;
			}
		}
		// pageGroup완성하기
		for (int i = groupFirst; i <= groupLast; i++) {
			pageGroup.add(i);
		}
	}
}
