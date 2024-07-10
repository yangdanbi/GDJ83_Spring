package com.winter.app.history;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.DefaultTest;

public class HistoryDAOTest extends DefaultTest {
	@Autowired
	private HistoryDAO historyDAO;

	private HistoryDTO historyDTO;

	@BeforeClass
	public static void beforeClass() {// 클래스가 실행될때 딱 한번

	}

	@Before
	public void before() {
		this.historyDTO = new HistoryDTO();
		historyDTO.setAccount_number("1720423025065");
		historyDTO.setAmount(1000 * -1);
		historyDTO.setType("O");
	}

	// @Test
	public void addTest() throws Exception {
		int result = historyDAO.add(historyDTO);
		assertEquals(1, result);

	}

	@Test
	public void updateTest() throws Exception {
		int result = historyDAO.update(historyDTO);
		assertNotEquals(0, result);

	}

	// @After
	public void after() {
		historyDTO = null;
	}

}
