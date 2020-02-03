package com.ce.component;

public class SearchHelper {
	private String query;
	private String target;
	private String orderBy;
	private String bCategory;

	@Override
	public String toString() {
		String result="SearchHelper[query:"+query + ", target:" + target + ", orderBy:" + orderBy + ", bCategory:" + bCategory+"]";
		return result;
	}
	
	public SearchHelper() {
		this.target="both";
		this.bCategory="all";
	}	

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getbCategory() {
		return bCategory;
	}

	public void setbCategory(String bCategory) {
		this.bCategory = bCategory;
	}
}
