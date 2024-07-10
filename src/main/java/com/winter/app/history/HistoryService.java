package com.winter.app.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.account.AccountDAO;
import com.winter.app.account.AccountDTO;

@Service
public class HistoryService {

	@Autowired
	private HistoryDAO historyDAO;

	@Autowired
	private AccountDAO accountDAO;

	public int history(HistoryDTO historyDTO) throws Exception {

		// historyDTO.setAccount_number("7");
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccount_number(historyDTO.getAccount_number());
		accountDTO = accountDAO.detail(accountDTO);

		if (accountDTO.getBalance() < historyDTO.getAmount()) {
			return 0;
		}

		historyDTO.setAmount(historyDTO.getAmount() * -1);
		historyDTO.setType("O");

		// 거래내역에 추가
		int result = historyDAO.add(historyDTO);

		// 거래내역 업데이트
		result = historyDAO.update(historyDTO);

		// 받는 dto로 수정
		historyDTO.setAccount_number(historyDTO.getReceive_number());
		historyDTO.setAmount(historyDTO.getAmount() * -1);
		historyDTO.setType("I");

		// 받는 계좌 거래내역 추가
		result = historyDAO.add(historyDTO);

		// 받는 계좌 업데이트
		result = historyDAO.update(historyDTO);

		return result;

	}

}
