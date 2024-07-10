package com.winter.app.account;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.history.HistoryDTO;

@Service
public class AccountService {

	@Autowired
	private AccountDAO accountDAO;

	public int add(AccountDTO accountDTO) throws Exception {
		Calendar calendar = Calendar.getInstance();
		accountDTO.setAccount_number(calendar.getTimeInMillis() + ""); // 숫자를 문자로
		return accountDAO.add(accountDTO);
	}

	public AccountDTO detail(AccountDTO accountDTO) throws Exception {
		return accountDAO.detail(accountDTO);
	}

	public int transfer(HistoryDTO historyDTO) throws Exception {
		int a = accountDAO.transfer(historyDTO);
		int b = accountDAO.transfer_u(historyDTO);

		int c = accountDAO.pro_up(historyDTO);
		int d = accountDAO.pro_up_u(historyDTO);

		int result = a + b + c + d;

		return result;

	}

}
