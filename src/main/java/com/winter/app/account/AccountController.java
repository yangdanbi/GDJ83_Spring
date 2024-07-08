package com.winter.app.account;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.winter.app.member.MemberDTO;

@Controller
@RequestMapping("/account/*")
public class AccountController {
	private AccountService accountService;

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(AccountDTO accountDTO, HttpSession session) throws Exception {
		String name = ((MemberDTO) session.getAttribute("member")).getMember_id();
		accountDTO.setMember_id(name);
		int result = accountService.add(accountDTO);

		return "redirect:/";
	}
}
