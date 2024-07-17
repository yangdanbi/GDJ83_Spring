package com.winter.app.account;

import java.sql.Date;

public class HistoryDTO {
	private int history_id;
	// 받는 계좌번호 용
	private String account_number;

	// 보내는 계좌번호
	private String account_sender;
	private Date history_time;
	private int amount;
	private int balance;
	private String type;

	public int getHistory_id() {
		return history_id;
	}

	public void setHistory_id(int history_id) {
		this.history_id = history_id;
	}

	public String getAccount_number() {
		return account_number;
	}

	public String getAccount_sender() {
		return account_sender;
	}

	public void setAccount_sender(String account_sender) {
		this.account_sender = account_sender;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public Date getHistory_time() {
		return history_time;
	}

	public void setHistory_time(Date history_time) {
		this.history_time = history_time;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
