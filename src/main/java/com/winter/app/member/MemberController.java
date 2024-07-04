package com.winter.app.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void getlist() throws Exception {

	}

	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String getlist(MemberDTO memberDTO, Model model) throws Exception {
		System.out.println("MemberController join()");
		// System.out.println(memberDTO.getMember_name());

		int result = memberService.join(memberDTO);
		String url = "";
		if (result > 0) {
			url = "commons/message";
			model.addAttribute("result", "회원가입 성공했습니다.");
			model.addAttribute("url", "/");
		} else {
			url = "commons/message";
			model.addAttribute("result", "회원가입 실패했습니다.");
			model.addAttribute("url", "/");
		}
		return url;
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	// HttpServletRequest request
	public void login(Model model, @CookieValue(name = "remember", required = false, defaultValue = "") String value) {
//		Cookie[] cookies = request.getCookies();
//		for (Cookie c : cookies) {
//			if (c.getName().equals("remember")) {
//				request.setAttribute("id", c.getValue());
//			}
//		}
		model.addAttribute("id", value);

	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(MemberDTO memberDTO, Model model, String remember, HttpServletResponse response,
			HttpSession session) throws Exception {
		System.out.println(remember);
		String url = "";
		if (remember != null) {
			Cookie cookie = new Cookie("remember", memberDTO.getMember_id()); // 아이디 저장을 누르면 dto에 id를 꺼내서 cookie에 저장
			cookie.setMaxAge(60 * 60);
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("remember", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);

		}
		memberDTO = memberService.login(memberDTO);
		if (memberDTO != null) {
			session.setAttribute("member", memberDTO);

			url = "commons/message";
			model.addAttribute("result", "로그인 성공했습니다.");
			model.addAttribute("url", "/");
		} else {
			url = "commons/message";
			model.addAttribute("result", "아이디/비밀번호를 확인해주세요.");
			model.addAttribute("url", "/member/login");
		}
		return url;
		// System.out.println("MemberController login()");
		// System.out.println(memberDTO.getMember_id());
		// System.out.println(memberDTO.getMember_pwd());
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate(); // session의 유지시간을 0으로 설정

		return "redirect:/";

	}
}
