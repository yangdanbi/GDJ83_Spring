package com.winter.app.account;

public class AccountDTO {
	private int product_id;
	private int join_date;
	private String account_number;
	private String member_id;
	private int balance;

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getJoin_date() {
		return join_date;
	}

	public void setJoin_date(int join_date) {
		this.join_date = join_date;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
