package com.winter.app.util;

public class Pager {
	// 컬럼종류
	private String kind;

	// 검색어
	private String search;

	private Long stratRow;

	private Long lastRow;

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Long getStratRow() {
		return stratRow;
	}

	public void setStratRow(Long stratRow) {
		this.stratRow = stratRow;
	}

	public Long getLastRow() {
		return lastRow;
	}

	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

}
