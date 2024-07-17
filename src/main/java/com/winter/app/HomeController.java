package com.winter.app;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) { // HttpServletResponse response,
		// 하위 -> 상위 o
		// 상위 -> 하위 x
		System.out.println("qna_homeController");
		HttpSession httpSession = request.getSession();

		// 쿠키
		// 배열 문법 데이터타입[]
//		Cookie[] cookies = request.getCookies();
//		for (Cookie c : cookies) {
//			System.out.println(c.getName());
//			System.out.println(c.getValue());
//		}

//		Cookie cookie = new Cookie("test", "YDB");
//		cookie.setMaxAge(60);
//		response.addCookie(cookie);

		// 1
		Calendar ca = Calendar.getInstance();

		long l = ca.getTimeInMillis();
		String s = String.valueOf(1);

		return "index";
	}

}
