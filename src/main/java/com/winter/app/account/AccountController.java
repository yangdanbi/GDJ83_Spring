package com.winter.app.account;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.winter.app.member.MemberDTO;

@Controller
@RequestMapping("/account/*")
public class AccountController {
	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(AccountDTO accountDTO, HttpSession session) throws Exception {
		String name = ((MemberDTO) session.getAttribute("member")).getMember_id();
		accountDTO.setMember_id(name);
		int result = accountService.add(accountDTO);

		return "redirect:/";
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void detail(AccountDTO accountDTO, Model model) throws Exception {
		AccountDTO accountDTO2 = new AccountDTO();
		accountDTO2.setAccount_number(accountDTO.getAccount_number());
		accountDTO2 = accountService.detail(accountDTO);
		System.out.println(accountDTO.getAccount_number());
		System.out.println(accountDTO.getBalance());

		model.addAttribute("dto", accountDTO2);

	}
}
