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
		accountDTO = accountService.detail(accountDTO);
		model.addAttribute("dto", accountDTO);
	}

	@RequestMapping(value = "transfer", method = RequestMethod.GET)
	public void transfer(Model model, AccountDTO accountDTO) throws Exception {
		accountDTO = accountService.detail(accountDTO);
		model.addAttribute("dto", accountDTO);

	}

	@RequestMapping(value = "transfer", method = RequestMethod.POST)
	public String transfer(AccountDTO accountDTO, HistoryDTO historyDTO, Model model) throws Exception {
		System.out.println("내가 이체할 금액 : " + historyDTO.getAmount());
		System.out.println("이체할 계좌번호 : " + historyDTO.getAccount_number());
		String url = "";
		int result = accountService.transfer(historyDTO);
		System.out.println(result);
		if (result == 4) {
			url = "commons/message";
			model.addAttribute("result", "이체가 완료되었습니다.");
			model.addAttribute("url", "/member/mypage");
		} else {
			url = "commons/message";
			model.addAttribute("result", "계좌정보/잔액을 확인해주세요.");
			model.addAttribute("url", "/member/mypage");
		}
		return url;
		// "redirect:/";

	}
}
