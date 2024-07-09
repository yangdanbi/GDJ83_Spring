package com.winter.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SampleTest extends DefaultTest {
	@AfterClass
	public static void afterAll() { // 모든 메서드가 끝나면 실행
		System.out.println("======= after All======="); // 8
	}

	@BeforeClass
	public static void beforeAll() {
		System.out.println("======= Before All======="); // 메서드 실행하기 전에 실행 1
	}

	@Before
	public void before() {
		System.out.println("*******before*******"); // test메서드를 각각 호출하기 전에 한번씩 실행 2 5
	}

	@After
	public void after() {
		System.out.println("*******after*******"); // test메서드가 끝나고 한번씩 실행 4 7
	}

	@Test
	public void t1() {
		System.out.println("t1 메서드"); // 3
		fail("---t1 실패---");
	}

	@Test
	public void t2() {
		System.out.println("t2 메서드"); // 6
		assertEquals(0, 0);
	}

}
