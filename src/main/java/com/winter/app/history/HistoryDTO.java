package com.winter.app.history;

import java.sql.Date;

public class HistoryDTO {
	private int history_id;

	// 받는 계좌번호 용
	private String receive_number;

	// 보내는 계좌번호
	private String account_number;

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

	public String getReceive_number() {
		return receive_number;
	}

	public void setReceive_number(String receive_number) {
		this.receive_number = receive_number;
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
