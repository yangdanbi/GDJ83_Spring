package com.winter.app.account;

public class ListOption {
	private String account_number;
	private Integer order; // 0이면 desc 1 asc

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

}
