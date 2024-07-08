package com.winter.app.account;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.DefaultTest;

public class AccountDAOTest extends DefaultTest {

	@Autowired
	private AccountDAO accountDAO;

	@Test
	public void detailTest() throws Exception {
		AccountDTO accountDTO = new AccountDTO();

		accountDTO.setAccount_number("7");
		accountDTO = accountDAO.detail(accountDTO);

		assertNotNull(accountDTO);

	}

}
