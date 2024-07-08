package com.winter.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.account.AccountDAO;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private AccountDAO accountDAO;

	public int join(MemberDTO memberDTO) {
		return memberDAO.join(memberDTO);
	}

	public MemberDTO login(MemberDTO memberDTO) throws Exception { // 사용자가 입력한 id,pw
		// Map<String, Object> map = new HashMap<String, Object>();// 객체를 만들 수 있는 클래스 =
		// 구현클래스
		MemberDTO result = memberDAO.login(memberDTO); // 새로운 dto에 입력받은 정보를 넣음

		if (result != null) {// null이 아니면 id는 일치
			if (result.getMember_pwd().equals(memberDTO.getMember_pwd())) { // 입력받은 pw랑 디비에 pw랑 일치하면
				// 로그인 성공시점
				// List<AccountDTO> ar = accountDAO.list(memberDTO);
				// map.put("member", result); // memberDTO넣음
				// map.put("account", ar);
				return result;
			} else {
				result = null; // pw틀리면 null리턴돼서 로그인 안됨
			}
		}
		return result;
	}

	public MemberDTO myPage(MemberDTO memberDTO) {
		return memberDAO.myPage(memberDTO);
	}

	public int update(MemberDTO memberDTO) {
		return memberDAO.update(memberDTO);
	}

	public int delete(MemberDTO memberDTO) {
		return memberDAO.delete(memberDTO);
	}

}
