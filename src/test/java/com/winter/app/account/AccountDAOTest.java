package com.winter.app.account;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.DefaultTest;
import com.winter.app.history.HistoryDTO;

public class AccountDAOTest extends DefaultTest {

	@Autowired
	private AccountDAO accountDAO;

	@Test
	public void detailTest() throws Exception {
//		AccountDTO accountDTO = new AccountDTO();
//
//		accountDTO.setAccount_number("7");
//		accountDTO = accountDAO.detail(accountDTO);
//
//		assertNotNull(accountDTO);
		HistoryDTO historyDTO = new HistoryDTO();

		historyDTO.setAccount_number("7");
		historyDTO.setAmount(5000);

		int a = accountDAO.transfer(historyDTO);
		assertEquals(1, a);

	}

}
