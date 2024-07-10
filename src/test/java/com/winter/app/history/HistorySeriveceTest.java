package com.winter.app.history;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.DefaultTest;

public class HistorySeriveceTest extends DefaultTest {

	@Autowired
	private HistoryService historyService;

	@Test
	public void transferTest() throws Exception {
		historyService.history(null);

		System.out.println("transferTest 테스트 완료");
	}

}
