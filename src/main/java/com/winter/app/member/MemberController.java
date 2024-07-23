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
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.account.AccountDTO;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void join() throws Exception {

	}

	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(MemberDTO memberDTO, Model model, MultipartFile files, HttpSession session) throws Exception {
		System.out.println("MemberController join()");
		System.out.println("입력 : " + memberDTO.getMember_id());
		System.out.println("입력 : " + memberDTO.getMember_name());
		System.out.println("입력 : " + memberDTO.getMember_number());
		System.out.println("입력 : " + memberDTO.getMember_pwd());
		System.out.println("입력 : " + memberDTO.getPhone());

		int result = memberService.join(memberDTO, files, session);
		String url = "";
		System.out.println("입력2 : " + memberDTO.getMember_id());
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
	public String login(AccountDTO accountDTO, MemberDTO memberDTO, Model model, String remember,
			HttpServletResponse response, HttpSession session) throws Exception {
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
		// memberDTO = memberService.login(memberDTO);
		memberDTO = memberService.login(memberDTO);
		if (memberDTO != null) {// map에 dto가 담겨있음
			session.setAttribute("member", memberDTO);
			// session.setAttribute("account", accountDTO);

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
		// session의 유지시간을 0으로 설정하는법
		// 1
		session.invalidate();
		// 2
		// session.setAttribute("member", null);
		// 3
		// session.removeAttribute("member");
		// 4 (권장x)
		// session.removeValue("member");

		return "redirect:/";

	}

	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public void mypage(Model model, HttpSession session) throws Exception {
//		String url = "";
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		memberDTO = memberService.detail(memberDTO);
		// System.out.println(memberDTO.getMemberFileDTO().getFile_name());
		model.addAttribute("member", memberDTO);
//
//		if (session.getAttribute("member") == null) {
//			url = "commons/message";
//			model.addAttribute("result", "로그인 후 이용가능합니다.");
//			model.addAttribute("url", "/member/login");
//		} else {
//			url = "/member/mypage";
//
//		}
//
//		return url;

	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(Model model, HttpSession session) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		memberDTO = memberService.detail(memberDTO);
		model.addAttribute("member", memberDTO);

	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(MemberDTO memberDTO, HttpSession session, Model model) throws Exception { // dto에 정보가 저장
		MemberDTO user = (MemberDTO) session.getAttribute("member");
		memberDTO.setMember_id(user.getMember_id());
		int result = memberService.update(memberDTO);
		String url = "";
		if (result > 0) {
			url = "commons/message";
			model.addAttribute("result", "수정이 완료되었습니다.");
			model.addAttribute("url", "/member/mypage");
		}

		return url;
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(Model model, HttpSession session) {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		int result = memberService.delete(memberDTO);
		String url = "";
		if (result > 0) {
			session.invalidate(); // 세션에 담겨있는 dto값을 지워주면 로그아웃 된 페이지로 넘어가게 됨

			url = "commons/message";
			model.addAttribute("result", "탈퇴가 완료됐습니다.");
			model.addAttribute("url", "/");
			// url = "redirect:./";
			// url = "redirect:./";
		}
		return url;

	}

//	@RequestMapping(value = "test", method = RequestMethod.GET)
//	public void test(int n) {
//		String str = null;
//		// 참조변수에 null이 들어가서 에러발생
//		// 변수에 null을 넣는건 괜찮지만 null이 들어간 변수를 사용할때 에러가 남
//		System.out.println(str.toString());// nullPoint 에러 str이 null
//
//	}

}
